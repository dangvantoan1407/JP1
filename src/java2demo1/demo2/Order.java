package java2demo1.demo2;

public class Order <X> {
    private X code;

    public X getCode() {
        return code;
    }

    public void setCode(X code) {
        this.code = code;
    }
    public void Print() {
        System.out.println(code);
    }
    public <Y> void sayHello(Y msg) {
        System.out.println(msg);
    }

}
