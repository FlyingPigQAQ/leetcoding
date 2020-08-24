package com.pigcanfly.rpc.serializable;

/**
 * @author tobbyquinn
 * @date 2020/05/08
 */
public interface Serializable<T> {
    byte[] serialize(T obj);

    T deSerialize(byte[] serializeBytes);

}
