package com.jxq.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    Tank tank = new Tank(200, 400, Dir.UP, Group.GOOD, this);
    List<Bullet> bulletList = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    private Explode explode = new Explode(100,100,this);
    public final static int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() {
        setTitle("tank");
        // false不能改变大小
        setResizable(false);
        setVisible(true);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    Image offScreenImage = null;

    /**
     * 双缓冲解决闪烁问题
     *
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        // 先在内存中画出坦克大小和子弹大小
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        // 最后绘制在页面
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的个数" + bulletList.size(), 10, 60);
        g.drawString("敌人tanks的个数" + tanks.size(), 10, 80);
        g.setColor(color);
        tank.paint(g);
        // 不能用foreach  会出现并发异常
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        // 判断每颗子弹和敌方tank是否相交
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bulletList.get(i).bulletKillTank(tanks.get(j));
            }
        }
        explode.paint(g);

    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        /**
         * Invoked when a key has been pressed.
         *
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            System.out.println(keyCode);
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * Invoked when a key has been released.
         *
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            System.out.println(keyCode);
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        // 设置坦克的方向
        private void setMainTankDir() {
            if (!bL && !bR && !bU && !bD) {
                tank.setMoving(false);
            } else {
                tank.setMoving(true);
                if (bL) tank.setDir(Dir.LTFT);
                if (bR) tank.setDir(Dir.RIGHT);
                if (bU) tank.setDir(Dir.UP);
                if (bD) tank.setDir(Dir.DOWN);
            }
        }
    }
}
