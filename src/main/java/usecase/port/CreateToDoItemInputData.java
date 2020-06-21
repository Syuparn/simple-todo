package usecase.port;

import java.util.*;
import domain.vo.Tag;

public class CreateToDoItemInputData {
    private final List<Tag> tags;
    private final String body;

    public List<Tag> tags() {
        return tags;
    }

    public String body() {
        return body;
    }

    public CreateToDoItemInputData(List<Tag> tags, String body) {
        this.tags = tags;
        this.body = body;
    }
}