package com.jxq.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank tank = new Tank(200, 200, Dir.DOWN);
    Bullet bullet = new Bullet(300, 300, Dir.DOWN);
    private final static int GAME_WIDTH = 800, GAME_HEIGHT = 600;

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
        tank.paint(g);
        bullet.paint(g);
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