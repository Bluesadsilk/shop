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

    public void emptyShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void showItemSpecs(Product item) {
        System.out.println("Nombre : " + item.getProductName() + " Precio: " + item.getProductPrice() + " Cantidad: "
                + item.getProductStock());

    }

    public void showBill(List<Product> cartItems, double totalAmount) {
        for (int i = 0; i < cartItems.size(); i++) {
            showItemSpecs(cartItems.get(i));
        }
        System.out.println("Total: " + totalAmount);
    }

    public List<Product> returnBill() {
        List<Product> itemsCart = getCartItems();
        showBill(itemsCart, getItemsAmount());
        emptyShoppingCart();
        return itemsCart;
    }

    public void addItemToCart(Product x) {
        cartItems.add(x);
        setItemsAmount(calculeCartPrice());
    }

    public void removeItemOfCart(String productName) {
        for (int j = 0; j < cartItems.size(); j++) {
            if (cartItems.get(j).getProductName().equals(productName)) {
                cartItems.remove(j);
            }

        }
        setItemsAmount(calculeCartPrice());

    }

    public double calculeCartPrice() {
        double totalAmount = 0;
        for (int j = 0; j < cartItems.size(); j++) {
            totalAmount += cartItems.get(j).getProductStock() * cartItems.get(j).getProductPrice();
        }

        return totalAmount;
    }
}
