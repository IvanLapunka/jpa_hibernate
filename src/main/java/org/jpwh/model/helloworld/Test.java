package org.jpwh.model.helloworld;

public class Test {

    public final int x;

    public Test() {
        x = 1;
    }

    public static void main(String[] args) {
        Test t = new Test();

        final int y;
        System.out.println(t.x);
    }
}
