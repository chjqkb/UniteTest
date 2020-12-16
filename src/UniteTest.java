import com.horstmann.corejava.Employee;
import com.horstmann.corejava.Manager;

import java.io.PrintStream;
import java.util.Arrays;

public class UniteTest {
    public static void main(String [] args){
        PrintStream out = System.out;
/*
        out.println("请输入你要检测的整数： ");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        out.printf("你输入的整数是奇数？ %b\n", isOdd(i));
 */

        /*
        Manager boss = new Manager("harry", 22222, 2019, 3, 5);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        //boss  = (Manager)staff[0];

        ((Manager)staff[0]).setBounus(5555);
        out.printf("name: %s, salary: %f\n", staff[0].getName(), staff[0].getSalary());


        //使用 instanceof 测试 子类是否== 超类
        //getClass() 返回对象运行时的「类」类型
        out.println(boss instanceof Employee);
        out.println(boss.getClass().getName());
        staff[1] = new Employee("calry", 7788, 2002, 5, 12);
        out.println( staff[1] instanceof  Employee);
        out.println(staff[1].getClass().getName());


        if(boss  instanceof Employee){
            out.println("yes");
        }
        if(boss.getClass() != staff[1].getClass()){
            out.println("no");
        }

        out.println("staff equals to boss: " + staff[1].equals( boss));

        //数组的 toString()
        out.println("" + staff);

        out.println(Arrays.deepToString( staff ));

 */




    }

    public static  boolean isOdd(int i){
        return i%2 !=0;
    }
}


