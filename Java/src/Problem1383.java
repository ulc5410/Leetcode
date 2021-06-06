import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1383 {

    static class Employee{
        int speed;
        int efficiency;

        public Employee (int s, int e){
            this.speed = s;
            this.efficiency = e;
        }
    }

    static class SpeedComparator implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return a.speed - b.speed; //ascending order
        }
    }

    static class SortbyEfficiency implements Comparator<Employee>
    {
        public int compare(Employee a, Employee b)
        {
            return b.efficiency - a.efficiency; //descending order
        }
    }

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Employee [] employees = new Employee[speed.length];
        for (int i = 0; i<employees.length; i++) {
            employees[i] = new Employee(speed[i], efficiency[i]);
        }

        Arrays.sort(employees, new SortbyEfficiency());

        long score = 0;
        long speed_sum = 0;
        PriorityQueue<Employee> current_high = new PriorityQueue<Employee>(k, new SpeedComparator());

        for (int i=0; i<employees.length; i++){
            if (current_high.size() == k) {
                speed_sum = speed_sum - current_high.poll().speed;
            }
            current_high.add(employees[i]);
            speed_sum += employees[i].speed;
            score = Math.max(score, employees[i].efficiency*speed_sum);
        }

        return  (int)( score % (int)(1e9 + 7));
    }

    public static void main(String[] args) {
        int n = 6;
        int [] speed = {2,10,3,1,5,8};
        int [] efficiency = {5,4,3,9,7,2};
        int k = 4;

        System.out.println( maxPerformance(n, speed, efficiency, k));
    }
}
