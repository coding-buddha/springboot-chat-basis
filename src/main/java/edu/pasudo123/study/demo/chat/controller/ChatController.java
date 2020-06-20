package edu.pasudo123.study.demo.chat.controller;

import edu.pasudo123.study.demo.chat.model.MessageModel;
import edu.pasudo123.study.demo.chat.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message){
        log.info("handling Send message : {}, to : {}", message, to);
        if(UserStorage.getInstance().getUsers().contains(to)){
            simpMessagingTemplate.convertAndSend("/topic/message/" + to, message);
        }
    }
}
