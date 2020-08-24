package com.pigcanfly.hack;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

/**
 * @author tobbyquinn
 * @date 2020/02/09
 */
public class CharlesHack {

    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        try {
            pool.insertClassPath("/Users/tobbyquinn/Documents/hack/apktool/charles.jar");
            CtClass QHtb = pool.get("com.xk72.charles.qHTb");
            CtMethod gbef = QHtb.getDeclaredMethod("gbef");
            gbef.setBody("return \"Cracked By TobbyQuinn\";");
            CtConstructor[] constructors = QHtb.getDeclaredConstructors();
            constructors[0].setBody("{this.lPpR=\"Cracked By TobbyQuinn\";\n" +
                    "this.gbef=true;}");
//            constructors[1].setBody("{this.lPpR=\"Cracked By TobbyQuinn\";\n" +
//                    "this.gbef=true;}");
            QHtb.writeFile("/Users/tobbyquinn/Documents/hack/apktool/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
