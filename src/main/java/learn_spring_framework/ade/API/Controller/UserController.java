package learn_spring_framework.ade.API.Controller;

import learn_spring_framework.ade.DataLayer.Entity.User;
import learn_spring_framework.ade.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //All the methods here match the service class methods
    //LoginUser
    //RegisterUser
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
