package infrastructure.repository;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import domain.vo.ToDoItem;
import domain.vo.Tag;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoItemRepositoryImplTest {
    @Test
    public void testList() {
        class TestCase {
            final String input;
            final List<ToDoItem> expected;

            TestCase(String input, List<ToDoItem> expected) {
                this.input = input;
                this.expected = expected;
            }
        }

        TestCase[] testCases = {
            new TestCase(
                "[]",
                Arrays.asList(new ToDoItem[] {})
            ),
            new TestCase(
                "[{\"tags\": [{\"tag\": \"hoge\"}], \"body\": \"ABC #hoge\"}]",
                Arrays.asList(new ToDoItem[] {
                    new ToDoItem(
                        Arrays.asList(new Tag[] {new Tag("hoge")}),
                        "ABC #hoge"
                    )
                })
            ),
            new TestCase(
                "[{\"tags\": [{\"tag\": \"hoge\"}], \"body\": \"ABC #hoge\"}," +
                " {\"tags\": [], \"body\": \"DE\"}]",
                Arrays.asList(new ToDoItem[] {
                    new ToDoItem(
                        Arrays.asList(new Tag[] {new Tag("hoge")}),
                        "ABC #hoge"
                    ),
                    new ToDoItem(
                        Arrays.asList(new Tag[] {}),
                        "DE"
                    )
                })
            ),
        };

        for (TestCase tc : testCases) {
            MockToDoItemJsonReader reader = new MockToDoItemJsonReader(tc.input);
            MockToDoItemJsonWriter writer = new MockToDoItemJsonWriter();
            ToDoItemRepositoryImpl repo = new ToDoItemRepositoryImpl(reader, writer);

            List<ToDoItem> actual = repo.list();
            assertEquals(tc.expected, actual, "wrong value");
            assertEquals(
                tc.expected.stream().map(item -> item.getTags()).collect(Collectors.toList()),
                actual.stream().map(item -> item.getTags()).collect(Collectors.toList()),
                "wrong tags");
        }
    }

    @Test
    public void testFindBy() {
        class TestCase {
            final String input;
            final Tag tag;
            final List<ToDoItem> expected;

            TestCase(String input, Tag tag, List<ToDoItem> expected) {
                this.input = input;
                this.tag = tag;
                this.expected = expected;
            }
        }

        TestCase[] testCases = {
            new TestCase(
                "[]",
                new Tag("hoge"),
                Arrays.asList(new ToDoItem[] {})
            ),
            new TestCase(
                "[{\"tags\": [{\"tag\": \"hoge\"}], \"body\": \"ABC #hoge\"}]",
                new Tag("hoge"),
                Arrays.asList(new ToDoItem[] {
                    new ToDoItem(
                        Arrays.asList(new Tag[] {new Tag("hoge")}),
                        "ABC #hoge"
                    )
                })
            ),
            new TestCase(
                "[{\"tags\": [{\"tag\": \"hoge\"}], \"body\": \"ABC #hoge\"}," +
                " {\"tags\": [{\"tag\": \"fuga\"}], \"body\": \"DE #fuga\"}]",
                new Tag("hoge"),
                Arrays.asList(new ToDoItem[] {
                    new ToDoItem(
                        Arrays.asList(new Tag[] {new Tag("hoge")}),
                        "ABC #hoge"
                    )
                })
            ),
            // multiple tags
            new TestCase(
                "[{\"tags\": [{\"tag\": \"hoge\"}, {\"tag\": \"foo\"}], \"body\": \"ABC #hoge #foo\"}," +
                " {\"tags\": [{\"tag\": \"fuga\"}, {\"tag\": \"hoge\"}], \"body\": \"DE #fuga #hoge\"}," +
                " {\"tags\": [{\"tag\": \"foo\"}, {\"tag\": \"bar\"}], \"body\": \"F #foo #bar\"}]",
                new Tag("foo"),
                Arrays.asList(new ToDoItem[] {
                    new ToDoItem(
                        Arrays.asList(new Tag[] {new Tag("hoge"), new Tag("foo")}),
                        "ABC #hoge #foo"
                    ),
                    new ToDoItem(
                        Arrays.asList(new Tag[] {new Tag("foo"), new Tag("bar")}),
                        "F #foo #bar"
                    )
                })
            ),
        };

        for (TestCase tc : testCases) {
            MockToDoItemJsonReader reader = new MockToDoItemJsonReader(tc.input);
            MockToDoItemJsonWriter writer = new MockToDoItemJsonWriter();
            ToDoItemRepositoryImpl repo = new ToDoItemRepositoryImpl(reader, writer);

            List<ToDoItem> actual = repo.findBy(tc.tag);
            assertEquals(tc.expected, actual, "wrong value");
            assertEquals(
                tc.expected.stream().map(item -> item.getTags()).collect(Collectors.toList()),
                actual.stream().map(item -> item.getTags()).collect(Collectors.toList()),
                "wrong tags");
        }
    }
}

class MockToDoItemJsonReader implements ToDoItemJsonReader {
    private final String json;
    
    public String read() {
        return json;
    }

    MockToDoItemJsonReader(String json) {
        this.json = json;
    }
}

class MockToDoItemJsonWriter implements ToDoItemJsonWriter {
    private List<ToDoItem> output;
    
    public void write(List<ToDoItem> toDoItems) {
        output = toDoItems;
    }

    List<ToDoItem> output() {
        return output;
    }
}