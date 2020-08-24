package com.pigcanfly.rpc.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author tobbyquinn
 * @date 2020/05/09
 */
public class DefaultJDKSerializable implements Serializable<Object>{
    @Override
    public byte[] serialize(Object obj) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos =null;
        try {
             oos = new ObjectOutputStream(baos);
             oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }

    @Override
    public Object deSerialize(byte[] serializeBytes) {
        return null;
    }
}
