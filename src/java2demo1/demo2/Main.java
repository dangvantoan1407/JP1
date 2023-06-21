package java2demo1.demo2;

public class Main {
    public static void main(String[] args) {
        Order<Integer> od1 = new Order<>();
        od1.setCode(2);

        Order<String> od2 = new Order<>();
        od2.setCode("XYZ");
        od2.sayHello("Xin chào");
        od2.sayHello(3.15);
    }
}
