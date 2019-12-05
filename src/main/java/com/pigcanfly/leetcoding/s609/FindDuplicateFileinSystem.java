package com.pigcanfly.leetcoding.s609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/11/20
 */
public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] s = path.split(" ");
            String currentPath = s[0];
            for (int i = 1; i < s.length; i++) {
                String[] split = s[i].split("\\(");
                String fileName = split[0];
                String fileContent = split[1];
                if (map.containsKey(fileContent)) {
                    map.get(fileContent).add(currentPath + "/" + fileName);
                } else {
                    ArrayList<String> arr = new ArrayList<>();
                    arr.add(currentPath + "/" + fileName);
                    map.put(fileContent, arr);
                }
            }
        }
        final List<List<String>> res = new ArrayList<>();
        map.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> res.add(entry.getValue()));
        return res;
    }

    public static void main(String[] args) {
        String[] split = "a.txt(abc)".split("\\(");
        System.out.println(split.length);
        System.out.println(split[0]);
        System.out.println(split[1]);
    }
}
