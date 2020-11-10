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
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
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

    public void bulletKillTank(Tank tank) {
        // 判断是否是友方坦克
        if (this.group == tank.getGroup()) return;

        // TODO Rectangle新建的太多了 。用一个rectangle记录子弹的位置
        Rectangle rectangle1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rectangle2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        // 判断矩形tank和子弹是否相交
        if (rectangle1.intersects(rectangle2)) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
