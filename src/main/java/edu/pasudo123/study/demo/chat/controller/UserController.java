package edu.pasudo123.study.demo.chat.controller;

import edu.pasudo123.study.demo.chat.storage.UserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
@Slf4j
public class UserController {

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable("userName") String userName){
        log.info("handling Register user request : {}", userName);

        try {
            UserStorage.getInstance().addUserName(userName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/users")
    public ResponseEntity<Set<String>> fetchAll(){
        return ResponseEntity.ok().body(UserStorage.getInstance().getUsers());
    }
}
