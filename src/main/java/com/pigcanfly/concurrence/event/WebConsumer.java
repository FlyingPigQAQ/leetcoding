package com.pigcanfly.concurrence.event;

/**
 * @author tobbyquinn
 * @date 2020/03/31
 */
public class WebConsumer extends Thread{


    @Override
    public void run() {
        CommonMQ mq = CommonMQ.singleton();
        for(;;){
            try {
                Message msg = (Message)mq.take();
                //消费
                Thread.sleep(1000);
                String strMsg=String.format("订单%s已处理",msg.getMsg());
                //更改GuardedObject结果
                // ???如何获取生产者产生的对象 ->map解决
                GuardedObject.fireEvent(msg.getMsgId(),strMsg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
