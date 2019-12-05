package com.pigcanfly.leetcoding.s252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tobbyquinn
 * @date 2019/12/03
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0]-i2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
