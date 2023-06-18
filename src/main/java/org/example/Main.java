package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/sampleArray.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONArray devices = (JSONArray) jsonObject.get("devices");

//            Using for loop to print values
            for (int i = 0; i < devices.size(); i++) {
                JSONObject device = (JSONObject) devices.get(i);
                System.out.println(device.get("name"));
            }


//            using for each will need to create a method
            devices.forEach(device -> parseJSONObject((JSONObject) device));


        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parseJSONObject(JSONObject device) {
        System.out.println(device.get("name"));
    }
}