package infrastructure.factory;

import java.util.*;
import domain.factory.*;
import domain.vo.*;

public class ToDoItemFactoryImpl implements ToDoItemFactory {
    public ToDoItem create(List<Tag> tags, String body) {
        return new ToDoItem(tags, body);
    }
}

