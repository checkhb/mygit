package com.example.springaop.test;

import java.io.*;
import java.util.Scanner;

/**
 * @author hubin
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception {
        serializeFlyPig();
        FlyPig flyPig = deserializeFlyPig();
        System.out.println(flyPig.toString());
        Scanner s = new Scanner(System.in);

        String s1 = s.nextLine();
        System.out.println("1111");
        s.close();
    }

    /**
     * 序列化
     */
    private static void serializeFlyPig() throws IOException {
        FlyPig pig = new FlyPig();
        pig.setCar("BWM");
        pig.setColor("green");
        pig.setName("pig");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("d:/aa.txt")));
        objectOutputStream.writeObject(pig);
        System.out.println("序列化成功！");
        objectOutputStream.close();

    }

    /**
     * 反序列化
     */
    private static FlyPig deserializeFlyPig() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("d:/aa.txt")));
        FlyPig o = (FlyPig) objectInputStream.readObject();
        System.out.println("反序列化成功！！");
        return o;
    }
}
