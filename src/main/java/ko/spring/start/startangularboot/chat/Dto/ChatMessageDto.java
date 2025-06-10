package ko.spring.start.startangularboot.chat.Dto;

import lombok.Data;

@Data
public class ChatMessageDto {
    private Long chatRoomId;
    private Long userId;
    private String message;
}
