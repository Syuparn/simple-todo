package interfaces.presenter;

import interfaces.view.*;
import usecase.port.*;

public class CreateToDoItemPresenter implements CreateToDoItemOutputPort {
    private ConsoleView view = new ConsoleView();

    public void output(CreateToDoItemOutputData outputData) {
        String msg = outputData.getOk() ? "added" : "failed";
        view.showCreateToDoItem(String.format("%s: %s", msg, outputData.getToDoItem()));
    }
}