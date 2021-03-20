package org.jpwh.model.helloworld;

public class TestInteger {
    int i;
    Integer j;

    public static void main(String[] args) {
        TestInteger ti = new TestInteger();
        ti.go();
    }

    private void go() {
        i = j;
        System.out.println(j);
        System.out.println(i);
    }
}
