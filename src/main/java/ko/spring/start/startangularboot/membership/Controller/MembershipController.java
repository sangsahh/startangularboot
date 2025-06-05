package ko.spring.start.startangularboot.membership.Controller;


import ko.spring.start.startangularboot.membership.Dto.MembershipRequestDto;
import ko.spring.start.startangularboot.membership.Dto.MembershipResponseDto;
import ko.spring.start.startangularboot.membership.Service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping("/register")
    public MembershipResponseDto register(@ModelAttribute MembershipRequestDto membershipRequestDto,
        @RequestPart(value = "profileImage", required = false) MultipartFile profileImage) {
        return membershipService.setMembership(membershipRequestDto, profileImage);
    }

}
