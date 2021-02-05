package com.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class MessageController {

    private HashMap<String, Message> messages = new HashMap<String, Message>();

    public HashMap<String, Message> getMessages() {
        return messages;
    }

    public void setMessages(Message message) {
        this.messages.put(message.getText(), message);
    }

    @GetMapping("/")
    public String getHello() {
        return "Hello World Automate Deploy V.4";
    }

    @GetMapping("/messages")
    public ResponseEntity<Data> getMessage() {
        Message[] messages = new Message[this.messages.size()];
        int index = 0;
        for(Map.Entry<String, Message> entry : this.messages.entrySet()) {
            messages[index] = entry.getValue();
            index++;
        }
        Data data = new Data(messages);
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/messages")
    public ResponseEntity<Response> postMessage(@RequestBody Message message) {
        Message messageStore = this.messages.get(message.getText());
        try {
            messageStore.setCount(messageStore.getCount()+1);
            setMessages(messageStore);
        }catch (NullPointerException e) {
            message.setCount(1);
            setMessages(message);
        }
        return ResponseEntity.ok().body(new Response("200", "post message success"));
    }

}
