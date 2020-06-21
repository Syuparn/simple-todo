package interfaces.controller;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import domain.factory.ToDoItemFactory;
import domain.repository.ToDoItemRepository;
import domain.vo.Tag;
import domain.vo.ToDoItem;
import usecase.port.*;

public class ToDoItemController {
    private CreateToDoItemInputPort createToDoItemInputPort;
    private DeleteToDoItemInputPort deleteToDoItemInputPort;
    private FindToDoItemInputPort findToDoItemInputPort;
    private ListToDoItemInputPort listToDoItemInputPort;

    public void createToDoItem(String body, ToDoItemFactory factory) {
        // parse tags
        List<Tag> tags = extractTags(body);
        CreateToDoItemInputData inputData = new CreateToDoItemInputData(tags, body);
        createToDoItemInputPort.handle(inputData, factory);
    }

    public void deleteToDoItem(String body, ToDoItemRepository repository) {
        // parse tags
        List<Tag> tags = extractTags(body);
        ToDoItem toDoItem = new ToDoItem(tags, body);
        DeleteToDoItemInputData inputData = new DeleteToDoItemInputData(toDoItem);
        deleteToDoItemInputPort.handle(inputData, repository);
    }

    public void findToDoItem(String tagStr, ToDoItemRepository repository) {
        Tag tag = new Tag(tagStr);
        FindToDoItemInputData inputData = new FindToDoItemInputData(tag);
        findToDoItemInputPort.handle(inputData, repository);
    }

    public void listToDoItem(ToDoItemRepository repository) {
        ListToDoItemInputData inputData = new ListToDoItemInputData();
        listToDoItemInputPort.handle(inputData, repository);
    }

    private List<Tag> extractTags(String body) {
        List<Tag> tags = Arrays.asList(new Tag[] {});
        
        Pattern p = Pattern.compile("#([^ #]+)");
        Matcher m = p.matcher(body);
        while(m.find()){
            Tag tag = new Tag(m.group());
            tags.add(tag);
        }

        return tags;
    }

    public ToDoItemController(
        CreateToDoItemInputPort createToDoItemInputPort,
        FindToDoItemInputPort findToDoItemInputPort,
        ListToDoItemInputPort listToDoItemInputPort,
        DeleteToDoItemInputPort deleteToDoItemInputPort
    ) {
        this.createToDoItemInputPort = createToDoItemInputPort;
        this.deleteToDoItemInputPort = deleteToDoItemInputPort;
        this.findToDoItemInputPort = findToDoItemInputPort;
        this.listToDoItemInputPort = listToDoItemInputPort;
    }
}
