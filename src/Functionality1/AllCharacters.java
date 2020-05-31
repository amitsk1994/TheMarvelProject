package Functionality1;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AllCharacters{
    private static String baseApi="http://gateway.marvel.com/v1/public/characters?";
    private static String publicKey="";
    private static String privateKey="";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    private static String apiString;
    JSONObject json;
    JSONObject data;
    ExecutorService pool = Executors.newFixedThreadPool(10);

    public void getAllCharacters() throws IOException {

        createAPI();


        json = JsonReader.readJsonFromUrl(apiString);
        //System.out.println(json.toString());
        data = (JSONObject) json.get("data");
        int total= (int) data.get("total");
        System.out.println(total);
        for(int i=0;i<total;i+=50){
            Runnable task=new Task(apiString+"&offset="+i);
            pool.execute(task);
            //hitApi(apiString+"&offset="+i);
        }

       // System.out.println(results.toString());
        pool.shutdown();
    }



    private static void createAPI() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timeStampString=sdf.format(timestamp);

        MD5Utils md5=new MD5Utils(timeStampString+privateKey+publicKey);
        String md5String=md5.bytesToHex();
        apiString=baseApi+"ts="+timeStampString+"&apikey="+publicKey+"&hash="+md5String;
        System.out.println(apiString);
    }



}
