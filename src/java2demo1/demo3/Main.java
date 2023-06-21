package java2demo1.demo3;

public class Main {
    public static void main(String[] args) {
        //sub thread
        SubThread st1 = new SubThread();
        st1.start();
        //sub runnable
        SubRun sr1 = new SubRun();
        Thread st2 = new Thread(sr1);
        st2.start();

        //functional interface -> lambda expression
        Runnable r1 = () ->{
            for (int i =0; i<20; i++) {
                System.out.println("i Lamba = "+i);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){}
            }

        };


        for (int i =0; i<20; i++) {
            System.out.println("i Main = "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }

        new Thread(() -> {
            for (int i =0; i<20; i++) {
                System.out.println("i Runnable = "+i);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
        }).start();

    };

}
