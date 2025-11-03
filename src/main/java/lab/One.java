package lab;

import base.Context;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class One extends Context {
    List<String> list;

    @Override
    protected void init() {
        super.init();
        list = Arrays.asList("Today", "TestIxD", "Java", "Tomorrow", "JavaFX", "joke", "noMercy", "for", "lazy", "students", "", "");
    }

    @Override
    protected void execute() {
        long answer = list.stream()
                .peek(e -> {
                    System.out.println("====================");
                    System.out.println(e);
                })
                .filter(e -> !e.isEmpty()).peek(e -> {
                    System.out.println("<Filtered (no empty)>");
                    System.out.println(e);
                })
                .mapToInt(String::length).peek(e -> {
                    System.out.println("<Mapped (lng)>");
                    System.out.println(e);
                })
                .filter(i -> i % 2 == 0).peek(e -> {
                    System.out.println("<Filtered (even)>");
                    System.out.println(e);
                })
                .count();
        System.out.println(answer);
    }


    public static void main(String[] args) {
        var l1 = new One();
        l1.run();
    }
}
