package com.jxq;

import com.jxq.tank.Audio;
import org.junit.Test;

import javax.sound.sampled.*;
import java.util.Objects;

public class TestAudio {

    @Test
    public void test1(){
        try {
            AudioInputStream    audioInputStream = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(Audio.class.getClassLoader().getResource("audio\\war1.wav")));
            AudioFormat   audioFormat = audioInputStream.getFormat();
            DataLine.Info   dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
            SourceDataLine  sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);
            //FloatControl volctrl=(FloatControl)sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            //volctrl.setValue(-40);//

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
