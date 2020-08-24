//package com.pigcanfly.concurrence;
//
//
//import java.lang.reflect.Field;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author tobbyquinn
// * @date 2020/05/05
// */
//public class RefCount {
//    private static int ref = 0;
//    private static AtomicInteger refCAS = new AtomicInteger(0);
//    private  volatile int count = 0;
//    private  static int countS = 0;
//    // private static Unsafe unsafe = null;
//    private static long valueOffset = 0L;
//
////    static {
////        try {
////            // 通过反射得到theUnsafe对应的Field对象
////            Field field = Unsafe.class.getDeclaredField("theUnsafe");
////            // 设置该Field为可访问
////            field.setAccessible(true);
////            // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
////            unsafe = (Unsafe) field.get(null);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    public static void main(String[] args) throws Exception {
////        Field field = Unsafe.class.getDeclaredField("theUnsafe");
////        // 设置该Field为可访问
////        field.setAccessible(true);
////        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
////        Unsafe unsafe = (Unsafe) field.get(null);
////        Field count1 = RefCount.class.getDeclaredField("count");
////        valueOffset = unsafe.objectFieldOffset(count1);
////        long cs = unsafe.staticFieldOffset(RefCount.class.getDeclaredField("countS"));
//
////        ExecutorService pool = Executors.newFixedThreadPool(2);
////        ExecutorService pool1 = Executors.newFixedThreadPool(2);
//        ExecutorService pool2 = Executors.newFixedThreadPool(2);
//        ExecutorService pool3 = Executors.newFixedThreadPool(2);
//        RefCount refCount = new RefCount();
//        for (int i = 0; i < 10000; i++) {
////            pool.submit(() -> {
////                ref += 1;
////            });
////            pool1.submit(() -> {
////                refCAS.getAndIncrement();
////            });
////            pool2.submit(() -> {
////                int oldValue = refCount.count;
////                int newValue = refCount.count + 1;
////                try {
////                    while (!unsafe.compareAndSwapInt(refCount, valueOffset, oldValue, newValue)) {
////                        oldValue = refCount.count;
////                        newValue = refCount.count + 1;
////                    }
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
////
////            });
//            pool3.submit(() -> {
//                int oldValue = countS;
//                int newValue = countS + 1;
//                try {
//                    while (!unsafe.compareAndSwapInt(null, cs, oldValue, newValue)) {
//                         oldValue = countS;
//                         newValue = countS + 1;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            });
//        }
//        Thread.sleep(8000);
//        System.out.println(ref);
//        System.out.println(refCAS);
//        System.out.println(refCount.count);
//        System.out.println(countS);
////        pool.shutdownNow();
////        pool1.shutdownNow();
//        pool2.shutdownNow();
//        pool3.shutdownNow();
//
//    }
//
//}
