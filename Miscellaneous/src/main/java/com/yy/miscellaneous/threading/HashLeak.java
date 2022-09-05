package com.yy.miscellaneous.threading;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的内存泄露
 */
public class HashLeak {
    public static void main(String[] args) {
        Map<HashKey, Integer> map = new HashMap<HashKey, Integer>();
        HashKey p = new HashKey("zhangsan","12333-suu-1232");
        map.put(p, 1);
//        p=null;

//        p.setName("lisi"); // 因为p.name参与了hash值的计算，修改了之后hash值发生了变化，所以下面删除不掉
//        map.remove(p);
        System.out.println(map.size());
//        System.out.println(p.hashCode());
//        map=null;
        p=null;
        System.out.println(map.size());
    }
}
/**
 * 用于测试的key 类
 */
class HashKey {
    private final String id;
    private String name;
    public HashKey(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String  hashCode_() {
        return name+" "+id;
    }
}
