package usecase.port;

import domain.repository.ToDoItemRepository;

public interface DeleteToDoItemInputPort {
    void handle(DeleteToDoItemInputData inputData, ToDoItemRepository repository);
}
