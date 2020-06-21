package interfaces.presenter;

import interfaces.view.*;
import usecase.port.*;

public class DeleteToDoItemPresenter {
    private ConsoleView view = new ConsoleView();

    public void output(DeleteToDoItemOutputData outputData) {
        String msg = outputData.getOk() ? "deleted" : "failed to delete";     
        view.showDeleteToDoItem(msg);
    }
}