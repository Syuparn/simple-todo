package usecase.port;

import domain.vo.ToDoItem;
import java.util.*;

public class FindToDoItemOutputData {
    private final List<ToDoItem> toDoItems;

    public List<ToDoItem> getToDoItems() {
        return toDoItems;
    }
    
    public FindToDoItemOutputData(List<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }
}