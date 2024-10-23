package learn_spring_framework.ade.Service;

import learn_spring_framework.ade.API.Dto.User.LoginUserRequestDto;
import learn_spring_framework.ade.API.Dto.User.RegisterUserRequestDto;
import learn_spring_framework.ade.CustomException.UserNotFoundException;
import learn_spring_framework.ade.DataLayer.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(RegisterUserRequestDto registerUserRequestDto);

    User loginUser(LoginUserRequestDto loginUserRequestDto) throws UserNotFoundException;


}
