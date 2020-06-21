package interfaces.view;

import java.util.stream.Stream;

public class ConsoleView {
    public void showCreateToDoItem(String msg) {
        System.out.println(msg);
    }

    public void showListToDoItem(Stream<String> lines) {
        lines.forEach(line -> System.out.println(line));
    }

    public void showFindToDoItem(Stream<String> lines) {
        lines.forEach(line -> System.out.println(line));
    }

    public void showDeleteToDoItem(String msg) {
        System.out.println(msg);
    }
}