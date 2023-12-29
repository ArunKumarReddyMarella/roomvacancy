package com.example.MESSAGESERVICE.service;

import com.example.MESSAGESERVICE.entity.ChatMessage;

import java.util.List;

public interface MessageService {
    public List<ChatMessage> getAllMessages();

    public ChatMessage getMessage(Integer id);

    public ChatMessage createMessage(ChatMessage message);

    public ChatMessage updateMessage(ChatMessage message);

    public void deleteMessage(Integer id);
}
