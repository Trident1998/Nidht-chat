package com.example.dao;

import java.util.List;
import com.example.model.Message;

public interface MessageDao {
    Message save(Message message);
    List<Message> getAllMessages();
    List<Message> getFiftyMessages();
    void delete(Integer id);
}
