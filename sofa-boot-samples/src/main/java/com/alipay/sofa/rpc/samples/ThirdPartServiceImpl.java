/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    public Communication getCommunication(String name, String uuid) {
        CaculateSumilator.sleepSeconds(2);
        Communication communication = new Communication();
        communication.setAddress("beijing hujialou street");
        communication.setPhoneNumber("18109871234");
        communication.setName(name);
        communication.setUuid(uuid + "_remote");
        return communication;
    }

    @Override
    public void modifyCommunication(Communication communication) {
        CaculateSumilator.sleepSeconds(2);
        communication.setAddress("modify_" + communication.getAddress());
    }
}
