package Project;

//represents a cart item entry
class CartItem {
    public final Integer itemID, quant, reqQuant;
    public final Double price, disc, finalPrice;
    public final String desc;
    public CartItem(Integer id, Integer quantity, Integer requestedQuantity, Double price, String description) {
        this.itemID = id;
        this.quant = quantity;
        this.reqQuant = requestedQuantity;
        this.price = price;
        this.desc = description;

        //discount calculator

        if(reqQuant < 5)
            this.disc = 0.0;
        else if(reqQuant < 10)
            this.disc = 0.10;
        else if(reqQuant < 15)
            this.disc = 0.15;
        else
            this.disc = 0.20;

        this.finalPrice = (reqQuant * price) * (1 - disc);
    }
}
