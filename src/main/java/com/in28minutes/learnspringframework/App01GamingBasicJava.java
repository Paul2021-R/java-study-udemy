package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;

public class App01GamingBasicJava {
    public static void main(String[] argv) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame(); // object creation
        var gameRunner = new GameRunner(game); // object creation + wiring of Dependencies
        gameRunner.run();
    }
}
