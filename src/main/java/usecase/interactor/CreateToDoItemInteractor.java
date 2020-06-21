package usecase.interactor;

import java.util.*;

import domain.factory.ToDoItemFactory;
import domain.repository.ToDoItemRepository;
import domain.vo.ToDoItem;
import usecase.port.CreateToDoItemInputData;
import usecase.port.CreateToDoItemInputPort;
import usecase.port.CreateToDoItemOutputData;
import usecase.port.CreateToDoItemOutputPort;

public class CreateToDoItemInteractor implements CreateToDoItemInputPort {
    private final CreateToDoItemOutputPort outputPort;

    public void handle(
        CreateToDoItemInputData inputData,
        ToDoItemFactory factory,
        ToDoItemRepository repository
    ) {
        ToDoItem toDoItem = factory.create(inputData.getTags(), inputData.getBody());
        boolean ok = repository.add(toDoItem, repository.list());
        CreateToDoItemOutputData outputData = new CreateToDoItemOutputData(toDoItem, ok);
        outputPort.output(outputData);
    }

    public CreateToDoItemInteractor(CreateToDoItemOutputPort outputPort) {
        this.outputPort = outputPort;
    }
}
