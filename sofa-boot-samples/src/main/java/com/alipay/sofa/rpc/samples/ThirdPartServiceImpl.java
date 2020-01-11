package com.alipay.sofa.rpc.samples;

import com.alipay.sofa.rpc.samples.model.Communication;
import com.alipay.sofa.rpc.samples.util.CaculateSumilator;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Component;

@SofaService(interfaceType = ThirdPartService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
@Component
public class ThirdPartServiceImpl implements ThirdPartService {

    @Override
    public Communication getCommunication(String name,String uuid) {
        CaculateSumilator.sleepSeconds(2);
        Communication communication=new Communication();
        communication.setAddress("beijing hujialou street");
        communication.setPhoneNumber("18109871234");
        communication.setName(name);
        communication.setUuid(uuid+"_remote");
        return communication;
    }

    @Override
    public void modifyCommunication(Communication communication) {
        CaculateSumilator.sleepSeconds(2);
        communication.setAddress("modify_"+communication.getAddress());
    }
}
