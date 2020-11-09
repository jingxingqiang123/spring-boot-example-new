package com.jxq.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;

    static {
        try {
            tankL = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
            tankR = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
            tankU = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif")));
            tankD = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
