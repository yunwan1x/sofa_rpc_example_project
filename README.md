## description
unit tests located at sofa-boot-samples module 

you can run the tests with  steps below

1.  run ```mvn install -DskipTests``` to install all dependencies
2.  run sofa-rpc-boot-projects\sofa-boot-samples\src\main\java\com\alipay\sofa\rpc\samples\util\LocalZookeeperServer.java to start a service gateway;
3.  run sofa-boot-samples\src\main\java\com\alipay\sofa\rpc\samples\ServerApplication.java to start rpc service server
4.  last step you can run tests which are located at sofa-boot-samples\src\test\java\com\alipay\sofa\rpc\samples\test\suite\SofaRpcTest.java  with ```
mvn  test```

