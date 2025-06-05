package ko.spring.start.startangularboot.membership.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import ko.spring.start.startangularboot.membership.Dto.MembershipRequestDto;
import ko.spring.start.startangularboot.membership.Dto.MembershipResponseDto;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import ko.spring.start.startangularboot.membership.Repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public MembershipResponseDto setMembership(MembershipRequestDto membershipRequestDto, MultipartFile profileImage) {
        String savedImagePath = null;
        MembershipResponseDto membershipResponseDto = new MembershipResponseDto();

        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                String uploadDir = "uploads/profile/";
                String fileName = UUID.randomUUID() + "_" + profileImage.getOriginalFilename();
                Path path = Paths.get(uploadDir + fileName);
                Files.createDirectories(path.getParent());
                Files.copy(profileImage.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                savedImagePath = path.toString();
            } catch (IOException e) {
                throw new RuntimeException("프로필 이미지 저장 실패", e);
            }
        }

        MembershipEntity membershipEntity = new MembershipEntity();
        membershipEntity.setEmail(membershipRequestDto.getEmail());
        membershipEntity.setPassword(passwordEncoder.encode(membershipRequestDto.getPassword()));
        membershipEntity.setNickname(membershipRequestDto.getNickname());
        membershipEntity.setProfileImagePath(savedImagePath);

        membershipRepository.save(membershipEntity);

        membershipResponseDto.setReturnCode("00");
        membershipResponseDto.setReturnMessage("success");

        return membershipResponseDto;
    }


}
