package com.linmu.q690;

import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/5/1 9:45 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q690 {
    public static void main(String[] args) {

    }
}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;

        for(Employee employee : employees){
            if(employee.id == id){
                if(employee.subordinates.size() != 0){
                    for(int subId : employee.subordinates){
                        result += getImportance(employees, subId);
                    }
                }
                result += employee.importance;
                break;
            }
        }

        return result;
    }
}
