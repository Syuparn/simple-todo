package interfaces.controller;

import usecase.interactor.*;
import interfaces.presenter.*;

public class ToDoItemControllerFactory {
    public ToDoItemController create() {
        return new ToDoItemController(
            new CreateToDoItemInteractor(new CreateToDoItemPresenter()),
            new DeleteToDoItemInteractor(new DeleteToDoItemPresenter()),
            new FindToDoItemInteractor(new FindToDoItemPresenter()),
            new ListToDoItemInteractor(new ListToDoItemPresenter())
        );
    }    
}
