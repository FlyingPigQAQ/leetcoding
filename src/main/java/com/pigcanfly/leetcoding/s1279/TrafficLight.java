package com.pigcanfly.leetcoding.s1279;

/**
 * @author tobbyquinn
 * @date 2019/12/09
 */
public class TrafficLight {
    public TrafficLight() {

    }
    private volatile int greenRoad=1;

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
            synchronized (TrafficLight.class){
                if(greenRoad!=roadId){
                    turnGreen.run();
                    greenRoad=greenRoad==1?2:1;
                }
                crossCar.run();
            }

    }

    public static void main(String[] args) {
        System.out.println(2147483647);
        System.out.println(Math.pow(9,10));
    }
}
