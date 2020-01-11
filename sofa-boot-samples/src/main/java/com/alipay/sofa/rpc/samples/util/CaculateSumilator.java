package com.alipay.sofa.rpc.samples.util;

import com.alipay.sofa.rpc.samples.ThirdPartService;

public class CaculateSumilator {

    public static void  sleepSeconds(int i){
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
