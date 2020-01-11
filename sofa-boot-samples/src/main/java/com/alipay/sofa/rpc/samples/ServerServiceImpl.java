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
import com.alipay.sofa.rpc.samples.model.Staff;
import com.alipay.sofa.rpc.samples.model.Statics;
import com.alipay.sofa.rpc.samples.util.CaculateSumilator;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import org.springframework.stereotype.Component;

@SofaService(interfaceType = ServerService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
@Component
public class ServerServiceImpl implements ServerService {

    Statics statics=Statics.createStatic();


    @SofaReference(interfaceType = ThirdPartService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "bolt", timeout = 10000))
    ThirdPartService thirdPartService;

    public Staff getFirstStaff(){
        Staff staff=new Staff();
        staff.setUuid("20881234567890");
        staff.setName("tom");
        staff.setCommunication(thirdPartService.getCommunication("tom","20881234567890"));
        statics.setStaffNumber(statics.getStaffNumber()+1);
        statics.setFirstStaff(staff);
        CaculateSumilator.sleepSeconds(2);
        return staff;
    }

    public Staff modifyStaff(Staff staff){
        CaculateSumilator.sleepSeconds(2);
        staff.setName("modify_"+staff.getName());
        thirdPartService.modifyCommunication(staff.getCommunication());
        return staff;
    }

    public Staff addStaff(){
        CaculateSumilator.sleepSeconds(2);
        Staff staff=new Staff();
        staff.setUuid("20881234567890");
        staff.setName("tom");
        Communication communication=new Communication();
        communication.setAddress("beijing hujialou street");
        communication.setPhoneNumber("18109871234");
        communication.setName("tom");
        communication.setUuid("20881234567890");
        staff.setCommunication(communication);
        statics.setStaffNumber(statics.getStaffNumber()+1);
        statics.setFirstStaff(staff);
        return staff;
    }

    public Statics getStatics(){
        CaculateSumilator.sleepSeconds(2);
        return statics;
    }

    @Override
    public int getFib(int n) {
        CaculateSumilator.sleepSeconds(2);
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int c = 0, a = 1, b = 1;
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

}