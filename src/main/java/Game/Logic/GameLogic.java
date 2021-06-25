package Game.Logic;

import Game.Announce;
import Game.Player;

import java.util.LinkedList;
import java.util.List;

public class GameLogic {

    private final LinkedList<LinkedList<String>> questions = new LinkedList<>();

    public GameLogic() {
        LinkedList<String> popQuestions = new LinkedList<String>();
        LinkedList<String> scienceQuestions = new LinkedList<String>();
        LinkedList<String> sportsQuestions = new LinkedList<String>();
        LinkedList<String> rockQuestions = new LinkedList<String>();

        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
        questions.addAll(List.of(popQuestions, scienceQuestions, sportsQuestions, rockQuestions));
    }

    public void roll(Player player, int roll) {
        Announce.playerRolled(player.getName(), roll);

        if (player.isInPenalty()) chanceToGetOut(player, roll);
        if (player.isInPenalty()) return;

        executeRoll(player, roll);
    }

    private void chanceToGetOut(Player player, int roll) {
        if (roll % 2 == 1) { // if they roll an odd number
            player.removeFromPenalty();
            Announce.playerOutOfPenalty(player.getName());
        } else {
            Announce.playerStayingInPenalty(player.getName());
        }
    }

    private void executeRoll(Player player, int roll) {
        player.moveUpLocation(roll);
        if (player.getLocation() > 10) {
            player.resetLocation();
        }

        Announce.playersLocation(player.getName(), player.getLocation());
        Announce.playersCategory(currentCategory(player.getLocation()));
        askQuestion(player.getLocation());
    }

    private void askQuestion(int location) {
        String question = pickQuestion(location).removeFirst();
        Announce.question(question);
    }

    public LinkedList<String> pickQuestion(int location) {
        return switch (location) {
            case 1 | 5 | 9 -> questions.get(0);  //pop
            case 2 | 6 | 10 -> questions.get(1); //science
            case 3 | 7 -> questions.get(2);      //sports
            default -> questions.get(3);         //rock
        };
    }

    public String currentCategory(int location) {
        return switch (location) {
            case 1 | 5 | 9 -> "Pop";
            case 2 | 6 | 10 -> "Science";
            case 3 | 7 -> "Sports";
            default -> "Rock";
        };
    }

    public void wasCorrectlyAnswered(Player player) {
        Announce.correctAnswer();
        player.addToScore(1);
        Announce.playersGoldCoins(player.getName(), player.getScore());
    }

    public void wrongAnswer(Player player) {
        Announce.incorrectAnswer();
        Announce.wasSentToPenalty(player.getName());
        player.putInPenalty();
    }

    public boolean playerHasWon(Player player) {
        if (player.getScore() == 6) {
            Announce.winner(player.getName());
            return true;
        }
        return false;
    }
}
