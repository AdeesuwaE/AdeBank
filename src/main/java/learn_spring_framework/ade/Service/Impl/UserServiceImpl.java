package learn_spring_framework.ade.Service.Impl;

import learn_spring_framework.ade.API.Dto.User.LoginUserRequestDto;
import learn_spring_framework.ade.API.Dto.User.RegisterUserRequestDto;
import learn_spring_framework.ade.CustomException.UserNotFoundException;
import learn_spring_framework.ade.DataLayer.Entity.User;
import learn_spring_framework.ade.DataLayer.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  {

    @Autowired
    private UserRepo userRepo;


    public User registerUser(RegisterUserRequestDto registerUserRequestDto) {
        User newUser = new User();
        newUser.setFirstName(registerUserRequestDto.getFirstName());
        newUser.setLastName(registerUserRequestDto.getLastName());
        newUser.setEmail(registerUserRequestDto.getEmail());
        newUser.setUserName(registerUserRequestDto.getUserName());
        newUser.setPassword(registerUserRequestDto.getPassword());
        return userRepo.save(newUser);
    }


    public User loginUser(LoginUserRequestDto loginUserRequestDto) throws UserNotFoundException {
       User newLoginUser =  userRepo.getUserByEmail(loginUserRequestDto.getEmail());
       if (newLoginUser.getPassword().equals(loginUserRequestDto.getPassword())){
           return newLoginUser;
       }else {
           throw new UserNotFoundException("User not found");
       }
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id) {
        Optional<User> savedUser = userRepo.findById(id);
        return savedUser;

    }

    public User deletelUser(Long id) {
        Optional <User> userToBeDeleted = userRepo.findById(id);

    }
}
