import com.horstmann.corejava.Employee;
import com.horstmann.corejava.Manager;

import java.io.PrintStream;
import java.util.Scanner;

public class UniteTest {
    public static void main(String [] args){
        PrintStream out = System.out;
/*
        out.println("请输入你要检测的整数： ");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        out.printf("你输入的整数是奇数？ %b\n", isOdd(i));
 */

        Manager boss = new Manager("harry", 22222, 2019, 3, 5);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        //boss  = (Manager)staff[0];

        ((Manager)staff[0]).setBounus(5555);
        out.printf("name: %s, salary: %f\n", staff[0].getName(), staff[0].getSalary());

    }

    public static  boolean isOdd(int i){
        return i%2 !=0;
    }
}


