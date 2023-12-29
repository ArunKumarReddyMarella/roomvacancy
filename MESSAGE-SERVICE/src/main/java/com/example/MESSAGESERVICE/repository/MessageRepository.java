package com.example.MESSAGESERVICE.repository;

import com.example.MESSAGESERVICE.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<ChatMessage,Integer> {
}
