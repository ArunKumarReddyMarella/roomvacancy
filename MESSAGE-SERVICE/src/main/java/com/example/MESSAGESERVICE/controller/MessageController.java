package com.example.MESSAGESERVICE.controller;

import com.example.MESSAGESERVICE.entity.ChatMessage;
import com.example.MESSAGESERVICE.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<ChatMessage>> getAllMessages() {
        List<ChatMessage> chatMessages;
        try {
            chatMessages = messageService.getAllMessages();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(chatMessages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatMessage> getMessage(@PathVariable Integer id) {
        ChatMessage chatMessage;
        try {
            chatMessage = messageService.getMessage(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(chatMessage);
    }

    @PostMapping
    public ResponseEntity<ChatMessage> createMessage(@RequestBody ChatMessage message){
        ChatMessage chatMessage;
        try{
            chatMessage = messageService.createMessage(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(chatMessage);
    }

    @PutMapping
    public ResponseEntity<ChatMessage> updateMessage(@RequestBody ChatMessage message){
        ChatMessage updatedMessage;
        try{
            updatedMessage = messageService.updateMessage(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(updatedMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMessage(@PathVariable Integer id){
        try {
            messageService.deleteMessage(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("deleted successfully");
    }
}
