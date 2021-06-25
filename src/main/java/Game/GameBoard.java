package Game;

import Game.Logic.GameLogic;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class GameBoard {

    private final ArrayList<Player> players = new ArrayList<Player>();
    private final GameLogic gameLogic = new GameLogic();
    private final Random random = new Random();

    public void openBoard() {
        setUp(List.of("Chet", "Pat", "Sue"));
        play();
    }

    public void play() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int diceRoll = random.nextInt(5) + 1;

            gameLogic.roll(player, diceRoll);
            playerAnswersQuestion(player);
            if (gameLogic.playerHasWon(player)) break;

            if (i == players.size() - 1) i = -1; //next round
        }



    }

    public void playerAnswersQuestion(Player player) {
        if (random.nextInt(9) == 0) {
            gameLogic.wrongAnswer(player);
        } else {
            gameLogic.wasCorrectlyAnswered(player);
        }
    }



    public void setUp(List<String> names) {
        for (String name : names) {
            addPlayer(name);
        }
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
        Announce.addedPlayer(playerName, players.size());
    }

    public boolean isPlayable() {
        return (players.size() > 1);
    }
}
