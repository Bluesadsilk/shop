import java.util.List;
import java.util.ArrayList;

public class Category {
        public String catName;
        public List<Product> productList;

        // Arrays defining products, prices, categories, and stock
        private String[] products = { "Pan blanco", "Atún enlatado", "Jabón en polvo", "Leche entera", "Cerveza",
                        "Filete de salmón", "Chuleta de cerdo", "Pan integral", "Sardinas en conserva",
                        "Detergente líquido",
                        "Croissant", "Mermelada de fresa", "Papel higiénico", "Yogur natural", "Vino tinto",
                        "Calamar fresco",
                        "Ternera picada", "Tostadas de trigo", "Aceite de oliva", "Lavavajillas", "Baguette",
                        "Salmón ahumado",
                        "Carne de pollo", "Queso cheddar", "Refresco de cola", "Trucha fresca", "Costillas de cordero",
                        "Pan de centeno", "Anchoas en conserva", "Detergente en cápsulas", "Dona", "Miel",
                        "Papel de cocina",
                        "Kéfir", "Champán", "Pulpo fresco", "Carne de ternera", "Galletas integrales",
                        "Vinagre balsámico",
                        "Desengrasante", "Croquetas de bacalao", "Leche de almendras", "Salsa de tomate",
                        "Agua mineral",
                        "Bacalao fresco", "Carne de cerdo", "Pan de molde", "Sardinas en aceite", "Crema hidratante" };

        private double[] prices = { 1.50, 2.75, 3.20, 1.80, 2.00, 5.50, 4.75, 2.00, 1.90, 4.25, 1.20, 2.50, 2.10, 0.90,
                        8.50, 6.75, 3.80, 2.30, 5.00, 3.45, 1.80, 7.20, 3.50, 4.00, 1.50, 9.75, 8.60, 2.85, 2.20, 5.10,
                        6.30,
                        1.10, 3.80, 2.25, 11.50, 5.20, 7.90, 6.45, 2.75, 4.80, 3.30, 3.90, 1.95, 4.10, 1.70, 2.40, 5.60,
                        3.15,
                        2.60 };

        private String[] categories = { "panaderia", "conservas", "drogueria", "lacteos", "alcohol", "pescaderia",
                        "carniceria", "panaderia", "conservas", "drogueria", "panaderia", "conservas", "drogueria",
                        "lacteos",
                        "alcohol", "pescaderia", "carniceria", "panaderia", "conservas", "drogueria", "panaderia",
                        "pescaderia",
                        "carniceria", "lacteos", "alcohol", "pescaderia", "carniceria", "panaderia", "conservas",
                        "drogueria",
                        "panaderia", "conservas", "drogueria", "lacteos", "alcohol", "pescaderia", "carniceria",
                        "panaderia",
                        "conservas", "drogueria", "panaderia", "conservas", "drogueria", "lacteos", "alcohol",
                        "pescaderia",
                        "carniceria" };

        private int[] stock = { 20, 15, 30, 25, 10, 12, 18, 20, 10, 35, 22, 18, 40, 30, 8, 14, 20, 25, 15, 28, 20, 10,
                        18, 15, 20, 12, 10, 25, 30, 18, 15, 22, 28, 12, 8, 20, 25, 10, 30, 18, 25, 14, 20, 15, 20, 12,
                        28, 25 };

        public Category(String catName) {
                this.catName = catName;
                this.productList = generateProducts();
        }

        public List<Product> generateProducts() {
                List<Product> productInit = new ArrayList<>();
                for (int i = 0; i < categories.length; i++) {
                        if (catName.equals(categories[i])) {
                                Product x = new Product(products[i], categories[i], prices[i], stock[i]);
                                productInit.add(x);
                        }
                }
                return productInit;
        }

        public String getCatName() {
                return catName;
        }

        public void setCatName(String catName) {
                this.catName = catName;
        }

        public List<Product> getProductList() {
                return productList;
        }

        public void setProductList(List<Product> productList) {
                this.productList = productList;
        }

        // Getters and setters for other fields if needed
}
