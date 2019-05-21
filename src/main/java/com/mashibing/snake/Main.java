package com.mashibing.snake;

/**
 * 贪吃蛇
 *
 * @author Jia ZhiFeng <312290710@qq.com>
 * @date 2019/5/21 10:48:37
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Yard yard = new Yard();

        while (true) {
            Thread.sleep(100);
            yard.repaint();
        }
    }
}
