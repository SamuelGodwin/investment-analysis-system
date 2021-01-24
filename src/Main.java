import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Investor petr = new Investor("PH_97");
        Brain sys = new Brain(petr);
        sys.createBond("UKbond", 100, 5, 0.10, 1);
        sys.createBond("USAbond", 103, 5, 0.05, 1);
        sys.createBond("CZbond", 95, 10, 0.04, 1);
        sys.createBond("DEbond", 92, 20, 0.03, 1);
        sys.createBond("RUbond", 120, 15, 0.02, 1);

       /* for (Bond b : sys.getBonds()) {
            petr.purchase(b);
        }*/

        /*System.out.println("sum payout is : " +  sys.sumPayout());
        for (Bond b : petr.getBonds()) {
            System.out.println("payout is : " + petr.payoutF(b));
            System.out.println("discounted payout is: " + sys.discountedPayout(b, 0.05));
            System.out.println("discounted payout is: " + sys.discountedPayout(b, 0.02));
            System.out.println("macaulayD is : " + sys.macaulayD(b, 0.05) );
            System.out.println("macaulayD is : " + sys.macaulayD(b, 0.02) );
            System.out.println("IRR is : " + sys.irr(b, 0.1)+ "\n");
        }*/
        //petr.purchase(sys.getBonds().get(0));

        System.out.println("Hello, here is a list of commands");
        System.out.println(
                        "exit - to close the application \n" +
                        "bonds - to show all available bonds and purchase\n" +
                        "my bonds - to show all purchased bonds \n" +
                        "create - to create bond \n"+
                        "back - to navigate to main menu \n" +
                        "payout - to show values of your bonds with r 0.05");

        Scanner scan =  new Scanner(System.in);
        String inp = scan.next();
        while (!inp.equals("exit")){
            if (inp.equals("bonds")){
                System.out.println("choose your bond by number");
                sys.printBonds();
                inp = scan.next();
                while (!inp.equals("back")) {
                    petr.purchase(sys.getBonds().get(Integer.parseInt(inp)));
                    System.out.println("your bonds: " + petr.getBonds() +"\n");
                    sys.printBonds();
                    inp = scan.next();
                }
            } else if (inp.equals("mybonds")) {
                if (petr.getBonds().size() == 0){
                    System.out.println("you have no bonds");
                }
                else System.out.println(petr);
            } else if (inp.equals("create")) {
                System.out.println("please enter info in format x,y, .. \n " +
                                   "name,price,term,coupon,frequency");
                inp = scan.next();
                String[] a = inp.split(",");
                sys.createBond(a[0],Double.parseDouble(a[1]),Integer.parseInt(a[2]),Double.parseDouble(a[3]),Double.parseDouble(a[4]));
                System.out.println("new bond created : " + sys.getBonds().get(sys.getBonds().size()-1));
            } else if (inp.equals("payout")) {
                if (petr.getBonds().size() == 0){
                    System.out.println("you have no bonds");
                }
                else {
                    for (Bond b : petr.getBonds()) {
                        System.out.println("payout is : " + petr.payoutF(b));
                        System.out.println("discounted payout is: " + sys.discountedPayout(b, 0.05));
                        System.out.println("macaulayD is : " + sys.macaulayD(b, 0.05));
                        System.out.println("IRR is : " + sys.irr(b, 0.1) + "\n");
                    }
                }
            }
            inp = scan.next();
        }
    }
}
