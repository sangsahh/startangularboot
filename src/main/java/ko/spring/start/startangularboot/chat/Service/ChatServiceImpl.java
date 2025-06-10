package ko.spring.start.startangularboot.chat.Service;

import java.time.LocalDateTime;
import ko.spring.start.startangularboot.chat.Dto.ChatMessageDto;
import ko.spring.start.startangularboot.chat.Dto.ChatRequestDto;
import ko.spring.start.startangularboot.chat.Entity.ChatMessage;
import ko.spring.start.startangularboot.chat.Entity.ChatRoom;
import ko.spring.start.startangularboot.chat.Respository.ChatMessageRepository;
import ko.spring.start.startangularboot.chat.Respository.ChatRoomRespository;
import ko.spring.start.startangularboot.membership.Entity.MembershipEntity;
import ko.spring.start.startangularboot.membership.Repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRoomRespository chatRoomRespository;

    @Autowired
    private MembershipRepository userRepo;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public void saveMessage(ChatMessageDto dto) {
        ChatRoom room = chatRoomRespository.findById(dto.getChatRoomId()).orElseThrow();
        MembershipEntity  membershipEntity = userRepo.findById(dto.getUserId()).orElseThrow();

        ChatMessage message = new ChatMessage();
        message.setChatRoom(room);
        message.setUser(membershipEntity);
        message.setMessage(dto.getMessage());
        message.setTimestamp(LocalDateTime.now());

        chatMessageRepository.save(message);
    }

}
