package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



class Test4_2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ROBOT");
        list.add("APPLE");
        list.add("BOX");

        Comparator<String> cmp = (o1, o2) -> o1.length() - o2.length();
		
        
        Collections.sort(list, cmp);    // 정렬
        System.out.println(list);
    }
}

/*
[BOX, ROBOT, APPLE]
*/
