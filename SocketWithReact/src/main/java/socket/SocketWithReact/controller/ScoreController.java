

package socket.SocketWithReact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:3000")
//@Controller
@RestController
public class ScoreController {
    static int count = 0;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/updateScore")
    @GetMapping("/updateScore")
    public void updateScore(String message) {
        System.out.println("Sending message to WebSocket: " + message + LocalDateTime.now());
        message = message + LocalDateTime.now();
        simpMessagingTemplate.convertAndSend("/topic/score", message); // Send the updated score to all WebSocket clients
    }
}




