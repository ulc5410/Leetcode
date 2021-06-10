import java.util.*;


//
class  MyCalendar {
    ArrayList<Interval>  booked = new ArrayList();
    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        for(int i =0; i<booked.size();i++){
            if(booked.get(i).end > start){
                if (booked.get(i).start < end) return false;
                else break;
            }
        }
        booked.add(new Interval(start, end));
        Collections.sort(booked, new IntervalComparator());
        return true;
    }
}

class Interval{
    int start, end;

    Interval(int s, int e){
        start = s;
        end = e;
    }
}
class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2) {
        //ascending order
        return i1.start - i2.start;
    }
}


class Main {
    public static void main(String[] args) {

//        Test.MyCalendar.MyCalendar();
        MyCalendar test = new MyCalendar();
//        test.booked.add("sss");
        System.out.println(test.book(10, 20)); // returns true
        System.out.println(test.book(15, 25)); // returns false
        System.out.println(test.book(20, 30)); // returns true
        System.out.println(test.book(1, 10));
        System.out.println(test.book(30, 40));

    }
}
