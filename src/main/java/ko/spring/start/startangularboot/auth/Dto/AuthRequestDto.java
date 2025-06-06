package ko.spring.start.startangularboot.auth.Dto;

import lombok.Data;

@Data
public class AuthRequestDto {

    private String email;
    private String password;

}
