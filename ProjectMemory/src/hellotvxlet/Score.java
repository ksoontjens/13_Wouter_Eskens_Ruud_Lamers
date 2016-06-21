/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruud Lamers, Wouter Eskens
 */
public class Score {

    private class PlayerScore {

        String text;
        int score;

        private PlayerScore(String text, int score) {
            this.text = text;
            this.score = score;
        }
    }
    private List playerScores = new ArrayList();
    private static Score scoreInstance;

    private Score() {
    }

    public static Score getInstance() {
        if (scoreInstance == null) {
            scoreInstance = new Score();
        }
        return scoreInstance;
    }

    public void AddPlayer(Player player) {
        playerScores.add(new PlayerScore(player.text, 0));
    }

    public static void returnTheScore() {
        scoreInstance.cleanScore();
    }

    public void cleanScore() {
        playerScores.clear();
    }
    
    public int getPlayerScore(Player player) {
        for (int i = 0; i < playerScores.size(); i++) {
            if (((PlayerScore) playerScores.get(i)).text.equals(player.text)) {
                return ((PlayerScore) playerScores.get(i)).score;
            }
        }

        return 0;
    }

    public void setPlayerScore(Player player, int playerScore) {
        for (int i = 0; i < playerScores.size(); i++) {
            if (((PlayerScore) playerScores.get(i)).text.equals(player.text)) {
                ((PlayerScore) playerScores.get(i)).score = playerScore;
            }
        }
    }
}
