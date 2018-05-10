package cn.tekin.basedemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList和LinkedList 数据插入用时测试
 */
public class ArrayLinkedListInsertTest {
    public static void main(String[] args) {
        List<Integer> list;
        list=new ArrayList<>();
        insertFirst(list,"ArrayList");
        //在最后面插入
        list=new ArrayList<>();
        insertLast(list, "ArrayList");

        list=new LinkedList<>();
        insertFirst(list,"LinkedList");
        list=new LinkedList<>();
        insertLast(list, "LinkedList");

    }
    public static void insertFirst(List<Integer> list, String type){
        int total = 1000* 100;
        final int number =5;
        Long start = System.currentTimeMillis();
        for (int i = 0; i < total ; i++) {
            list.add(0, number);
        }
        Long end = System.currentTimeMillis();
        System.out.printf("在 %s 最前面插入 %d条数据，总共耗时 %d 毫秒 %n",type,total, end-start);
    }

    /**
     * 在后面插入
     * @param list
     * @param type
     */
    public static void insertLast(List<Integer> list, String type){
        int total=9999*1000;
        final int number = 5;
        Long start =System.currentTimeMillis();//获取系统时间戳，精确到毫秒
        for (int i = 0; i <total ; i++) {
            list.add(i,number);
        }
        Long end =System.currentTimeMillis();

        System.out.printf("在%s的最后面插入 %d 条数据，总共耗时 %d 毫秒 %n",type, total,end-start);
    }
}
