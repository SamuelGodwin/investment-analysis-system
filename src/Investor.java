import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Investor {
    private String UUID;
    private ArrayList<Bond> bonds = new ArrayList<Bond>();
    private  final int INVESTMENT = 100;
    private double gain;

    public Investor(String UUID) {
        this.UUID = UUID;
    }
    public int getINVESTMENT() {
        return INVESTMENT;
    }

    public void purchase(Bond buyThat){
        bonds.add(buyThat);
        buyThat.setFraction(INVESTMENT/buyThat.getPrice());
        buyThat.setPurchaseDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
    double payoutF(Bond b){
        return b.payout() * b.getFraction();
    }
    public ArrayList<Bond> getBonds() {
        return bonds;
    }
    @Override
    public String toString() {
        return "UUID: " + UUID + " Bonds: " + bonds.toString();
    }
}
