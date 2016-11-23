package com.backspace.teenpatti.player;

/**
 * Created by Backspace on 11/12/2016.
 */
public class PlayerDetails {
    private String playerOneName="Player 1";
    private String playerTwoName="Player 2";
    private String playerThreeName="Player 3";
    private String playerFourName="Player 4";

    public String getPlayerFourName() {
        return playerFourName;
    }
    public String getPlayerThreeName() {
        return playerThreeName;
    }
    public String getPlayerTwoName() {
        return playerTwoName;
    }
    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerName(String player1,String player2,String player3,String player4) {
        if(player1.matches("")) playerOneName=player1;
        if(player2.matches("")) playerTwoName=player2;
        if(player3.matches("")) playerThreeName=player3;
        if(player4.matches("")) playerFourName=player4;
    }
}
