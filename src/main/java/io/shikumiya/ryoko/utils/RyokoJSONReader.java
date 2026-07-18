package io.shikumiya.ryoko.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class RyokoJSONReader {

    public static void write(File file, Object content) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(content, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, Object> read(File file) {

        Gson gson = new GsonBuilder().create();
        Type type = new TypeToken<Map<String, Object>>() {}.getType();

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
