public class Advertisements {
    // Declares this Class Attributes
    private String customer; // Customer name
    private String ad; // Customer advertisement
    private Float fee; // Advertisement paid fee  

    // Getters & Setters
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getText() {
        return ad;
    }
    public void setText(String text) {
        this.ad = text;
    }
    
    public Float getFee() {
        return fee;
    }
    
    public void setFee(Float fee) {
        this.fee = fee;
    }

    // Constractor + Arguments
    public Advertisements(String customer, String ad, Float fee) {
        // Calls in setters for the initialization of the attributes
        this.setCustomer(customer);
        this.setText(ad);
        this.setFee(fee);
    }
}