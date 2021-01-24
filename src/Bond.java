public class Bond {

    private String name;
    private double price;
    private int term; //number of years until expiry
    private double coupon; // interest
    private double frequency; //
    private String purchaseDate;
    private double fraction;

    public Bond(String name, double price, int term, double coupon, double frequency){
        this.name = name;
        this.price = price;
        this.term = term;
        this.coupon = coupon;
        this.frequency = frequency;
    }

    double payout(){
        return price + price * coupon * frequency * term;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getTerm() {
        return term;
    }
    public double getCoupon() {
        return coupon;
    }
    public double getFraction() {return fraction;}
    public double getFrequency() {
        return frequency;
    }
    public String getPurchaseDate() {return purchaseDate;}
    public void setFraction(double fraction) {this.fraction = fraction;}

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    @Override
    public String toString() {
        return "name : " + name + " price: " + price + " term: " + term + " coupon: " + coupon + " frequency: " + frequency;
    }
}
