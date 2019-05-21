package com.mashibing.snake;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 蛇-->链表结构
 *
 * @author Jia ZhiFeng <312290710@qq.com>
 * @date 2019/5/21 10:48:37
 */
public class Snake {
    Node head, tail;
    Direction direction = Direction.LIFT;

    public Snake() {
        head = new Node(20, 20);
        tail = head;
    }

    public Snake(int length) {
        this();
        for (int i = 1; i < length; i++) {
            addToHead();
        }
    }


    public void paint(Graphics g) {
        Node n = head;
        while (n != null) {
            n.paint(g);
            n = n.next;
        }

        move();
    }

    private void move() {
        addToHead();
        deleteTail();
        boundaryCheck();
    }

    public void addToHead() {
        Node n = null;
        switch (direction) {
            case LIFT:
                n = new Node(head.row, head.col - 1);
                break;
            case UP:
                n = new Node(head.row - 1, head.col);
                break;
            case RIGHT:
                n = new Node(head.row, head.col + 1);
                break;
            case DOWN:
                n = new Node(head.row + 1, head.col);
                break;
        }
        n.next = head;
        head.prev = n;
        head = n;
    }

    private void deleteTail() {
        if (tail == null) return;
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
    }

    private void boundaryCheck() {
        if (head.row < 0) head.row = Yard.NODE_COUNT - 1;
        if (head.col < 0) head.col = Yard.NODE_COUNT - 1;
        if (head.row > Yard.NODE_COUNT - 1) head.row = 0;
        if (head.col > Yard.NODE_COUNT - 1) head.col = 0;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                direction = Direction.LIFT;
                break;
            case KeyEvent.VK_UP:
                direction = Direction.UP;
                break;
            case KeyEvent.VK_RIGHT:
                direction = Direction.RIGHT;
                break;
            case KeyEvent.VK_DOWN:
                direction = Direction.DOWN;
                break;
        }
    }

    public void eat(Egg e) {
        if (head.row == e.row && head.col == e.col) {
            addToHead();
            e.reAppear();
        }
    }
}
