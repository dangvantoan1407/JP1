package java2demo1.demo4;

public class DemoMain {
    public static void main(String[] args) {
        Data d = new Data();
        Runnable r = () ->{
            for (int i=0; i<20;i++) {
                synchronized (d) {//khóa phạm vi
                    d.change();
                    d.print();
                }
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
//        t1.start();
//        t2.start();
        Thread tr1 = new Thread(() ->{
            for (int i=0; i<5; i++) {
                System.out.println("tr1 " +i);
            }
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        });


        Thread tr2 = new Thread(() ->{
            for (int i=0; i<5; i++) {
                System.out.println("tr2 " +i);
            }
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        });

        Thread tr3 = new Thread(() ->{
            for (int i=0; i<5; i++) {
                System.out.println("tr3 " +i);
            }
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        });

        try{
            tr1.join();
        }catch (Exception e){}
        tr2.start();
        tr3.start();

    }
}
