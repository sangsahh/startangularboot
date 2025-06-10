package ko.spring.start.startangularboot.chat.Service;

import ko.spring.start.startangularboot.chat.Dto.ChatMessageDto;
import ko.spring.start.startangularboot.chat.Dto.ChatRequestDto;

public interface ChatService {

    void saveMessage(ChatMessageDto dto);

}
