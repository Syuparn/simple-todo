package usecase.port;

import domain.vo.ToDoItem;

public class CreateToDoItemOutputData {
    private final ToDoItem toDoItem;
    private boolean ok;

    public ToDoItem getToDoItem() {
        return toDoItem;
    }

    public boolean getOk() {
        return ok;
    }

    public CreateToDoItemOutputData(ToDoItem toDoItem, boolean ok) {
        this.toDoItem = toDoItem;
        this.ok = ok;
    }
}