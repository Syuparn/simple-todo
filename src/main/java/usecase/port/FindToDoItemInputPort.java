package usecase.port;

import domain.repository.ToDoItemRepository;

public interface FindToDoItemInputPort {
    void handle(FindToDoItemInputData inputData, ToDoItemRepository repository);
}
