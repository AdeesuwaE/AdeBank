package learn_spring_framework.ade.API.Controller;

import learn_spring_framework.ade.API.Dto.User.LoginUserRequestDto;
import learn_spring_framework.ade.API.Dto.User.RegisterUserRequestDto;
import learn_spring_framework.ade.CustomException.UserNotFoundException;
import learn_spring_framework.ade.DataLayer.Entity.User;
import learn_spring_framework.ade.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //PostMapping is creating and updating
    //GetMapping is retrieving
    //DeleteMapping is delete
    @PostMapping("/register")
    public ResponseEntity<User> registerUsers(@RequestBody RegisterUserRequestDto user){
        User savedUser = userService.registerUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody LoginUserRequestDto request) {
        User registeredUser;
        try {
            registeredUser = userService.loginUser(request);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.ACCEPTED);
    }
}
