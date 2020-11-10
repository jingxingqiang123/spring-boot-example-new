package com.jxq.tank;

import java.awt.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定义爆炸类
 */
public class Explode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    private TankFrame tankFrame = null;
    private boolean living = true;
    private int step = 0;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        executorService.execute(()->new Audio("audio\\war1.wav").loop());
    }

    // 画出Explode爆炸图片的位置
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) step = 0;
    }

}
