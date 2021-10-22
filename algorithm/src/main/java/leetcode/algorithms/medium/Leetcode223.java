package leetcode.algorithms.medium;

import java.util.Arrays;

/**
 * [矩形面积]
 *
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 *
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *
 */
public class Leetcode223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s1 = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int s2 = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        int s3 = s1 + s2;
        //判断是否重叠
        if(!(ax2 > bx1 && bx2 > ax1 && ay2 > by1 && by2 > ay1)){
           return s3;
        }
        int[] xPoint = new int[]{ax1,ax2,bx1,bx2};
        int[] yPoint = new int[]{ay1,ay2,by1,by2};
        Arrays.sort(xPoint);
        Arrays.sort(yPoint);
        int x = Math.abs(xPoint[1] - xPoint[2]);
        int y = Math.abs(yPoint[1] - yPoint[2]);
        return s3 - x*y;
    }


    public static void main(String[] args) {
        Leetcode223 l = new Leetcode223();
        System.out.println(l.computeArea(-2, -2, 2, 2, -1, 4, 1, 6));


    }


}
