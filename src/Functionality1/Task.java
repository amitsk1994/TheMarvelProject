package Functionality1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Task implements Runnable {
    String api;
    private static JSONObject json;
    private static JSONObject data;
    public Task(String api){
        this.api=api;
    }
    @Override
    public void run() {
        try
        {
        hitApi(api);
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void hitApi(String api) throws IOException {
        json = JsonReader.readJsonFromUrl(api);
        data = (JSONObject) json.get("data");
        JSONArray results= (JSONArray) data.get("results");
        for(int i=0;i<results.length();i++){
            JSONObject eachArrayElement=results.getJSONObject(i);
            System.out.println(eachArrayElement.getString("name"));
        }
    }
}
