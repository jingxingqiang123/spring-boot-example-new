package com.jxq.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage BulletL, BulletR, BulletU, BulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            tankL = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
            tankR = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
            tankU = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif")));
            tankD = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif")));

            BulletL = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif")));
            BulletR = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif")));
            BulletU = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
            BulletD = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1)+".gif")));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
