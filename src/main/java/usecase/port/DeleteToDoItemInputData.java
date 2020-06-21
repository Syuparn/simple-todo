package usecase.port;

import java.util.*;
import domain.vo.ToDoItem;

public class DeleteToDoItemInputData {
    private final ToDoItem toDoItem;

    public ToDoItem toDoItem() {
        return toDoItem;
    }

    public DeleteToDoItemInputData(ToDoItem toDoItem) {
        this.toDoItem = toDoItem;
    }
}