package learn_spring_framework.ade.Service.Impl;

import learn_spring_framework.ade.API.Dto.User.LoginUserRequestDto;
import learn_spring_framework.ade.API.Dto.User.RegisterUserRequestDto;
import learn_spring_framework.ade.CustomException.UserNotFoundException;
import learn_spring_framework.ade.DataLayer.Entity.User;
import learn_spring_framework.ade.DataLayer.Repository.UserRepo;
import learn_spring_framework.ade.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerUser(RegisterUserRequestDto registerUserRequestDto) {
        User newUser = User.builder()
                .firstName(registerUserRequestDto.getFirstName())
                .lastName(registerUserRequestDto.getLastName())
                .email(registerUserRequestDto.getEmail())
                .userName(registerUserRequestDto.getUserName())
                .password(registerUserRequestDto.getPassword())
                .build();

        return userRepo.save(newUser);
    }


    @Override
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
}
