import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner teclado = new Scanner(System.in);
    private String[] categoriesName = { "panaderia", "conservas", "drogueria", "lacteos", "alcohol", "pescaderia",
            "carniceria" };

    private List<Category> categoriesInitList = genCatList();

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
        while (option < 1 && option < 3) {
            System.out.println("No valid option");
            option = teclado.nextInt();
            teclado.nextLine();
        }
        return option;
    }

    public void registerProduct() {
    }

    public void manageProducts() {
        boolean exitProd = false;
        while (exitProd == false) {
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

    public void removeProduct() {
    }

    public void showProducts() {
    }

    public void manageShoopingCart() {
    }

    public void createBill() {
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
