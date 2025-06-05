package ko.spring.start.startangularboot.membership.Repository;

import ko.spring.start.startangularboot.membership.Dto.MembershipRequestDto;
import ko.spring.start.startangularboot.membership.Dto.MembershipResponseDto;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends
    JpaRepository<MembershipEntity, Long> {




}
