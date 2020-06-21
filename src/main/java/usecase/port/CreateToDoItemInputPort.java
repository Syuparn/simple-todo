package usecase.port;

import domain.factory.ToDoItemFactory;

public interface CreateToDoItemInputPort {
    void handle(CreateToDoItemInputData inputData, ToDoItemFactory factory);
}