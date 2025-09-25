import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String, Integer> carrito;
    private HashMap<String, Double> tienda;

    public ShoppingCart() {
        this.carrito = new HashMap<>();
        this.tienda = new HashMap<>();
        this.tienda.put("manzana", 0.50);
        this.tienda.put("platano", 0.30);
        this.tienda.put("naranja", 0.60);
        this.tienda.put("leche", 2.50);
        this.tienda.put("pan", 1.50);
    }

    /**
     * Metodo que agrega productos al carrito del cliente si esta disponible en la tienda complejidad Big 0(1)
     * @param product
     * @param cantida
     */
    public void addProduct(String product, int cantida) {
        if (tienda.containsKey(product)) {
            carrito.put(product, cantida);
            System.out.printf("Se ha agregado %d de %s al carrito\n", cantida, product);
        } else {
            System.out.print("El producto no existe\n");
        }
    }

    /**
     * Metodo que elimina un producto del carrito del cliente si comprobando si lo tiene en el carrito Big O(1)
     * @param product
     */
    public void eliminarProduct(String product) {
        if (carrito.containsKey(product)) {
            carrito.remove(product);
            System.out.printf("El producto %s eliminado\n", product);
        } else {
            System.out.print("El producto no esta en el carrito\n");
        }
    }

    /**
     * Metodo que actuliza la cantidad de un producto en el carrito o elimina en caso de ser 0 o menor Big O(1)
     * @param product
     * @param cantidad
     */
    public void updateCantidad(String product, int cantidad) {
        if (carrito.containsKey(product)) {
            int cantidadActual = carrito.get(product);
            if (cantidad <= 0) {
                eliminarProduct(product);
            } else {
                carrito.put(product, cantidad);
                System.out.printf("El producto %s se ha actulizado a %d\n", product, cantidad);
            }
        } else {
            System.out.print("El producto no esta en el carrito\n");
        }
    }


    /**
     * Metodo que recorre todo el carrito y imprime los productos agregados y el total de cada cada producto y el total general
     * Big O(n)
     */
    public void mostrarCarrito(){
        System.out.println("\nContenido del carrito :");
        System.out.println("==========================================");

        for (String product : carrito.keySet()) {
            System.out.printf("%s - Cantidad: %d - Precio: $ %.2f\n", product, carrito.get(product), tienda.get(product)*carrito.get(product));
        }
        System.out.println("==========================================");
        System.out.printf("Total : %.2f$\n", calcularTotal());

    }

    /**
     * Metodo que calcula el valor total del carrito multiplicado cantidad de producto por precio y sumándolo a una var
     * Si el total supera los 20$ se aplica descuento de 10%
     * Complejidad de Big O(n)
     * @return
     */
    public double calcularTotal(){
        double total = 0.0;
        for (String product : carrito.keySet()) {
            total = total + tienda.get(product)*carrito.get(product);
        }
        if(total > 20.0){
            total = total * 0.90;
        }

        return Math.round(total * 100.0) / 100.0;
    }




}