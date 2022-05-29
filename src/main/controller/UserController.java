package main.controller;

import main.model.User;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class UserController {


    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView home() {
        List<User> listUser = service.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listUser", listUser);
        return mav;
    }
    @GetMapping("/new")
    public String newUserForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "new_user";
    }
    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = service.get(id);
        mav.addObject("user", user);

        return mav;
    }
    @GetMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        service.delete(id);
        return "redirect:/";
    }
}
