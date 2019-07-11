package com.example.springaop.throwable;

/**
 * @author hubin
 */
public class ErrorAndException {
    public static int dowork(){
        try {
            int i = 10/0;
            System.out.println("i=" + i);
        } catch (ArithmeticException e){
            System.out.println("ArithmeticException:" + e);
            return 0;
        } catch (Exception e){
            System.out.println("Exception:" + e);
            return 1;
        } finally {
            System.out.println("Finally");
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("执行后的值为：" + dowork());
        System.out.println("Misssion complete");
    }
}
