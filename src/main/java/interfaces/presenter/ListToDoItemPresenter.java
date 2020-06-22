package interfaces.presenter;

import java.util.stream.Stream;
import interfaces.view.*;
import usecase.port.*;

public class ListToDoItemPresenter implements ListToDoItemOutputPort {
    private ConsoleView view = new ConsoleView();

    public void output(ListToDoItemOutputData outputData) {
        Stream<String> lines = outputData.getToDoItems()
            .stream()
            .map(item -> item.toString());
        view.showListToDoItem(lines);
    }
}
