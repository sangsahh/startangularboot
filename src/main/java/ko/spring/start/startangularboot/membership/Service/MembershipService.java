package ko.spring.start.startangularboot.membership.Service;


import ko.spring.start.startangularboot.membership.Dto.MembershipRequestDto;
import ko.spring.start.startangularboot.membership.Dto.MembershipResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface MembershipService {

    MembershipResponseDto setMembership(MembershipRequestDto membershipRequestDto, MultipartFile profileImage);

}
