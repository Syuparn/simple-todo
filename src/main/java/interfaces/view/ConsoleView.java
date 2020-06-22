package interfaces.view;

import java.util.*;
import java.util.stream.Stream;

public class ConsoleView {
    public void showCreateToDoItem(String msg) {
        showHorizontalBar();
        System.out.println(msg);
        showHorizontalBar();
    }

    public void showListToDoItem(Stream<String> lines) {
        showHorizontalBar();
        lines.forEach(line -> System.out.println(line));
        showHorizontalBar();
    }

    public void showFindToDoItem(Stream<String> lines) {
        showHorizontalBar();
        lines.forEach(line -> System.out.println(line));
        showHorizontalBar();
    }

    public void showDeleteToDoItem(String msg) {
        showHorizontalBar();
        System.out.println(msg);
        showHorizontalBar();
    }

    private void showHorizontalBar() {
        int barLength = 30;
        String barStr = String.join("", Collections.nCopies(barLength, "-"));
        System.out.println(barStr);
    }
}
