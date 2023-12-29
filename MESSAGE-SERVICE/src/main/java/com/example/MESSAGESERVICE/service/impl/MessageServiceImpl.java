package com.example.MESSAGESERVICE.service.impl;

import com.example.MESSAGESERVICE.entity.ChatMessage;
import com.example.MESSAGESERVICE.repository.MessageRepository;
import com.example.MESSAGESERVICE.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public List<ChatMessage> getAllMessages() {
        List<ChatMessage> messages = messageRepository.findAll();
        log.info(messages.toString());
        return messages;
    }

    @Override
    public ChatMessage getMessage(Integer id) {
        Optional<ChatMessage> message = messageRepository.findById(id);
        if(message.isEmpty())
            throw new RuntimeException("message not found");
        log.info(message.toString());
        return message.get();
    }

    @Override
    public ChatMessage createMessage(ChatMessage message) {
         ChatMessage createdMessage = messageRepository.saveAndFlush(message);
         return createdMessage;
    }

    @Override
    public ChatMessage updateMessage(ChatMessage message) {
         ChatMessage updatedMessage = messageRepository.saveAndFlush(message);
         return updatedMessage;
    }

    @Override
    public void deleteMessage(Integer id) {
        messageRepository.deleteById(id);
    }
}
