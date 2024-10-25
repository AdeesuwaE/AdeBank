package learn_spring_framework.ade.Service.Impl;

import learn_spring_framework.ade.API.Dto.User.LoginUserRequestDto;
import learn_spring_framework.ade.API.Dto.User.RegisterUserRequestDto;
import learn_spring_framework.ade.CustomException.UserNotFoundException;
import learn_spring_framework.ade.DataLayer.Entity.User;
import learn_spring_framework.ade.DataLayer.Repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class UserServiceImplTest {

    // Mock all the repos i will be making use of in the test

    @Mock // use on the class that's being injected in the tested class
    private UserRepo userRepo;

    @InjectMocks //Use this on the class being tested, can work only on class. Used to inject mock in the class
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void registerUser() {
        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto("Alice","Ken","lk@gmail.com", "Lken", "Lken@");
        registerUserRequestDto.setFirstName("Alice");
        registerUserRequestDto.setLastName("Ken");
        registerUserRequestDto.setEmail("aKen@gmail.com");
        registerUserRequestDto.setUserName("aKen");
        registerUserRequestDto.setPassword("aken@");

        User user = new User();
        user.setFirstName("Alice");
        user.setLastName("Ken");
        user.setUserName("aKen");
        user.setEmail("aKen@gmail.com");
        user.setPassword("aKen@");

        when(userRepo.save(any(User.class))).thenReturn(user);

        User result = userService.registerUser(registerUserRequestDto);

        assertNotNull(result);
        assertEquals("Alice", result.getFirstName());
        assertEquals("Ken", result.getLastName());
        assertEquals("aKen@gmail.com", result.getEmail());
        assertEquals("aKen", result.getUserName());
        assertEquals("aKen@", result.getPassword());

        verify(userRepo).save(any(User.class));
    }

    @Test
    void loginUser() throws UserNotFoundException {
        LoginUserRequestDto loginUserRequestDto = new LoginUserRequestDto("aKen@gmail.com","aken@");
        loginUserRequestDto.setEmail("aKen@gmail.com");
        loginUserRequestDto.setPassword("aKen@");

        User user = new User();
        user.setEmail("aKen@gmail.com");
        user.setPassword("aKen@");

        when(userRepo.save(any(User.class))).thenReturn(new User(8L,"Alice", "Ken", "aKen@gmail.com","aKen","aken@"));
        when(userRepo.getUserByEmail("aKen@gmail.com")).thenReturn(user);

        User result1 = userService.loginUser(loginUserRequestDto);


        assertNotNull(result1);
        assertEquals("aKen@gmail.com", result1.getEmail());
        assertEquals("aKen@", result1.getPassword());

        verify(userRepo).getUserByEmail("aKen@gmail.com");
    }


}