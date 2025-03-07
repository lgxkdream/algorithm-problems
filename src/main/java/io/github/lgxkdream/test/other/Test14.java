package io.github.lgxkdream.test.other;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test14
 * @description
 * @since 2020-03-03 15:26
 */
public class Test14 {

    public static void main(String[] args) {
        List<Student> list = Lists.newArrayList();
        Student student1 = new Student(1, 10);
        Student student2 = new Student(2, 2);
        Student student3 = new Student(3, 4);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        Integer collect = list.stream().collect(Collectors.summingInt(s -> s.getAge() * s.getSex()));
        System.out.println(collect);
        int sum = list.stream().mapToInt(s -> s.getAge() * s.getSex()).sum();
        System.out.println(sum);

        String aa = "1,8,6,78";
        String bb = "6,1,78,8";
        String[] aaArr = StringUtils.split(aa, ",");
        String[] bbArr = StringUtils.split(bb, ",");
        System.out.println(aaArr);
        System.out.println(bbArr);
        Set<String> set1 = Arrays.stream(aaArr).collect(Collectors.toSet());
        Set<String> set2 = Arrays.stream(aaArr).collect(Collectors.toSet());
        System.out.println(Arrays.asList(set1));
        System.out.println(Arrays.asList(set2));

        System.out.println("==" + StringUtils.trim(" sjdfl ") + "==");
    }

    private static void change(Student student) {
        student.setAge(100);
    }

}

class Student {
    Integer age;
    Integer sex;

    public Student(int age, int sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
