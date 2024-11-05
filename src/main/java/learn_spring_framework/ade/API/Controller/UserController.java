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
import java.util.Optional;

@RestController
@RequestMapping("/users")
//Used to define controllers in the web application
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //All the methods here match the service class methods
    //LoginUser
    //RegisterUser
    //PostMapping is creating
    // PutMapping is updating
    //PatchMapping is updating just a part
    //GetMapping is retrieving
    //DeleteMapping is delete

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
        //return List.of(new User(1L, "Alice", "Ken", "Aken@gmail.com", "aKen", "@Aken23"),
       // new User(2L, "Ali", "Ke", "Aken@gmail.com", "aKen", "@Aken24"),
        //new User(4L, "Ali", "Ke", "Aken@gmail.com", "aKen", "@Aken24"));

    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable Long id ){
        //return new User(3L, "Alice", "Ken", "Aken@gmail.com", "aKen", "@Aken23");
        return userService.findById(id);
    }

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

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        return
    }
}
