package usecase.interactor;

import java.util.*;

import domain.vo.ToDoItem;
import domain.repository.ToDoItemRepository;
import usecase.port.FindToDoItemInputData;
import usecase.port.FindToDoItemInputPort;
import usecase.port.FindToDoItemOutputData;
import usecase.port.FindToDoItemOutputPort;

public class FindToDoItemInteractor implements FindToDoItemInputPort {
    private final FindToDoItemOutputPort outputPort;

    public void handle(FindToDoItemInputData inputData, ToDoItemRepository repository) {
        List<ToDoItem> toDoItems = repository.findBy(inputData.getTag());
        FindToDoItemOutputData outputData = new FindToDoItemOutputData(toDoItems);
        outputPort.output(outputData);
    }

    public FindToDoItemInteractor(FindToDoItemOutputPort outputPort) {
        this.outputPort = outputPort;
    }
}