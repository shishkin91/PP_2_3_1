package main.controller;

import main.model.User;
import main.service.UserService;
import main.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class UserController {


    @Autowired
    private final UserService imp;

    public UserController(UserService imp) {
        this.imp = imp;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        List<User> listUser = imp.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listUser", listUser);
        return mav;
    }
    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "new_user";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("user") User user) {
        imp.save(user);
        return "redirect:/";
    }
    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = imp.get(id);
        mav.addObject("user", user);

        return mav;
    }
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        imp.delete(id);
        return "redirect:/";
    }
}
