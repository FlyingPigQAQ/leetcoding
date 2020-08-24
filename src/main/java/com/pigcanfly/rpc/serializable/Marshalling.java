package com.pigcanfly.rpc.serializable;

import com.pigcanfly.rpc.MyProtocol;
import org.jboss.marshalling.ObjectOutputStreamMarshaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author tobbyquinn
 * @date 2020/05/08
 */
public class Marshalling implements Serializable<Object> {


    @Override
    public byte[] serialize(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            ObjectOutputStreamMarshaller encoder = new ObjectOutputStreamMarshaller(oos);
            encoder.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // assert oos!=null;
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                baos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        MarshallerFactory marshallerFactory = org.jboss.marshalling.Marshalling.getProvidedMarshallerFactory("serial");
//        MarshallingConfiguration marshallingConfiguration = new MarshallingConfiguration();
//        marshallingConfiguration.setVersion(5);
//
//        try {
//            Marshaller encoder = marshallerFactory.createMarshaller(marshallingConfiguration);
//            encoder.start();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //MarshallingEncoder encoder = new MarshallingEncoder(new DefaultMarshallerProvider(marshallerFactory, marshallingConfiguration));
        return baos.toByteArray();
    }

    @Override
    public Object deSerialize(byte[] serializeBytes) {
        return null;
    }

    public static void main(String[] args) {
        MyProtocol myProtocol = new MyProtocol("接口名称", "接口方法", null);
        User user = new User();
        long l = System.currentTimeMillis();
        for (int i = 0; i <= 1; i++) {
            byte[] serialize = new Marshalling().serialize(user);
//            if (i == 0) {
//                System.out.println("jboss序列化后字节码大小：" + serialize.length);
//            }
        }
        long e = System.currentTimeMillis();
        System.out.println("jboss耗时："+(e-l)+"ms");
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            byte[] jdkS = new DefaultJDKSerializable().serialize(user);
        }
        long e1 = System.currentTimeMillis();
        System.out.println("jdk耗时："+(e1-l1)+"ms");
        //System.out.println("jdk序列化后字节码大小：" + jdkS.length);
    }
}

class User{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
