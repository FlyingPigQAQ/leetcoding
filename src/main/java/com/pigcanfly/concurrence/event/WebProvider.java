package com.pigcanfly.concurrence.event;

import java.util.Objects;
import java.util.UUID;

/**
 * @author tobbyquinn
 * @date 2020/03/31
 */
public class WebProvider {


    public String buy(String orderId){

        //构建消息
        String msgId= UUID.randomUUID().toString();
        String msg= orderId;
        Message message = new Message(msgId, msg);
        //创建GuardedObject对象
        GuardedObject<String> go = GuardedObject.create(msgId);

        //发送消息,异步消费
        CommonMQ mq = CommonMQ.singleton();
        mq.add(message);


        //等待获取结果（该结果由另一个线程消费产生）
        String s = go.get(Objects::nonNull);
        return s;
    }

}
