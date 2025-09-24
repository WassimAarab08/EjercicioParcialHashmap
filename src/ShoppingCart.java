import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String, Integer> cart;
    private HashMap<String, Double> prices;

    public ShoppingCart() {
        this.cart = new HashMap<>();
        this.prices = new HashMap<>();
        this.prices.put(" manzana ", 0.50);
        this.prices.put(" platano ", 0.30);
        this.prices.put(" naranja ", 0.60);
        this.prices.put(" leche ", 2.50);
        this.prices.put(" pan", 1.50);
    }

    public void addProduct(String product, int cantida) {
        if (prices.containsKey(product)) {
            cart.put(product, cantida);
        } else {
            System.out.print("El producto no existe\n");
        }
    }


    public void eliminarProduct(String product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
            System.out.printf("El producto %s eliminado\n", product);
        } else {
            System.out.print("El producto no esta en el carrito\n");
        }
    }

    public void updateCantidad(String product, int cantidad) {
        if (cart.containsKey(product)) {
            int cantidadActual = cart.get(product);
            if (cantidad <= 0) {
                cart.remove(product);

            } else {
                cart.put(product, cantidad);
                System.out.printf("El producto %s se ha actulizado a %d\n", product, cantidad);
            }
        } else {
            System.out.print("El producto no esta en el carrito\n");
        }
    }

    public void mostrarCarrito(){
        System.out.println("Contenido del carrito :");
        System.out.println("----------------------------------");
        double total = 0.0;
        for (String product : cart.keySet()) {
            total = total + prices.get(product);
            System.out.printf("%s - Cantidad: %d - Precio: $ %.2f ", product, cart.get(product), prices.get(product));
        }

        System.out.printf("Total : %.2f\n", total);

    }

    public void calcularTotal(){



    }




}