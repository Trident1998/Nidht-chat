package com.example.service;

import java.util.List;
import com.example.dao.MessageDao;
import com.example.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public Message save(Message message) {
        return messageDao.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    @Override
    public List<Message> getFiftyMessages() {
        return messageDao.getFiftyMessages();
    }

    @Override
    public void delete(Integer id) {
        messageDao.delete(id);
    }
}
