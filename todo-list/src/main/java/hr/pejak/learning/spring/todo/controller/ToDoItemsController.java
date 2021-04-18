package hr.pejak.learning.spring.todo.controller;

import hr.pejak.learning.spring.todo.model.ToDoData;
import hr.pejak.learning.spring.todo.model.TodoItem;
import hr.pejak.learning.spring.todo.services.ToDoItemServiceImpl;
import hr.pejak.learning.spring.todo.utill.AttributeNames;
import hr.pejak.learning.spring.todo.utill.Mappings;
import hr.pejak.learning.spring.todo.utill.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class ToDoItemsController {

    // field
    private final ToDoItemServiceImpl toDoItemService;

    // constructor
    @Autowired
    public ToDoItemsController(ToDoItemServiceImpl toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    // model attributes
    @ModelAttribute("toDoData")
    public ToDoData toDoData() {
        return toDoItemService.getData();
    }

    // handler methods
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {

        log.info("Editing id is {}", id);
        TodoItem todoItem = toDoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("Values for from = {} ", todoItem);

        if (todoItem.getId()  == 0) {
            toDoItemService.addItem(todoItem);
        } else {
            toDoItemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        toDoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = toDoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;
    }

}
