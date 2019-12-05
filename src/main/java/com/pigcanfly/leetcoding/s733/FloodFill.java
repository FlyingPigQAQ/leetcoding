package com.pigcanfly.leetcoding.s733;

import java.util.LinkedList;

/**
 * 考虑新元素和旧元素相同情况
 *
 * @author tobbyquinn
 * @date 2019/10/28
 */
public class FloodFill {
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        LinkedList<int[]> q = new LinkedList<>();
        q.push(new int[]{sr, sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            sr = poll[0];
            sc = poll[1];
            if (sr - 1 >= 0  && image[sr - 1][sc] == oldColor) {
                q.push(new int[]{sr - 1, sc});
                image[sr - 1][sc] = newColor;
            }
            if (sr + 1 <= image.length - 1  && image[sr + 1][sc] == oldColor) {
                q.push(new int[]{sr + 1, sc});
                image[sr + 1][sc] = newColor;
            }
            if (sc - 1 >= 0  && image[sr][sc - 1] == oldColor) {
                q.push(new int[]{sr, sc - 1});
                image[sr][sc - 1] = newColor;
            }
            if (sc + 1 <= image[sr].length - 1  && image[sr][sc + 1] == oldColor) {
                q.push(new int[]{sr, sc + 1});
                image[sr][sc + 1] = newColor;
            }
        }
        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
