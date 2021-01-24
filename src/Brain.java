import java.util.ArrayList;
import java.math.*;
public class Brain {
    Investor investor;
    ArrayList<Bond> bonds = new ArrayList<>();


    public Brain(Investor inv){
        this.investor = inv;

    }
    public void createBond(String name, double price, int term, double coupon, double frequency){
        bonds.add(new Bond(name, price, term, coupon, frequency));
    }

    public void printBonds(){
        for (int i = 0; i < bonds.size(); i++){
            System.out.println(i + ") " + "Bond: " + bonds.get(i));
        }

    }
    int sumPayout(){
        int sum = 0;
        for (Bond i : investor.getBonds()){
            sum += investor.payoutF(i);
        }
        return sum;
    }
    double discountedPayout(Bond bond, double r){
        double sum = 0;
        for (int i = 1; i < bond.getTerm(); ++i){
            sum += (investor.getINVESTMENT()*bond.getCoupon()/Math.pow(1 + r, i));
        }
        sum += ((investor.getINVESTMENT()*bond.getCoupon() + investor.getINVESTMENT())/Math.pow(1 + r, bond.getTerm()));
        return sum;
    }
    public double macaulayD(Bond bond, double rate){
        double temp = 0;
        for (int i = 1; i <= bond.getTerm(); i++){
            temp += (i*bond.getCoupon()*100/Math.pow(1 + rate,i));
        }
        return (temp + ((bond.getTerm()*100)/Math.pow(1 + rate,bond.getTerm()))) / discountedPayout(bond, rate);
    }

    public double irr (Bond bond, double r) {
        double rate = r;
        double price = bond.getPrice();
        int i = 0;

        while( i < 50000) {
            if (discountedPayout(bond,rate) < price) {
                rate -= 0.00001;} else { rate += 0.00001; }
            i++;
        }
        return rate;
    }

    public ArrayList<Bond> getBonds() {
        return bonds;
    }
    @Override
    public String toString() {
        return "All Bonds: " + bonds.toString() + " Investor: " + investor;
    }
}
