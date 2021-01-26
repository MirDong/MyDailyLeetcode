package com.dzk;

import java.util.BitSet;

/**
 * BitSet是一个按照bit位来记录数据的一种特殊结构的数据结构，类似于boolean[]，记录boolean数组中所有下标元素对应的布尔值
 * 利用bit位作下标可以极大的减少内存开销，特别是针对万亿级数据的处理，性能更加明显。
 * 内部使用long数组来存储，初始化默认长度为1，一个long类型占8个字节，64位，可以将0-63区间的数字表示到这个数组中
 * 例如，bitset.set(3) 内部是0000 0100  会将第3个bit位  置为true  依次 set(13)将第13个bit置为true
 *
 * 在打印bitset时，会从低位到高位依次读取value为true的下标(即为true的bit位数 如  0010 0110 依次输出2,3,6)
 */

public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(3);
        bitSet.set(13);
        bitSet.set(89);
        bitSet.set(8);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(2);
        System.out.println(bitSet);
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(0));
    }
}
