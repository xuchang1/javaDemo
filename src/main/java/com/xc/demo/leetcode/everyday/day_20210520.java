package com.xc.demo.leetcode.everyday;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class day_20210520 {
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent2(words, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        Map<Integer, TreeSet<String>> map2 = new HashMap<>();
        map.forEach((key, value) -> {
            if (map2.containsKey(value)) {
                map2.get(value).add(key);
            } else {
                TreeSet<String> set = new TreeSet<>();
                set.add(key);
                map2.put(value, set);
            }
        });

        List<Map.Entry<Integer, TreeSet<String>>> collect = map2.entrySet()
                .stream()
                .sorted((o1, o2) -> (o2.getKey() - o1.getKey()))
                .collect(Collectors.toList());
        for (Map.Entry<Integer, TreeSet<String>> word : collect) {
            for (String str : word.getValue()) {
                if (k-- == 0 ) {
                    return result;
                }
                result.add(str);
            }
        }
        return result;
    }
    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = map.keySet()
                .stream()
                .sorted((o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : (map.get(o2) - map.get(o1)))
                .collect(Collectors.toList());
        return list.size()>k?list.subList(0, k):list;
    }

}
