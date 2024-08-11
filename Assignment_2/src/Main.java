import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double[] speed = new double[5];
        double tspeed = 0;

        for (int i=0;i<5;i++)
        {
            System.out.println("Enter the speed of "+(i+1)+" racer: ");
            speed[i] = sc.nextDouble();
            tspeed += speed[i];
        }

        double avgspeed = tspeed/5;

        System.out.println("Qualifying racers are: ");
        for (int i = 0;i<5;i++)
        {
            if (speed[i]>avgspeed)
            {
                System.out.println("Racer "+(i+1));
            }
        }
    }
}