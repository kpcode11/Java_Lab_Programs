import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the employee number: ");
        int empno = sc.nextInt();

        System.out.println("Enter the employee name: ");
        String empname = sc.next();

        System.out.println("Enter the basic salary: ");
        double basic = sc.nextDouble();


        double da = 0.7 * basic;
        double hra = 0.3 * basic;
        double cca = 240;
        double pf = 0.1 * basic;
        double pt = 100;

        double grosssalary = basic + da + hra + cca;
        double netsalary = grosssalary - (pt+pf);

        System.out.println("\nEmployee Details are:");
        System.out.println("Employee Number: "+empno);
        System.out.println("Employee Name: "+empname);
        System.out.println("Basic Salary: "+basic);
        System.out.println("DA: "+da);
        System.out.println("HRA: "+hra);
        System.out.println("CCA: "+cca);
        System.out.println("PF: "+pf);
        System.out.println("PT: "+pt);
        System.out.println("Gross_Salary: "+grosssalary);
        System.out.println("Net_Salary: "+netsalary);
    }
}