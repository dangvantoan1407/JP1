package java2demo1.demo3;

public class SubRun implements Runnable{
    @Override
    public void run() {
        for (int i =0; i<20; i++) {
            System.out.println("i Run = "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
   }

