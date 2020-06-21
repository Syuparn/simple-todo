package infrastructure.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class ToDoItemJsonReaderImpl implements ToDoItemJsonReader {
    private final String fileName;

    public String read() {
        try {
            return Files.readAllLines(Paths.get(fileName))
            .stream()
            .collect(Collectors.joining(" "));
        } catch (IOException e) {
            // TODO: error handling
            return "[]";
        }
    }

    ToDoItemJsonReaderImpl(String fileName) {
        this.fileName = fileName;
    }
}
