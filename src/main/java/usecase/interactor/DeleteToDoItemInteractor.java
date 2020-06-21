package usecase.interactor;

import java.util.*;

import domain.repository.ToDoItemRepository;
import usecase.port.DeleteToDoItemInputData;
import usecase.port.DeleteToDoItemInputPort;
import usecase.port.DeleteToDoItemOutputData;
import usecase.port.DeleteToDoItemOutputPort;

public class DeleteToDoItemInteractor implements DeleteToDoItemInputPort {
    private final DeleteToDoItemOutputPort outputPort;

    public void handle(DeleteToDoItemInputData inputData, ToDoItemRepository repository) {
        boolean ok = repository.delete(inputData.getToDoItem(), repository.list());
        DeleteToDoItemOutputData outputData = new DeleteToDoItemOutputData(ok);
        outputPort.output(outputData);
    }
    
    public DeleteToDoItemInteractor(DeleteToDoItemOutputPort outputPort) {
        this.outputPort = outputPort;
    }
}