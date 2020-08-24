package com.pigcanfly.algorithm;

import java.util.*;


/**
 *
 *TODO:规范哈夫曼编码
 * @author tobbyquinn
 * @date 2020/05/11
 */
public class HuffmanCode {
    class Node implements Comparable<Node> {
        int weight;
        Character value;
        Node left;
        Node right;

        public Node(int weight, Character value, Node left, Node right) {
            this.weight = weight;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return weight == node.weight &&
                    Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight, value);
        }

        @Override
        public int compareTo(Node o) {
            if(weight<o.weight){
                return -1;
            }else if(weight>o.weight){
                return 1;
            }else{
               return Character.compare(value,o.value);
            }

        }
    }

    private Node root = null;
    HashMap<Character, String> dict = new HashMap<>();

    public String compress(String text, String outputPath) {
        if (text.length() == 0) {
            throw new IllegalArgumentException("文本不能为空");
        }
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        //封装权重优先队列
        PriorityQueue<Node> q = new PriorityQueue<>();
        count.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "出现次数: " + entry.getValue());
            q.add(new Node(entry.getValue(), entry.getKey(), null, null));
        });
        //生成哈夫曼树
        root = generatorHuffmanTree(q);
        //压缩字典
        //printHuffmanTree(root,new BitSet());
        printHuffmanTree(root, new StringBuilder());
        //生成结果
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            res.append(dict.get(c));
        }
        return res.toString();
    }

    public String unCompress(String compData){
        StringBuilder sb = new StringBuilder();
        if(compData.length()==0 && root!=null){
            for (int i = 0; i < root.weight; i++) {
                sb.append(root.value);
            }
            return sb.toString();
        }
        Node iterNode = root;
        for (int i = 0; i < compData.length(); i++) {
            char c = compData.charAt(i);
            if(c=='0'){
                iterNode=iterNode.left;
            }else if(c=='1'){
                iterNode=iterNode.right;
            }
            if(iterNode.left==null && iterNode.right==null){
                sb.append(iterNode.value);
                iterNode=root;
            }
        }
        return sb.toString();

    }

    private Node generatorHuffmanTree(Queue<Node> q) {
        while (q.size() > 1) {
            //初始队列大小为1，直接赋值给root
            Node leftNode = q.poll();
            Node rightNode = q.poll();
            int weight = leftNode.weight + rightNode.weight;
            q.add(new Node(weight, '\0', leftNode, rightNode));
        }
        return q.peek();
    }

    //    private void printHuffmanTree(Node node, BitSet bs) {
//        if(node==null){
//            return;
//        }
//        //Leaf Node
//        if(node.left==null && node.right==null){
//            System.out.println(node.value+" "+bs.toString());
//        }
//        bs.set(0);
//        printHuffmanTree(node.left,bs);
//        bs.set(1);
//        printHuffmanTree(node.right,bs);
//        bs.previousClearBit(bs.size()-1);
//    }
    private void printHuffmanTree(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        //Leaf Node
        if (node.left == null && node.right == null) {
            dict.put(node.value, sb.toString());
            System.out.println(node.value + " " + sb.toString());
        }
        if (node.left != null) {
            sb.append(0);
            printHuffmanTree(node.left, sb);
        }
        if (node.right != null) {
            sb.append(1);
            printHuffmanTree(node.right, sb);
        }
        if (node != root) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String text = "To avoid ambiguity, Huffman encoding is a prefix free encoding technique." +
                " No codeword appears as a prefix of any other codeword. " +
                "To decode the encoded string, follow the zeros and ones to a leaf and " +
                "return the character there. You are given pointer to the root of the Huffman tree and " +
                "a binary coded string to decode";
        //String text = "aaaa";
        HuffmanCode huffmanCode = new HuffmanCode();
        String compress = huffmanCode.compress(text, "");
        System.out.println("文本大小: "+text.length());
        System.out.println("压缩后文本大小: "+compress.length()/8);
        System.out.println("压缩率:"+((compress.length()/8)*100/text.length())+"%");
        System.out.println("压缩数据："+ compress);
        System.out.println("解压数据: "+huffmanCode.unCompress(compress));
        BitSet bitSet = new BitSet(4);
        bitSet.set(1);
        bitSet.set(0);
        bitSet.set(3);
        bitSet.set(2);
        byte[] bytes = bitSet.toByteArray();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }


}


