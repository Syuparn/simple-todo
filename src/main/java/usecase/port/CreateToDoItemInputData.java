package usecase.port;

import java.util.*;
import domain.vo.Tag;

public class CreateToDoItemInputData {
    private final List<Tag> tags;
    private final String body;

    public List<Tag> getTags() {
        return tags;
    }

    public String getBody() {
        return body;
    }

    public CreateToDoItemInputData(List<Tag> tags, String body) {
        this.tags = tags;
        this.body = body;
    }
}