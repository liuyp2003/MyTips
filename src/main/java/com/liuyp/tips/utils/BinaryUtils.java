package com.liuyp.tips.utils;

import java.math.BigInteger;

/**
 * @author liuyingping
 * @DESCRIPTION
 * @create 2019 - 04 - 24 13:33
 * @Version 1.0
 */
public class BinaryUtils {
    /**
     *状态参数，用二进制数值的每一位作为一个状态，并快速进行定位
     */
    public void getOffsetBinary(){
        int num = 0;
        int index = 4;
        Long start = System.currentTimeMillis();
        for(int i =0;i<1000000;i++){
            num = (int)Math.random()*100;
            Integer.toBinaryString(num & (1 << (index-1)));
        }
        System.out.println("cost:"+(System.currentTimeMillis() - start));

    }
}
