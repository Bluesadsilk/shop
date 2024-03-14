/*
*
* 
*
* Creada el 14 mar 2024, 18:58:35
*
* Desarrollada por Bluesadsilk en l'empresa Abastos el dia 14 mar 2024
*
* Email de contacto: bluesadsilk@proton.me
*
*
* @autor Bluesadsilk
* @date 14 mar 2024
*/
public class Product {
    private String productName;
    private String productCat;
    private double productPrice;
    private int productStock;

    public Product(String productName, String productCat, double productPrice, int productStock) {
        this.productName = productName;
        this.productCat = productCat;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCat() {
        return productCat;
    }

    public void setProductCat(String productCat) {
        this.productCat = productCat;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

}
