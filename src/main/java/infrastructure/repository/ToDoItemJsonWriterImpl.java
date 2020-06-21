package infrastructure.repository;

import java.util.*;
import domain.vo.ToDoItem;

class ToDoItemJsonWriterImpl implements ToDoItemJsonWriter {
    private final String fileName;
    
    public void write(List<ToDoItem> toDoItems) {
        // TODO: impl
    }

    ToDoItemJsonWriterImpl(String fileName) {
        this.fileName = fileName;
    }
}
