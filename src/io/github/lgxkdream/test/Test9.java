package io.github.lgxkdream.test;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-06 19:38
 */
@Data
public class Test9 {

    private String salerName;
    private String salerPhone;

    public static void main(String[] args) {
        Field[] declaredFields = MyTest.class.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        String toKeys = Arrays.asList(MyTest.class.getDeclaredFields())
                .stream().map(Field::getName).filter(name -> !"this$0".equals(name)).collect(Collectors.joining(","));
        System.out.println(toKeys);
    }


    @Data
    static class MyTest {
        private String salerName;
        private String salerPhone;
    }

}
