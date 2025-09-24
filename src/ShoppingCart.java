import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String, Integer> carrito;
    private HashMap<String, Double> tienda;

    public ShoppingCart() {
        this.carrito = new HashMap<>();
        this.tienda = new HashMap<>();
        this.tienda.put(" manzana ", 0.50);
        this.tienda.put(" platano ", 0.30);
        this.tienda.put(" naranja ", 0.60);
        this.tienda.put(" leche ", 2.50);
        this.tienda.put(" pan", 1.50);
    }

    public void addProduct(String product, int cantida) {
        if (tienda.containsKey(product)) {
            carrito.put(product, cantida);
        } else {
            System.out.print("El producto no existe\n");
        }
    }


    public void eliminarProduct(String product) {
        if (carrito.containsKey(product)) {
            carrito.remove(product);
            System.out.printf("El producto %s eliminado\n", product);
        } else {
            System.out.print("El producto no esta en el carrito\n");
        }
    }

    public void updateCantidad(String product, int cantidad) {
        if (carrito.containsKey(product)) {
            int cantidadActual = carrito.get(product);
            if (cantidad <= 0) {
                carrito.remove(product);

            } else {
                carrito.put(product, cantidad);
                System.out.printf("El producto %s se ha actulizado a %d\n", product, cantidad);
            }
        } else {
            System.out.print("El producto no esta en el carrito\n");
        }
    }

    public void mostrarCarrito(){
        System.out.println("Contenido del carrito :");
        System.out.println("----------------------------------");

        for (String product : carrito.keySet()) {
            System.out.printf("%s - Cantidad: %d - Precio: $ %.2f ", product, carrito.get(product), tienda.get(product));
        }

        System.out.printf("Total : %.2f\n", calcularTotal());

    }

    public double calcularTotal(){
        double total = 0.0;
        for (String product : carrito.keySet()) {
            total = total + tienda.get(product);
        }
        if(total > 20.0){
            total = total * 0.90;
        }

        return Math.round(total * 100.0) / 100.0;
    }




}