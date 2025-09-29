package csc207.todo_list;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToDoList {
    private void loadJsonFromFile() {
        ensureJsonExists();
        JSONArray jsonArray = readJsonFile();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String task = jsonObject.getString("task");
            boolean completed = jsonObject.getBoolean("completed");
            if (completed) {
                task += DONE;
            }
            textModel.addElement(task);
        }
    }

    private static void ensureJsonExists() {
        Path resourcesDir = Paths.get(SAVE_DIR);
        if (!Files.exists(resourcesDir)) {
            try {
                Files.createDirectories(resourcesDir);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create save file directory", e);
            }
        }

        Path resourcesJsonFile = Paths.get(SAVEFILE_TODO_LIST_JSON);
        if (!Files.exists(resourcesJsonFile)) {
            try {
                Files.createFile(resourcesJsonFile);
                Files.write(resourcesJsonFile, "[]".getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Failed to create todo_list.json file", e);
            }
        }
    }

    private JSONArray readJsonFile() {
        String jsonString;
        try {
            jsonString = Files.readString(Paths.get(SAVEFILE_TODO_LIST_JSON));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new JSONArray(jsonString);
    }
}
