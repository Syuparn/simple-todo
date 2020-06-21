package domain.vo;

import java.util.List;

public class Tag {
    // NOTE: Java does not have type aliasing
    private final String tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Tag t = (Tag)o;
        return t.tag.equals(tag);
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    @Override
    public String toString() {
        return tag;
    }

    public String getTag() {
        return tag;
    }

    public Tag(String tag) {
        this.tag = tag;
    }

    public Tag() {
        super();
        this.tag = "";
    }
}