package learn_spring_framework.ade.API.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequestDto {
    private String firstName;
    private String LastName;
    private String email;
    private String userName;
    private String password;
    //Request DTOs typically include only
    // the data needed from the client to perform an operation
    // (e.g., for creating or updating a resource). Output
}
