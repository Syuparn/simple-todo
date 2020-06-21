package infrastructure.repository;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;
import domain.vo.ToDoItem;
import domain.vo.Tag;
import domain.repository.ToDoItemRepository;

public class ToDoItemRepositoryImpl implements ToDoItemRepository {
    private final ToDoItemJsonReader reader;
    private final ToDoItemJsonWriter writer;
    
    public List<ToDoItem> list() {
        String json = reader.read();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParanamerModule());
        
        // TODO: error handling
        try {
            List<ToDoItem> toDoItems = mapper.readValue(
            json, new TypeReference<List<ToDoItem>>(){});
            return toDoItems;
        } catch (JsonProcessingException e) {
            return Arrays.asList(new ToDoItem[] {});
        }
    }

    public List<ToDoItem> findBy(Tag tag) {
        // TODO: error handling
        List<ToDoItem> toDoItems = list();
        // TODO: filter
        return toDoItems;
    }

    public boolean delete(ToDoItem toDoItem) {
        // TODO: error handling
        List<ToDoItem> toDoItems = list();
        // TODO: filter and rewrite
        return false;
    }

    public ToDoItemRepositoryImpl(String jsonName) {
        this.reader = new ToDoItemJsonReaderImpl(jsonName);
        this.writer = new ToDoItemJsonWriterImpl(jsonName);
    }

    // NOTE: only for tests
    ToDoItemRepositoryImpl(ToDoItemJsonReader reader, ToDoItemJsonWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
}
