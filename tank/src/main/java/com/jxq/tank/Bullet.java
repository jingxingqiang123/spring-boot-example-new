package com.jxq.tank;

import java.awt.*;

/**
 * 定义子弹类
 */
public class Bullet {

    private static final int SPEED = 10;
    private static final int WIDTH = 30, HEIGHT = 30;

    private int x, y;
    private Dir dir;
    private TankFrame tankFrame = null;
    private boolean living = true;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    // 画出tank的方向
    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bulletList.remove(this);
        }
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        move();

    }

    private void move() {
        switch (dir) {
            case LTFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }
}
