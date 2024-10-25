package learn_spring_framework.ade.Mapper;


import learn_spring_framework.ade.API.Dto.User.RegisterUserRequestDto;
import learn_spring_framework.ade.DataLayer.Entity.User;

//@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(RegisterUserRequestDto registerUserRequestDto);

    RegisterUserRequestDto toDto(User user);
}
