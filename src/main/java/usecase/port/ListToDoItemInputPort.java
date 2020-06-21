package usecase.port;

import domain.repository.ToDoItemRepository;

public interface ListToDoItemInputPort {
    void handle(ListToDoItemInputData inputData, ToDoItemRepository repository);
}
