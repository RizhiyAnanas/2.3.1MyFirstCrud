package fedorenko.spring.security.controller;

import fedorenko.spring.security.model.User;
import fedorenko.spring.security.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class MyController {



    @Autowired
    Service service;

    @GetMapping("/new")
    public String createNewUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping("/hello")
    public String hello(){return "helloworld";}

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        service.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", service.show(id));
        return "show";
    }


    @GetMapping
    public String showList(Model model){
        List<User> list = service.getList();
        model.addAttribute("users", list);
        return "users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        service.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", service.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,@PathVariable("id") Long id ){
        service.update(user, id);
        return "redirect:/admin";
    }
}
