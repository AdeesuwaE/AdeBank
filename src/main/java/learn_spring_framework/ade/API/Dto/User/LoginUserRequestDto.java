package learn_spring_framework.ade.API.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserRequestDto {
    //No need for entity because this info will come from DB
    private String email;
    private String password;
}
