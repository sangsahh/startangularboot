package ko.spring.start.startangularboot.chat.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "message")
@Getter
@Setter
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "chatroomid")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "userid")
    private MembershipEntity user;

    private String message;

    private LocalDateTime timestamp;
}
