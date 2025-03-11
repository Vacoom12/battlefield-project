package src.main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[10];

    public Sound() {
        soundURL[0] = getClass().getResource("/src/res/sounds/BattlefieldTheme8bits.wav");
        soundURL[1] = getClass().getResource("/src/res/sounds/shot_miss.wav");
        soundURL[2] = getClass().getResource("/src/res/sounds/shot_hit.wav");
        soundURL[3] = getClass().getResource("/src/res/sounds/shot_destroy.wav");
        soundURL[4] = getClass().getResource("/src/res/sounds/Victory.wav");
        soundURL[5] = getClass().getResource("/src/res/sounds/Defeat.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}

