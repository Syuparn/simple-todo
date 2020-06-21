package infrastructure.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import domain.vo.ToDoItem;

class ToDoItemJsonWriterImpl implements ToDoItemJsonWriter {
    private final String fileName;
    
    public void write(String json) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ToDoItemJsonWriterImpl(String fileName) {
        this.fileName = fileName;
    }
}
