package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Today");
        list.add("TestIxD");
        list.add("Java");
        list.add("Tomorrow");
        list.add("JavaFX");
        list.add("joke");
        list.add("noMercy");
        list.add("for");
        list.add("lazy");
        list.add("students");
        list.add("");
        list.add("");

        //System.out.println("<Org>");
        //list.forEach(System.out::println);
        var stream = list.parallelStream();
        var streamExcludeEmpty = stream.filter(s -> !s.isEmpty());
        //System.out.println("<Filtered>");
        //streamExcludeEmpty.forEach(System.out::println);
        var streamCharCount = streamExcludeEmpty.mapToInt(String::length);
        var streamOut = streamCharCount.filter(i -> i%2 == 0);
        //streamOut.forEach(System.out::println);
        long answer = streamOut.count();
        System.out.println(answer);
    }
}
