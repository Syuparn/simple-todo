package infrastructure.main;

import domain.factory.ToDoItemFactory;
import domain.repository.ToDoItemRepository;
import infrastructure.repository.ToDoItemRepositoryImpl;
import infrastructure.factory.ToDoItemFactoryImpl;
import interfaces.controller.ToDoItemController;
import interfaces.controller.ToDoItemControllerFactory;

public class MainHandler {
    private ToDoItemController controller;
    private ToDoItemRepository repository;
    private ToDoItemFactory factory;

    public void create(String bodyStr) {
        controller.createToDoItem(bodyStr, factory, repository);
    }

    public void delete(String bodyStr) {
        controller.deleteToDoItem(bodyStr, repository);
    }

    public void find(String tagStr) {
        controller.findToDoItem(tagStr, repository);
    }

    public void list() {
        controller.listToDoItem(repository);
    }

    public MainHandler(String jsonFileName) {
        this.controller = new ToDoItemControllerFactory().create();
        this.repository = new ToDoItemRepositoryImpl(jsonFileName);
        this.factory = new ToDoItemFactoryImpl();
    }
}