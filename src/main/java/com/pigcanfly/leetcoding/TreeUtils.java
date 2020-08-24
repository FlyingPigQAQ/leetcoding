package com.pigcanfly.leetcoding;

import com.pigcanfly.ATreeNode;

import java.lang.reflect.Array;

/**
 * @author tobbyquinn
 * @date 2020/05/21
 */
public class TreeUtils {
    public static <T extends ATreeNode> T buildTreeFromArray(Integer[] treeArr, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (treeArr.length <= 0) {
           throw new IllegalArgumentException("数组长度不能小于等于0");
        }
        T[] trees = (T[]) Array.newInstance(clazz,treeArr.length);
        for (int i = 0; i < treeArr.length; i++) {
            if (treeArr[i] != null) {
                trees[i] = clazz.newInstance();
                trees[i].setVal(treeArr[i]);
            }
        }
        for (int i = 0; i < trees.length; i++) {
            int leftNodePos = 2 * i + 1;
            int rightNodePos = 2 * i + 2;
            if (leftNodePos < trees.length) {
                trees[i].setLeft(trees[leftNodePos]);
            }
            if (rightNodePos < trees.length) {
                trees[i].setRight(trees[rightNodePos]);
            }
        }
        return trees[0];
    }
    static class TreeTest extends ATreeNode{


    }
    public static void main(String[] args) {
        try {
            TreeTest treeTest = TreeUtils.buildTreeFromArray(new Integer[]{5, 1, 4, null, null, 3, 6}, TreeTest.class);
            System.out.println(treeTest);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
