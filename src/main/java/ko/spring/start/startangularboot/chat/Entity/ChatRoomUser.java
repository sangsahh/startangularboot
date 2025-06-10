package ko.spring.start.startangularboot.chat.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chatroomuser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChatRoomUserId.class)
public class ChatRoomUser {

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    private MembershipEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name = "chatroomid")
    private ChatRoom chatRoom;


}
