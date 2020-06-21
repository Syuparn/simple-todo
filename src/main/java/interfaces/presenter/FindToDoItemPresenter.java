package interfaces.presenter;

import java.util.stream.Stream;
import interfaces.view.*;
import usecase.port.*;

public class FindToDoItemPresenter implements FindToDoItemOutputPort {
    private ConsoleView view = new ConsoleView();

    public void output(FindToDoItemOutputData outputData) {
        Stream<String> lines = outputData.getToDoItems()
            .stream()
            .map(item -> item.toString());
        view.showFindToDoItem(lines);
    }
}