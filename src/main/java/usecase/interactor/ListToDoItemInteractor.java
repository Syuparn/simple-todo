package usecase.interactor;

import java.util.*;
import domain.vo.ToDoItem;
import domain.repository.ToDoItemRepository;
import usecase.port.ListToDoItemInputData;
import usecase.port.ListToDoItemInputPort;
import usecase.port.ListToDoItemOutputData;
import usecase.port.ListToDoItemOutputPort;

public class ListToDoItemInteractor implements ListToDoItemInputPort {
    private final ListToDoItemOutputPort outputPort;

    public void handle(ListToDoItemInputData inputData, ToDoItemRepository repository) {
        List<ToDoItem> toDoItems = repository.list();
        ListToDoItemOutputData outputData = new ListToDoItemOutputData(toDoItems);
        outputPort.output(outputData);
    }
    
    public ListToDoItemInteractor(ListToDoItemOutputPort outputPort) {
        this.outputPort = outputPort;
    }
}
