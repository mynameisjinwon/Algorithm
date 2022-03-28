import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int korean, english, math;
    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    public String toString() {
        return "name : " + name + "\nkorean : " + korean + "\nenglish : " +english + "\nmath : " + math ;
    }
    @Override
    public int compareTo(Student student) {
        if(student.korean-this.korean!=0)
            return student.korean - this.korean;
        else if(this.english-student.english!=0)
            return this.english-student.english;
        else if(student.math-this.math!=0)
            return student.math-this.math;
        else
          //오름차순증가
            return this.name.compareTo(student.name);

    }

}
class Main {
    static Scanner sc = new Scanner(System.in);
    static Student[] students;
    static int cnt=0;
    static int N;
    public static void input() {
        String name;
        int k, e, m;
        N = sc.nextInt();
        students = new Student[N];

        for(int i=0;i<N;i++) {
            name = sc.next();
            k = sc.nextInt();
            e = sc.nextInt();
            m = sc.nextInt();

            students[cnt++] = new Student(name, k, e, m);
        }
    }
    public static void print() {
        for(int i=0;i<N;i++) {
            System.out.println(students[i].name);
        }
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(students);
        print();
    }
}
