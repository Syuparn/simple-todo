package usecase.port;

import domain.vo.ToDoItem;

public class CreateToDoItemOutputData {
    private final ToDoItem toDoItem;

    public CreateToDoItemOutputData(ToDoItem toDoItem) {
        this.toDoItem = toDoItem;
    }
}