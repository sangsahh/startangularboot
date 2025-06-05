package ko.spring.start.startangularboot.membership.Dto;

import lombok.Data;

@Data
public class MembershipRequestDto {

    private String email;
    private String password;
    private String nickname;

}
