package hr.pejak.learning.spring.todo.services;

import hr.pejak.learning.spring.todo.api.ToDoItemService;
import hr.pejak.learning.spring.todo.model.ToDoData;
import hr.pejak.learning.spring.todo.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    // field
    private final ToDoData toDoData = new ToDoData();

    // public methods
    @Override
    public void addItem(TodoItem todoItem) {
        toDoData.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        toDoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return  toDoData.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        toDoData.updateItem(todoItem);
    }

    @Override
    public ToDoData getData() {
        return toDoData;
    }
}
