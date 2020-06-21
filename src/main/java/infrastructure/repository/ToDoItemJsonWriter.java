package infrastructure.repository;

import java.util.*;
import domain.vo.ToDoItem;

interface ToDoItemJsonWriter {
    void write(List<ToDoItem> toDoItems);
}
