package cn.tekin.basedemo;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapTest {
    //HashMap 使用简单案例
    public static void main(String[] args) {
        HashMap hm = new HashMap();

        hm.put("1", "tekin");
        hm.put("2", "aaa");
        hm.put("5","100");
        hm.put("qq","http://www.qq.com");
        hm.put("ynws1","http://www.yunnan.ws");


        //删除指定的key
        hm.remove("2");

        //删除所有的数据
        //hm.clear();

        //使用迭代器 取出所有的key,
        Iterator it=hm.keySet().iterator();

        while (it.hasNext()){

            if (hm.containsKey("ynws")) {
                System.out.println("找到了我的网站："+hm.get("ynws"));
                return;
            }
            //取出key
            String key = (String) it.next();

            //根据key取出value
            String val = (String) hm.get(key);

            System.out.println("key= "+ key + "  val= "+ val);
        }
    }
}
