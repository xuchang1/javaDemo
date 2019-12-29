package com.xc.demo.demo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * java函数式编程(stream)
 *
 * stream并不是某种数据结构，它只是数据源的一种视图。stream通常不会手动创建，而是调用对应的工具方法。如:
 *      1、Collection.stream()或者Collection.parallelStream()方法。
 *      2、Arrays.stream(T[] array)方法
 *
 * stream操作和直接collection操作的不同:
 *      1、无存储。stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组、Java容器或I/O channel等。
 *      2、为函数式编程而生。对stream的任何修改，都不会修改背后的数据源，比如对stream进行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新的stream。
 *      3、懒式执行。stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
 *      4、可消费性。stream只能被消费一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
 *
 * 对stream的操作可以分为两类，中间操作(intermediate operations)和结束操作(terminal operations)，两者的特点是:
 *      1、中间操作总是会懒式执行。调用中间操作只会生成一个标记了该操作的新stream，仅此而已。
 *      2、结束操作会触发实际计算。计算发生时会把所有中间操作积攒的操作以pipeline的方式执行，这样可以减少迭代次数。计算完成之后stream就会失效。
 *
 * stream常见的中间操作及结束操作如下 :
 *      1、中间操作 : concat()、distinct()、filter()、flatMap()、limit()、map()、peek()、skip()、sorted()、parallel()、sequential()、unordered()
 *      2、结束操作 : allMatch()、anyMatch()、collect()、count()、findAny()、findFirst()、forEach()、forEachOrdered()、max()、min()、noneMatch()、reduce()、toArray()
 */
public class demo {

    private static Stream<String> stream = Stream.of("aaa", "bbb", "ccc", "aaa");

    /**
     * forEach() : 遍历
     */
    @Test
    public void test1() {
//        stream.forEach(x -> System.out.println(x));
        stream.forEach(System.out::println);
    }

    /**
     * filter() : 拦截、过滤，中间操作。
     */
    @Test
    public void test2() {
        stream.filter(x -> x.startsWith("a")).forEach(System.out::println);
    }

    /**
     * distinct() : 去除重复元素。
     */
    @Test
    public void test3() {
        stream.distinct().forEach(System.out::println);
    }

    /**
     * Stream<T>　sorted() : 自然排序。
     * Stream<T>　sorted(Comparator<? super T> comparator) : 自定义比较器排序。
     */
    @Test
    public void test4() {
        stream = Stream.of("I", "Love", "you", "too");
//        stream.sorted().forEach(System.out::println);
        stream.sorted((x, y) -> y.length() - x.length()).forEach(System.out::println);
    }

    /**
     * map() : 对每个元素按照某种操作进行转换，转换前后stream中元素的个数不会改变，但元素的类型取决于转换后的类型。
     */
    @Test
    public void test5() {
        stream.map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     * flatMap() : 将多个stream连接成一个stream。可以用于集合、数组的合并。
     */
    @Test
    public void test6() {
        Stream<List<String>> stream = Stream.of(Arrays.asList("aaa", "bbb", "ccc"), Arrays.asList("aaa", "ddd"), Arrays.asList("bb", "eee"));
        stream.flatMap(Collection::stream).distinct().forEach(System.out::println);
    }

    /**
     * 将hello、world两个单词输出。获取每个单词的stream流并通过flatMap()方法合并后，输出。
     */
    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        list.stream().flatMap(x -> Stream.of(x.split(""))).forEach(System.out::println);
    }
}
