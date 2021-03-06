package domain.repository;

import java.util.*;
import domain.vo.ToDoItem;
import domain.vo.Tag;

public interface ToDoItemRepository {
    boolean add(ToDoItem toDoItem, List<ToDoItem> toDoItems);
    List<ToDoItem> list();
    List<ToDoItem> findBy(Tag tag);
    boolean delete(ToDoItem toDelete, List<ToDoItem> toDoItems);
}
