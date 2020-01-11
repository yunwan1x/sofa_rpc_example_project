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

import com.alipay.sofa.rpc.samples.annotation.AnnotationService;
import com.alipay.sofa.rpc.samples.rest.RestServiceImpl;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootApplication
@SpringBootTest(properties = { "com.alipay.sofa.rpc.registry.address=zookeeper://127.0.0.1:2181" },
        classes = EmptyTest.class)
@RunWith(SpringRunner.class)
public class EmptyTest {

    @SofaReference(interfaceType = AnnotationService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "bolt"))
    AnnotationService annotationService;
    @Test
    public void test() {
        String result=annotationService.sayAnnotation("help");
        Assert.assertEquals(result,"help");
    }
}