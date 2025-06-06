package ko.spring.start.startangularboot.auth.Service;

import ko.spring.start.startangularboot.auth.Dto.AuthRequestDto;
import ko.spring.start.startangularboot.auth.Dto.AuthResponseDto;

public interface AuthService {

    AuthResponseDto login (AuthRequestDto authRequestDto);

}
