// Class
public class Message {
    
    // Attributes
    private String customer;
    private String text;
    private Float fee;
        

    // Getters & Setters
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    public Float getFee() {
        return fee;
    }
    public void setFee(Float fee) {
        this.fee = fee;
    }

        // Constractor + Arguments
        public Message(String customer, String text, Float fee) {
        
            // Call in setters for initialization of the attributes
            this.setCustomer(customer);
            this.setText(text);
            this.setFee(fee);
        }



}
