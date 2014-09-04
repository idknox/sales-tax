package ianKnoxSalesTax.main;

import java.util.List;

public class Cart {
    private List<LineItem> cartItems;

    public Cart(List<LineItem> cartItems) {

        this.cartItems = cartItems;
    }

    public List<LineItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<LineItem> cartItems) {
        this.cartItems = cartItems;
    }
}
