package domain.repository;

import java.util.*;
import domain.vo.ToDoItem;
import domain.vo.Tag;

public interface ToDoItemRepository {
    public List<ToDoItem> list();
    public List<ToDoItem> findBy(Tag tag);
    public boolean delete(ToDoItem toDoItem);
}
