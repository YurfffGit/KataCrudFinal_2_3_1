package app.controller;


import app.dao.UserDaoImpl;
import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserDaoImpl userDao;

    @Autowired
    public UserController(UserDaoImpl userDao, UserService userService) {
        this.userDao = userDao;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        //Получить всех людей из ДБ и передать на отображение
        model.addAttribute("users", userDao.index());
        return "users/index";
    }

    @RequestMapping("/test1")
    public String home(Model model) {
        model.addAttribute("users", userService.listAll());
        return "users/startPage";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        // Получение человека по ид из ДБ и передача на отображение
        model.addAttribute("user", userDao.show(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userDao.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userDao.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}
