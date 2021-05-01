package io.github.lgxkdream.unit5;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 690. 员工的重要性
 * @description https://leetcode-cn.com/problems/employee-importance/
 * @since 5/1/21 11:43 AM
 */
public class EmployeeImportance {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.asList(2, 3);
        employees.add(e1);
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = Arrays.asList();
        employees.add(e2);
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = Arrays.asList();
        employees.add(e3);
        /**
         * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
         * 输出：11
         * 解释：
         * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
         */
        System.out.println(getImportance(employees, 1));
    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        int res = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(employeeMap.get(id));
        while (!queue.isEmpty()) {
            Employee poll = queue.poll();
            res += poll.importance;
            for (Integer subordinate : poll.subordinates) {
                queue.offer(employeeMap.get(subordinate));
            }
        }
        return res;
    }

}

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
