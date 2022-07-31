package com.example.service;

import java.util.List;
import com.example.model.Message;

public interface MessageService {
    Message save(Message message);
    List<Message> getAllMessages();
    List<Message> getFiftyMessages();
    void delete(Integer id);
}
