package com.pigcanfly.leetcoding.s950;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author tobbyquinn
 * @date 2019/10/09
 */
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length<2){
            return deck;
        }
        Arrays.sort(deck);
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(deck[deck.length-1]);
        for (int i = deck.length-2; i >=0 ; i--) {
            Integer poll = q.pollLast();
            q.addFirst(poll);
            q.addFirst(deck[i]);
        }
        int[] res = new int[deck.length];
        int i=0;
        while(q.size()!=0){
            res[i++]=q.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {17,13,11,2,3,5,7};
        new RevealCardsInIncreasingOrder().deckRevealedIncreasing(ints);
    }
}
