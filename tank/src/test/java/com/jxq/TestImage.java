package com.jxq;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TestImage {


    @Test
    public void testImages2() {
        try {

            BufferedImage image2 = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader()
                    .getResourceAsStream("images\\111.png")));
            System.out.println(image2.getWidth());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 放在resource的目录下
    @Test
    public void testImages1() {
        try {
            BufferedImage image = ImageIO.read(new File(
                    "E:\\springboot-example\\tank\\src\\main\\resources\\images\\0.gif"));
            System.out.println(image.getWidth());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
