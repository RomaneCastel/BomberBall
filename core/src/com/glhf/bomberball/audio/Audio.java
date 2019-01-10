package com.glhf.bomberball.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * @author jyra
 * Example : Audio.CLICK_BUTTON.play() to play a song
 */
public enum Audio {
    CLICK_BUTTON("core/assets/sounds/click_button.wav"),
    VICTORY("core/assets/sounds/victory.wav"),
    CLICK_PLAY("core/assets/sounds/PlayLevelButtonTone.wav"),
    MAIN_MENU("core/assets/sounds/MainMenu.mp3"),
    MULTI("core/assets/sounds/MultiSong.mp3");

    public Sound sound;
    public Boolean played;
    Audio(String path)
    {
        sound= Gdx.audio.newSound(Gdx.files.internal(path));
        System.out.println("Sounds " + path + " loaded");
        played=false;
    }

    public void play() {
        sound.play();}

    public void stop() {
        this.sound.stop();
        played=false;
    }
    public static void silence () {
        Audio[] a = Audio.values();
        for (Audio l : a) {
            l.stop();
        }
    }
    public boolean isPlayed(){return this.played;}

    /**
     * Permet de jouer une musique, ça va silence tous les autres sons et lancer la musique
     */
    public void playMusique(){
        System.out.println("is played = "+ this.isPlayed());
        if(! this.isPlayed()) {
            this.silence();
            sound.loop(0.1f);
            played=true;
        }

    }

}
