package TFG.TFG.controllers;

import TFG.TFG.models.User;
import TFG.TFG.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//ESTO NO FUNCIONA. Solo funciona el /user, el resto nada.
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @RequestMapping ("user/email")
    public User findByEmail(String email){
        return userService.findById(email);
    }

    @GetMapping("/[{username}]")
    public User findByUsername(String username, String password){
        return userService.findByUsernameAndPassword(username, password);
    }

    @GetMapping("/{email}/{Password}")
    public User findByEmailAndPassword(String email, String password){
        return userService.findByEmailAndPassword(email, password);
    }

    @GetMapping("/save")
    public void save(User user){
        userService.save(user);
    }

    @GetMapping("/delete")
    public void delete(User user){
        userService.delete(user);
    }
}
