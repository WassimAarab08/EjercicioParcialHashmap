public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("manzana", 3);
        cart.addProduct("leche", 2);
        cart.addProduct("pan", 1);
        cart.mostrarCarrito();

        cart.updateCantidad("manzana", 5);
        cart.eliminarProduct("pan");
        cart.mostrarCarrito();

        cart.addProduct("chocolate", 1);
        cart.addProduct("naranja", 10);
        cart.mostrarCarrito();
    }
}
