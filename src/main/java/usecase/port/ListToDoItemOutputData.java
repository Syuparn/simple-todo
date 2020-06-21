package usecase.port;

import domain.vo.ToDoItem;
import java.util.*;

public class ListToDoItemOutputData {
    private final List<ToDoItem> toDoItems;

    public ListToDoItemOutputData(List<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }
}
