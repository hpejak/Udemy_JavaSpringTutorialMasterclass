package hr.pejak.learning.spring.todo.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ToDoData {
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    public ToDoData() {
        addItem(new TodoItem("firsItem", "First Item Details", LocalDate.now()));
        addItem(new TodoItem("secondItem", "Second Item Details", LocalDate.now()));
        addItem(new TodoItem("thirdItem", "Third Item Details", LocalDate.now()));
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem item) {
        item.setId(idValue);
        items.add(item);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            TodoItem item = itemListIterator.next();

            if (item.getId() == id) {
                itemListIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem itemUpdate) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            TodoItem item = itemListIterator.next();

            if (item.equals(itemUpdate)) {
                itemListIterator.set(itemUpdate);
                break;
            }
        }
    }

}
