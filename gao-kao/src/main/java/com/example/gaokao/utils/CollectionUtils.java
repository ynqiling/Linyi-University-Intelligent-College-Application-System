package com.example.gaokao.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author kfg
 * @date 2022/4/27 13:19
 */
public class CollectionUtils {

    /**
     * 将HashSet转为List
     * @param hashSet
     * @param <T>
     * @return
     */
    public static <T> List<T> setToList(HashSet<T> hashSet) {

        if (hashSet == null) {
            return null;
        }
        List<T> list = new ArrayList<>();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            list.add((T) it.next());
        }
        return list;
    }

    /*
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(314);
        hashSet.add(123);
        System.out.println(Arrays.toString(setToList(hashSet).toArray()));
    }

     */
}
