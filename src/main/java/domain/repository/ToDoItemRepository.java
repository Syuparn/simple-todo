package domain.repository;

import java.util.*;
import domain.vo.ToDoItem;
import domain.vo.Tag;

public interface ToDoItemRepository {
    List<ToDoItem> list();
    List<ToDoItem> findBy(Tag tag);
    boolean delete(ToDoItem toDoItem);
}
