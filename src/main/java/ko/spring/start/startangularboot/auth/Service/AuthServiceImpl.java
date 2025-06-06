package ko.spring.start.startangularboot.auth.Service;

import ko.spring.start.startangularboot.auth.Dto.AuthRequestDto;
import ko.spring.start.startangularboot.auth.Dto.AuthResponseDto;
import ko.spring.start.startangularboot.global.Security.JwtTokenProvider;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import ko.spring.start.startangularboot.membership.Repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MembershipRepository  membershipRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        AuthResponseDto authResponseDto = new AuthResponseDto();
        MembershipEntity membershipEntity = membershipRepository.findByEmail(authRequestDto.getEmail());

        if(!passwordEncoder.matches(authRequestDto.getPassword(), membershipEntity.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        String jwt = jwtTokenProvider.generateToken(authRequestDto.getEmail());

        authResponseDto.setToken(jwt);

        return  authResponseDto;

    }
}
