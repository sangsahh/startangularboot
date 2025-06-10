package ko.spring.start.startangularboot.chat.Respository;

import ko.spring.start.startangularboot.chat.Entity.ChatMessage;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends
    JpaRepository<ChatMessage, Long> {

}
