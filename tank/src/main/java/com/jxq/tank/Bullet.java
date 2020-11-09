package com.jxq.tank;

import java.awt.*;

/**
 * 定义子弹类
 */
public class Bullet {

    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.BulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.BulletD.getHeight();

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
        switch (dir) {
            case LTFT:
                g.drawImage(ResourceMgr.BulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.BulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BulletD, x, y, null);
                break;
        }
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
