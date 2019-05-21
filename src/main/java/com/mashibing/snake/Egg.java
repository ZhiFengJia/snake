package com.mashibing.snake;

import java.awt.*;
import java.util.Random;

/**
 * 蛇的食物
 *
 * @author Jia ZhiFeng <312290710@qq.com>
 * @date 2019/5/21 10:48:37
 */
public class Egg {
    int row, col;
    Random r = new Random();

    public Egg(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public void paint(Graphics g) {
        int x = Yard.x + col * Yard.NODE_SIZE;
        int y = Yard.y + row * Yard.NODE_SIZE;

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, Yard.NODE_SIZE, Yard.NODE_SIZE);

        g.setColor(c);
    }

    public void reAppear() {
        this.row = r.nextInt(Yard.NODE_COUNT);
        this.col = r.nextInt(Yard.NODE_COUNT);
    }
}
