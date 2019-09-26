package com.pigcanfly.leetcoding.s690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tobbyquinn
 * @date 2019/09/17
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> cache = new HashMap<>();

        for (int i = 0; i < employees.size(); i++) {
            cache.put(employees.get(i).id,employees.get(i));
        }
        Employee root=cache.get(id);
        if(root==null){
            return 0;
        }
        List<Integer> directSubordinates = root.subordinates;
        return root.importance+totalOfImportanceValue(cache,directSubordinates);
    }

    private int totalOfImportanceValue(Map<Integer,Employee> cache,List<Integer> arr) {
        if(arr.size()==0){
            return 0;
        }
        int total=0;
        for (int i = 0; i < arr.size(); i++) {
            total+=cache.get(arr.get(i)).importance+totalOfImportanceValue(cache,cache.get(arr.get(i)).subordinates);
        }
        return total;
    }
}
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
