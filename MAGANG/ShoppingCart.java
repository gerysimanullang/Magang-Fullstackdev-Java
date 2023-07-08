import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private List<Product> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cartItems.add(product);
        System.out.println("Produk \"" + product.getName() + "\" berhasil ditambahkan ke keranjang.");
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Keranjang belanja kosong.");
        } else {
            System.out.println("Isi keranjang belanja:");
            for (Product product : cartItems) {
                System.out.println("Nama: " + product.getName());
                System.out.println("Harga: " + product.getPrice());
                System.out.println("===========================");
            }
        }
    }

    public static void main(String[] args) {
        List<Product> productList = createProductData();

        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Lihat daftar produk");
            System.out.println("2. Tambahkan produk ke keranjang");
            System.out.println("3. Lihat keranjang belanja");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Daftar Produk:");
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getId());
                        System.out.println("Nama: " + product.getName());
                        System.out.println("Harga: " + product.getPrice());
                        System.out.println("===========================");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan ID produk yang ingin ditambahkan ke keranjang: ");
                    int productId = scanner.nextInt();
                    Product selectedProduct = null;
                    for (Product product : productList) {
                        if (product.getId() == productId) {
                            selectedProduct = product;
                            break;
                        }
                    }
                    if (selectedProduct != null) {
                        cart.addToCart(selectedProduct);
                    } else {
                        System.out.println("Produk dengan ID tersebut tidak ditemukan.");
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        System.out.println("Terima kasih telah menggunakan aplikasi keranjang belanja.");
    }

    private static List<Product> createProductData() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Produk A", 10000));
        productList.add(new Product(2, "Produk B", 20000));
        productList.add(new Product(3, "Produk C", 30000));
        return productList;
    }
}

class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
