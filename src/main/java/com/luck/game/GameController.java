package com.luck.game;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/")
public class GameController {

    private final int secretNumber;

    public GameController() {
        this.secretNumber = new Random().nextInt(100) + 1;
        System.out.println("Secret number is: " + secretNumber);
    }

    @GetMapping("/")
    public String home() {
        return "Game is running!";
    }

    @GetMapping("/{number:[0-9]+}")
    public String guess(@PathVariable("number") int number) {

        if (number > secretNumber) {
            return "Too High!";
        } else if (number < secretNumber) {
            return "Too Low!";
        } else {
            return "Correct! You found the number!";
        }
    }
}
