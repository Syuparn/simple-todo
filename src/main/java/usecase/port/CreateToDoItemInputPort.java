package usecase.port;

import domain.factory.ToDoItemFactory;
import domain.repository.ToDoItemRepository;

public interface CreateToDoItemInputPort {
    void handle(
        CreateToDoItemInputData inputData,
        ToDoItemFactory factory,
        ToDoItemRepository repository
    );
}