//package com.pigcanfly.test;
//
//import java.util.List;
//import java.util.Stack;
//
///**
// * @author tobbyquinn
// * @date 2019/12/13
// */
//public class IK {
//}
//
//    static List reverseSeg(String text) {
//        Stack<String> result = new Stack();
//        while (text.length() > 0) {
//            int len = MAX_LENGTH;
//            if (text.length() < MAX_LENGTH) {
//                len = text.length();
//            }
//            //取指定的最大长度 文本去字典中匹配
//            String tryWord = text.substring(text.length() - len);
//            while (!DIC.contains(tryWord)) {//如果词典中不包含该段文本
//                //如果长度为1 的话，且没有在字典中匹配，返回
//                if (tryWord.length() == 1) {
//                    break;
//                }
//                //如果匹配不到，则长度减1，继续匹配
//                /**
//                 * --这里就是最关键的地方,把最左边的词去掉一个，继续循环
//                 */
//                tryWord = tryWord.substring(1);
//            }
//            result.add(tryWord);
//            //移除该次tryWord，继续循环
//            text = text.substring(0, text.length() - tryWord.length());
//        }
//        int size = result.size();
//        List list = new ArrayList(size);
//        for (int i = 0; i < size; i++) {
//            list.add(result.pop());
//        }
//        return list;
//    }
