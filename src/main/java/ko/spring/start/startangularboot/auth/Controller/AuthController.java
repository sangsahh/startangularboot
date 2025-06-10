package ko.spring.start.startangularboot.auth.Controller;

import ko.spring.start.startangularboot.auth.Dto.AuthRequestDto;
import ko.spring.start.startangularboot.auth.Dto.AuthResponseDto;
import ko.spring.start.startangularboot.auth.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto authRequestDto) {
        return authService.login(authRequestDto);
    }

    @GetMapping("/test")
    public AuthResponseDto login(){
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setToken("token");
        return authResponseDto;
    }

}
