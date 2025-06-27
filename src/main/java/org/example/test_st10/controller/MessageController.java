package org.example.test_st10.controller;

import org.example.test_st10.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping("/message")
    public String sendMessage() {
        return messageService.sendMessage();
    }
}
