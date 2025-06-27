package org.example.test_st10.service;

import org.example.test_st10.interfaces.MessageService;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {
    @Override
    public String sendMessage() {
        return "Message sent via Email";
    }
}
