package com.backspace.teenpatti.game;

/**
 * Created by Backspace on 11/12/2016.
 */
public class GameDetails {
    static boolean nightMode=false;
    static boolean fbConnected=false;
    static String fbProfileName;
    static boolean notifyMe=false;
    private static boolean musicMode=false;
    private static boolean soundMode=false;
    private static int NumberOfPlayers=1;

    public static int getNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
    }

    public boolean isNotifyMe() {
        return notifyMe;
    }

    public void setNotifyMe(boolean notifyMe) {
        GameDetails.notifyMe = notifyMe;
    }

    public static boolean isSoundMode() {
        return soundMode;
    }

    public void setSoundMode(boolean soundMode) {
        GameDetails.soundMode = soundMode;
    }

    public static boolean isMusicMode() {
        return musicMode;
    }

    public void setMusicMode(boolean musicMode) {
        GameDetails.musicMode = musicMode;
    }

    public static boolean isFbConnected() {
        return fbConnected;
    }

    public static void setFbConnected(boolean fbConnected) {
        GameDetails.fbConnected = fbConnected;
    }

    public static String getFbProfileName() {
        return fbProfileName;
    }

    public  void setFbProfileName(String fbProfileName) {
        GameDetails.fbProfileName = fbProfileName;
    }

    public static boolean getNightmode() {
        return nightMode;
    }

    public static void setNightmode(boolean nm) {
        nightMode = nm;
    }
}
