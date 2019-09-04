package com.pigcanfly.other;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * TODO:水壶问题
 * @author tobbyquinn
 * @date 2019/09/03
 */
public class KettleQuestion {
    public int[] compute(int args[]) {
        HashMap<int[], Integer> map = new HashMap<>();
        if (args.length == 0) {
            return new int[0];
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.push(args);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(map.containsKey(poll)){
                continue;
            }
            if (poll[0] != 4 || poll[1] != 4) {
                int[] c1 = poll.clone();
//               c1[0]=
            } else {
                return poll;
            }
            map.put(poll,1);
        }
        return new int[0];
    }

}
