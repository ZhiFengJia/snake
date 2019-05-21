package com.mashibing.snake;

import java.awt.*;

/**
 * 蛇身体-->链表节点
 *
 * @author Jia ZhiFeng <312290710@qq.com>
 * @date 2019/5/21 10:48:37
 */
public class Node {
    /**
     * 节点在网格中行/列
     */
    int row, col;

    Node prev, next;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void paint(Graphics g) {
        int x = Yard.x + col * Yard.NODE_SIZE;
        int y = Yard.y + row * Yard.NODE_SIZE;

        Color c = g.getColor();
        g.setColor(Color.BLACK);
        g.fillRect(x, y, Yard.NODE_SIZE, Yard.NODE_SIZE);

        g.setColor(c);
    }
}
