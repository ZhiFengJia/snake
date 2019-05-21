package com.mashibing.snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * 网格布局界面(正方体,长宽一致)
 *
 * @author Jia ZhiFeng <312290710@qq.com>
 * @date 2019/5/21 10:48:37
 */
public class Yard extends Frame {

    /**
     * 网格界面中每个格的长/宽(正方体,长宽一致)
     */
    public static final int NODE_SIZE = 15;
    /**
     * 网格界面中每行/每列多少格
     */
    public static final int NODE_COUNT = 30;
    /**
     * 网格界面的长/宽(正方体,长宽一致)
     */
    public static final int AreaSize = Yard.NODE_SIZE * Yard.NODE_COUNT;

    public static int x = AreaSize / 2;
    public static int y = AreaSize / 2;

    Snake snake = new Snake(5);
    Egg egg = new Egg(10, 10);

    Yard() {
        this.setSize(AreaSize * 2, AreaSize * 2);
        this.setTitle("贪吃蛇");
        this.setResizable(false);
        this.setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.keyPressed(e);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);

        for (int i = 0; i <= Yard.NODE_COUNT; i++) {
            g.drawLine(x, y + Yard.NODE_SIZE * i, x + AreaSize, y + Yard.NODE_SIZE * i);
            g.drawLine(x + Yard.NODE_SIZE * i, y, x + Yard.NODE_SIZE * i, y + AreaSize);
        }

        snake.paint(g);
        egg.paint(g);

        snake.eat(egg);

        g.setColor(c);
    }

    //double buffer
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(this.getWidth(), this.getHeight());
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    //www.mashibing.com 马士兵
}
