package java2demo1;

import javafx.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("hello");
        hs.add("hello");
        hs.add("world");
        System.out.println("Count: " + hs.size());
        //Vd viết chường trình nhập vào 10 số nguyên khác nhau

//        HashSet<Integer> hs1 = new HashSet<>();
//        Scanner sc = new Scanner(System.in);
//
//      while (hs1.size() < 10) {
//          System.out.println("Nhập 1 số nguyên: ");
//          hs1.add(sc.nextInt());
//          int i = sc.nextInt();
//          if(hs1.contains(i)){
//              System.out.println("Số đã tồn tại ");
//          } else {
//              hs1.add(i);
//          }
//      }
//        System.out.println("Các số đã nhập");
//      for (int i : hs1) {
//          System.out.println(i);
//      }

        PriorityQueue<Integer> ps = new PriorityQueue<>();
        ps.add(4);
        ps.add(1);
        ps.add(5);
        ps.add(8);
        while (ps.size() > 0){
            int i = 0;
            i = ps.poll();
            System.out.println("queue: " + i);
        }
        PriorityQueue<Student> spt = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("B10",20);
        hm.put("A5",18);
        System.out.println(hm.get("B10"));

    }
}
