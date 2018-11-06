package com.company;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MusicPlayer{

    private final Map<String, MediaPlayer> audioMap;
    private final JFXPanel fxPanel;
    private boolean pauseMode;

    public MusicPlayer(){
        audioMap = new ConcurrentHashMap<>();
        fxPanel = new JFXPanel(); // need to create one instance
    }

    private void setLoop(MediaPlayer mediaPlayer, boolean loop) {
        if (mediaPlayer == null){
            return;
        }
        if (loop){
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }
        else{
            mediaPlayer.setCycleCount(1);
        }
    }
    public void play(String filepath){
        play(filepath, false);
    }

    public void play(String filepath, boolean repeat){
        if (pauseMode) return;
        try {
            MediaPlayer mediaPlayer;
            if (audioMap.containsKey(filepath)) {
                mediaPlayer = audioMap.get(filepath);
                this.setLoop(mediaPlayer, repeat);
            }
            else{
                mediaPlayer = new MediaPlayer( new Media(new File(filepath).toURI().toString()) );
                this.setLoop(mediaPlayer, repeat);
                audioMap.put(filepath, mediaPlayer);
            }
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        }
        catch ( Exception e){
            e.printStackTrace();
        }
    }
}