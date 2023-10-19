import java.util.Scanner;

public class Route {
    static Scanner scan = new Scanner(System.in);
    static int route;

    public static void main(String[] args) {
        
        String block;
        int i = 0;
         
        System.out.println("WELCOME TO SOUTHBUS TERMINAL!\n");
        do {
            try {
                System.out.print("Is the road to Barili blocked? ");
                block = scan.nextLine();
                if(block.equalsIgnoreCase("yes")) {
                    System.out.print("Is the road to Dumanjug blocked? ");
                    block = scan.nextLine();
                    if(block.equalsIgnoreCase("yes")) {
                        route = 3;
                        i++;
                        routeChoice();
                    } else if (block.equalsIgnoreCase("no")) {
                        route = 2;
                        i++;
                        routeChoice();
                    } else {
                        System.out.println("Please input only Yes or No");
                        i = 0;
                    }
                } else if (block.equalsIgnoreCase("no")){
                    route = 1;
                    i++;
                    routeChoice();
                } else {
                    System.out.println("Please input only Yes or No\n");
                    i = 0;
                }
            } catch (Exception e) {
                System.out.println("Exception Caught! Invalid Input! ");
                block = scan.nextLine();
            }
        } while(i == 0);
    }
    public static void routeChoice() {
        double distance;
        int speed;
        String routeWay;
        
        if(route == 3) {
            distance = 108;
            routeWay = "\nSouthbus Terminal - START \nMinglanilla - Route 1 \nSan Fernando - Route 2 \nCarcar - Route 3 \nSibonga - Route 4.2 \nArgao - Route 5 \nRonda - Route 5.1 \nAlcantra - Route 5.2 \nMoalboal - END";
            System.out.print("Enter speed in km: ");
            speed = scan.nextInt();
        }         
        else if(route == 2) {
            distance = 98;
            routeWay = "\nSouthbus Terminal - START \nMinglanilla - Route 1 \nSan Fernando - Route 2 \nCarcar - Route 3 \nSibonga - Route 4.2 \nDumanjug - Route 4.2.1 \nAlcantara - Route 4.2.2 \nMoalboal - END";
            System.out.print("Enter speed in km: ");
            speed = scan.nextInt();
        }         
        else {
            distance = 84.9;
            routeWay = "\nSouthbus Terminal - START \nMinglanilla - Route 1 \nSan Fernando - Route 2 \nCarcar - Route 3 \nBarili - Route 4.1 \nDumanjug - Route 4.1.1 \nAlcantara Route 4.1.2 \nMoalboal - END";
            System.out.print("Enter speed in km: ");
            speed = scan.nextInt();
        }
        System.out.println("\n==========RECOMMENDED ROUTE==========");
        System.out.println(routeWay);
        System.out.println("\nSpeed: " + speed + " km/hr");
        System.out.println("Distance: " + distance + " km"); 
        System.out.println("ETA: " + (int)(distance/speed) + " Hour(s) " + (int)((distance/speed * 60) % 60) + " Minutes(s) ");
        System.out.println("=====================================");
    }
}