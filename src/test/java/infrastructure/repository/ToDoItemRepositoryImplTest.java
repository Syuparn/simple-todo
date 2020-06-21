package infrastructure.repository;

import java.util.*;
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