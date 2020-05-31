package Functionality1;

import java.io.IOException;

public class Root {

    // starting point of the application
    public static void main(String[] args) throws IOException {

        AllCharacters allCharacters=new AllCharacters();
        allCharacters.getAllCharacters();
    }
}
