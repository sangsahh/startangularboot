package ko.spring.start.startangularboot.chat.Respository;

import ko.spring.start.startangularboot.chat.Entity.ChatRoom;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRespository extends
    JpaRepository<ChatRoom, Long> {
}
