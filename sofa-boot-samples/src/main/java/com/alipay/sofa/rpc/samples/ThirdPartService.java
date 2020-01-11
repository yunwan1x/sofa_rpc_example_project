package com.alipay.sofa.rpc.samples;

import com.alipay.sofa.rpc.samples.model.Communication;

public interface ThirdPartService {
    Communication getCommunication(String name,String uuid);
    void modifyCommunication(Communication communication);
}
