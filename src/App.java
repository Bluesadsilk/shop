import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner teclado = new Scanner(System.in);
    public String[] categoriesName = { "panaderia", "conservas", "drogueria", "lacteos", "alcohol", "pescaderia",
            "carniceria" };

    public List<Category> categoriesInitList = genCatList();

    public ShoppingCart userCart = new ShoppingCart();

    public List<Category> genCatList() {
        List<Category> categoriesInitList = new ArrayList<>();
        for (int i = 0; i < categoriesName.length; i++) {
            Category x = new Category(categoriesName[i]);
            categoriesInitList.add(x);
        }
        return categoriesInitList;
    }

    public String[] getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String[] categoriesName) {
        this.categoriesName = categoriesName;
    }

    public List<Category> getCategoriesInitList() {
        return categoriesInitList;
    }

    public void setCategoriesInitList(List<Category> categoriesInitList) {
        this.categoriesInitList = categoriesInitList;
    }

    public ShoppingCart getUserCart() {
        return userCart;
    }

    public void setUserCart(ShoppingCart userCart) {
        this.userCart = userCart;
    }

    public void showOptions() {

        System.out.println("1. Manage Products");
        System.out.println("2. Show Products");
        System.out.println("3. Manage Shopping Cart");
        System.out.println("4. Create Bill");
        System.out.println("5. Exit");
    }

    public void showProdOptions() {
        System.out.println("1. Register product");
        System.out.println("2. Remove product");
        System.out.println("3. Exit");
    }

    public void showCartOptions() {
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Clear Shopping Cart");
        System.out.println("4. Exit");
    }

    public void showProducts() {
        for (int i = 0; i < categoriesInitList.size(); i++) {
            categoriesInitList.get(i).ShowCatProducts();
        }
    }

    public int chooseOption() {
        int option = teclado.nextInt();
        teclado.nextLine();
        while (option > 5 && option < 1) {
            System.out.println("No valid option");
            option = teclado.nextInt();
            teclado.nextLine();
        }
        return option;
    }

    public int chooseProdOption() {
        int option = teclado.nextInt();
        teclado.nextLine();
        while (option > 3 && option < 1) {
            System.out.println("No valid option");
        }

        return option;
    }

    public int chooseCartOption() {
        int option = teclado.nextInt();
        teclado.nextLine();
        while (option < 1 && option < 4) {
            System.out.println("No valid option");
            option = teclado.nextInt();
            teclado.nextLine();
        }
        return option;
    }

    public void adjustItem(String catName, String prodName, int stockToAdjust) {
        for (int i = 0; i < categoriesInitList.size(); i++) {
            if (categoriesInitList.get(i).getCatName().equals(catName)) {
                for (int j = 0; j < categoriesInitList.get(i).getProductList().size(); j++) {
                    if (categoriesInitList.get(i).getProductList().get(j).getProductName().equals(prodName)) {
                        categoriesInitList.get(i).getProductList().get(j).setProductStock(-stockToAdjust);
                    }
                }
            }

        }

    }

    public void adjustStock(List<Product> forAdjust) {
        for (int i = 0; i < forAdjust.size(); i++) {
            adjustItem(forAdjust.get(i).getProductCat(), forAdjust.get(i).getProductName(),
                    forAdjust.get(i).getProductStock());

        }
    }

    public void manageProducts() {
        boolean exitProd = false;
        while (exitProd == false) {
            showProdOptions();
            int option = chooseProdOption();
            switch (option) {
                case 1:
                    registerProduct();
                    break;

                case 2:
                    removeProduct();
                    break;

                case 3:
                    exitProd = true;
                    break;

                default:
                    exitProd = true;
                    break;
            }
        }
    }

    public void registerProduct() {
    }

    public void modifyProduct(Product item) {
    }

    public void removeProduct() {
    }

    public String chooseProductName() {
        System.out.println("Choose item");
        String itemName = teclado.nextLine();
        return itemName;
    }

    public Product returnProduct(String name) {
        for (int i = 0; i < categoriesInitList.size(); i++) {
            Category cat = getCategoriesInitList().get(i);
            for (int j = 0; j < cat.getProductList().size(); j++) {
                Product prod = cat.productList.get(j);
                if (prod.getProductName().equals(name)) {
                    return prod;
                }
            }

        }
        Product error = new Product();
        System.out.println("Error");
        return error;

    }

    public void AddCartItem() {
        String itemName = chooseProductName();
        Product prodTransitional = returnProduct(itemName);
        if (prodTransitional.getProductName().equals("error 404")) {
            System.out.println("Item not found");
        } else {
            userCart.addItemToCart(prodTransitional);
        }
    }

    public void removeCartItem() {
        String itemName = chooseProductName();
        Product prodTransitional = returnProduct(itemName);
        if (prodTransitional.getProductName().equals("error 404")) {
            System.out.println("Item not found");
        } else {
            userCart.removeItemOfCart(itemName);
        }
    }

    public void manageShoopingCart() {
        boolean exitCart = false;
        while (exitCart == false) {
            showCartOptions();
            int cartOption = chooseCartOption();
            switch (cartOption) {
                case 1:
                    AddCartItem();
                    break;

                case 2:
                    removeCartItem();
                    break;

                case 3:
                    userCart.emptyShoppingCart();
                    break;

                case 4:
                    exitCart = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void createBill() {
        List<Product> toRemove = userCart.returnBill();
        adjustStock(toRemove);
    }

    public static void main(String[] args) throws Exception {
        App main = new App();
        boolean exit = false;
        while (exit == false) {
            main.showOptions();
            int option = main.chooseOption();
            switch (option) {
                case 1:
                    main.manageProducts();

                    break;

                case 2:
                    main.showProducts();

                    break;

                case 3:
                    main.manageShoopingCart();
                    break;

                case 4:
                    main.createBill();

                    break;

                case 5:
                    exit = true;
                    main.teclado.close();
                    break;

                default:
                    exit = true;
                    break;
            }
        }

    }
}
