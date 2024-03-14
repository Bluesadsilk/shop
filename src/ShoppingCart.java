/*
*
* 
*
* Creada el 14 mar 2024, 19:11:08
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 14 mar 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 14 mar 2024
*/

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private int numberItems = 0;
    private double itemsAmount = 0;
    private List<Product> cartItems = new ArrayList<>();

    public ShoppingCart() {
    }

    public int getNumberItems() {
        return numberItems;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }

    public double getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(double itemsAmount) {
        this.itemsAmount = itemsAmount;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

}
