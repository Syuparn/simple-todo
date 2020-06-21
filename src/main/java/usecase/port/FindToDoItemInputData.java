package usecase.port;

import java.util.*;
import domain.vo.Tag;

public class FindToDoItemInputData {
    private final Tag tag;

    public Tag tag() {
        return tag;
    }

    public FindToDoItemInputData(Tag tag) {
        this.tag = tag;
    }
}