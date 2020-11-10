package com.jxq.tank;

import java.awt.*;
import java.util.Random;

/**
 * tank类
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean moving = true;
    private static final int SPEED = 3;
    private TankFrame tankFrame = null;
    public static final int WIDTH = ResourceMgr.tankD.getWidth();
    public static final int HEIGHT = ResourceMgr.tankD.getHeight();
    private boolean living = true;
    private final Random random = new Random();
    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    // 画出tank的方向
    public void paint(Graphics g) {
        if (!living) tankFrame.tanks.remove(this);
        switch (dir) {
            case LTFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }
        move();

    }

    private void move() {
        if (!moving) return;
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
        // 地方坦克如果,没有被子弹击中，抛出圈外，不会消失。
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
        // 可以只让敌方坦克发出来炮弹，自己手动控制
        if (random.nextInt(10) > 8) this.fire();
    }

    /**
     * tank 发射子弹
     */
    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tankFrame.bulletList.add(new Bullet(bX, bY, this.dir, this.group, this.tankFrame));
    }

    public void die() {
        this.living = false;
    }
}
