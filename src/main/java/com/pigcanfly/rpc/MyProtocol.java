package com.pigcanfly.rpc;

import java.io.Serializable;

/**
 * @author tobbyquinn
 * @date 2020/04/15
 */
public class MyProtocol implements Serializable {
    String interfaceName;
    String methodName;
    Object[] args;

    public MyProtocol(String interfaceName, String methodName, Object[] args) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.args = args;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
