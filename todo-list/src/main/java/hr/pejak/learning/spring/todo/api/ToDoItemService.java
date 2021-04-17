package hr.pejak.learning.spring.todo.api;

import hr.pejak.learning.spring.todo.model.ToDoData;
import hr.pejak.learning.spring.todo.model.TodoItem;

public interface ToDoItemService {

    void addItem(TodoItem todoItem);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem todoItem);

    ToDoData getData();
}
