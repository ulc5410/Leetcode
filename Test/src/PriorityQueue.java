// Java program to demonstrate working of 
// comparator based priority queue constructor
import java.util.*;

class Example {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // Creating Priority queue constructor having 
        // initial capacity=5 and a StudentComparator instance 
        // as its parameters
        PriorityQueue<Student1> pq = new
                PriorityQueue<Student1>(5, new StudentComparator());

        // Invoking a parameterized Student constructor with
        // name and cgpa as the elements of queue
        Student1 student1 = new Student1("Nandini", 3.2);

        // Adding a student object containing fields
        // name and cgpa to priority queue
        pq.add(student1);
        Student1 student2 = new Student1("Anmol", 3.6);
        pq.add(student2);
        Student1 student3 = new Student1("Palak", 4.0);
        pq.add(student3);

        // Printing names of students in priority order,poll()
        // method is used to access the head element of queue
        System.out.println("Students served in their priority order");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
    }
}

class StudentComparator implements Comparator<Student1>{

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(Student1 s1, Student1 s2) {
        if (s1.cgpa < s2.cgpa)
            return 1;
        else if (s1.cgpa > s2.cgpa)
            return -1;
        return 0;
    }
}

class Student1 {
    public String name;
    public double cgpa;

    // A parameterized student constructor
    public Student1(String name, double cgpa) {

        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }
}