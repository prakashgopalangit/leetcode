package com.prakash.leetcode.NewStart.GoogleInterviewQuestions;

import java.util.*;

public class EmployeeImportance {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        List<Integer> subs1 = new ArrayList<>();
        subs1.add(2);
        subs1.add(3);
        employee1.subordinates = subs1;

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        List<Integer> subs2 = new ArrayList<>();
        subs2.add(4);
        employee2.subordinates = subs2;

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 4;
        List<Integer> subs3 = new ArrayList<>();
        employee3.subordinates = subs3;

        Employee employee4 = new Employee();
        employee4.id = 4;
        employee4.importance = 1;
        List<Integer> subs4 = new ArrayList<>();
        employee4.subordinates = subs4;

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);

        System.out.println(" output --> "+ new EmployeeImportanceSolution().getImportance(list, 1));

    }
}

class EmployeeImportanceSolution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees)
            map.put(employee.id, employee);
        return calculateImportances(id, map);
    }
    public int calculateImportances(int id, Map<Integer, Employee> map){
       Employee employee = map.get(id);
       int ans = employee.importance;
       for(int sub : employee.subordinates){
           ans += calculateImportances(sub, map);
       }
       return ans;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}