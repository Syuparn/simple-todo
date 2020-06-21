package domain.vo;

import java.util.List;

public final class ToDoItem {
    private final List<Tag> tags;
    private final String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        ToDoItem i = (ToDoItem)o;
        return i.body == body;
    }

    @Override
    public int hashCode() {
        return body.hashCode();
    }

    @Override
    public String toString() {
        return body;
    }

    public String body() {
        return body;
    }

    public List<Tag> tags() {
        return tags;
    }

    public ToDoItem(List<Tag> tags, String body) {
        this.tags = tags;
        this.body = body;
    }
}
