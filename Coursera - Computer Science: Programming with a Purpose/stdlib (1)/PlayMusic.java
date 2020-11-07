import java.io.InputStream;
import java.io.IOException;

import java.applet.*;
import java.net.*;
import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


public class PlayMusic {

    // play sound file using Applet.newAudioClip();
    private static void playApplet(String filename) {
        URL url = null;
        try {
            File file = new File(filename);
            if (file.canRead()) url = file.toURI().toURL();
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        // URL url = StdAudio.class.getResource(filename);
        if (url == null) throw new RuntimeException("audio " + filename + " not found");
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
    }


    public static synchronized void play(final String filename) {

        // code adapted from: http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
        try {
            System.out.println("trying AudioSystem.getClip()");

            // check if file format is supported
            // (if not, will throw an UnsupportedAudioFileException)
            InputStream is = PlayMusic.class.getResourceAsStream(filename);
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    stream(filename);
                }
            }).start();
        }

        // let's try Applet.newAudioClip() instead
        catch (UnsupportedAudioFileException e) {
            System.out.println("trying Applet.newAudioClip()");
            playApplet(filename);
            System.out.println("done 2");
            return;
        }

        // something else went wrong
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Could not play " + filename);
        }

    }


    // https://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
    // play a wav or aif file
    // javax.sound.sampled.Clip fails for long clips (on some systems)
    private static void stream(String filename) {
        SourceDataLine line = null;
//        int BUFFER_SIZE = 65526; // 64K buffer
        int BUFFER_SIZE = 4096; // 4K buffer

        try {
            InputStream is = PlayMusic.class.getResourceAsStream(filename);
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            AudioFormat audioFormat = ais.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();
            byte[] samples = new byte[BUFFER_SIZE];
            int count = 0;
            while ((count = ais.read(samples, 0, BUFFER_SIZE)) != -1) {
                line.write(samples, 0, count);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        finally {
            if (line != null) {
                line.drain();
                line.close();
            }
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        play(filename);
        System.out.println("done");
    }
}
