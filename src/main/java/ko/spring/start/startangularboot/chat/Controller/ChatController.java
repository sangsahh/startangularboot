package ko.spring.start.startangularboot.chat.Controller;

import ko.spring.start.startangularboot.chat.Dto.ChatMessageDto;
import ko.spring.start.startangularboot.chat.Dto.ChatRequestDto;
import ko.spring.start.startangularboot.chat.Dto.ChatResponseDto;
import ko.spring.start.startangularboot.chat.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat.sendMessage") //클라이언트 -> 서버
    @SendTo("/topic/chatroom/{chatRoomId}") // 서버-> 클라이언트
    public ChatMessageDto sendMessage(@Payload ChatMessageDto dto,
                                        @DestinationVariable Long chatRoomId) {

        //저장 및 브로드캐스트 메시지 생성
        chatService.saveMessage(dto);
        return dto;

    }

}
