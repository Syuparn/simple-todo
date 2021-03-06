package domain.factory;

import java.util.*;
import domain.vo.ToDoItem;
import domain.vo.Tag;

public interface ToDoItemFactory {
    ToDoItem create(List<Tag> tags, String body);
}
