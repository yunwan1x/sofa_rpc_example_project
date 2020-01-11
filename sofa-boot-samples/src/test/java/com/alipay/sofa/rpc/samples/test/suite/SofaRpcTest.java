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
package com.alipay.sofa.rpc.samples.test.suite;

import com.alipay.sofa.rpc.samples.ServerService;
import com.alipay.sofa.rpc.samples.model.Staff;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@SpringBootTest(properties = { "com.alipay.sofa.rpc.registry.address=zookeeper://127.0.0.1:2181" },
        classes = SofaRpcTest.class)
@RunWith(SpringRunner.class)
public class SofaRpcTest {

    @SofaReference(interfaceType = ServerService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "bolt", timeout = 10000))
    ServerService serverService;

    @Test
    public void testGetFib() {
        int fib10 = serverService.getFib(10);
        Assert.assertEquals(55, fib10);
    }

    @Test
    public void testGetStaff() {
        Staff firstStaff = serverService.getFirstStaff();
        String uuid = firstStaff.getUuid();
        String address = firstStaff.getCommunication().getAddress();
        Assert.assertEquals(firstStaff.getCommunication().getName(), "tom");
        Assert.assertEquals(firstStaff.getCommunication().getUuid(), uuid + "_remote");
        serverService.modifyStaff(firstStaff);
        Assert.assertEquals(firstStaff.getCommunication().getAddress(), address);
        Assert.assertEquals(serverService.getStatics().getFirstStaff(), firstStaff);
        Assert.assertEquals(serverService.getStatics().getStaffNumber(), 1);
        Staff modifyStaff = serverService.modifyStaff(firstStaff);
        Assert.assertNotEquals(modifyStaff, firstStaff);
    }
}