package com.example;

import java.time.LocalTime;
import com.example.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public Message mapToModel(MessageRequestDto dto) {
        Message message = new Message();
        message.setMessage(dto.getMessage());
        message.setUserName(dto.getUserName());
        message.setTime(LocalTime.now());
        return message;
    }
}
