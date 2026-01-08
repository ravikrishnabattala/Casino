package com.luck.game;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/")
public class GameController {

    private int secretNumber;

    public GameController() {
        generateNewNumber();
    }

    private void generateNewNumber() {
        this.secretNumber = new Random().nextInt(100) + 1;
        System.out.println("New secret number: " + secretNumber);
    }

    @GetMapping("/")
    public String home() {
        return """
                🎮 Welcome to Guess The Number Game!
                Guess a number between 1 and 100.
                Try: /50
                Restart game: /reset
                """;
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

    @GetMapping("/reset")
    public String reset() {
        generateNewNumber();
        return "🔄 Game restarted! Guess again.";
    }
}
