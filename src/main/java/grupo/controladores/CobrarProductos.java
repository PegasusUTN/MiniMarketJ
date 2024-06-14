package grupo.controladores;

import java.util.Date;

import grupo.entidades.Producto;
import grupo.entidades.Venta;
import java.util.ArrayList;

public class CobrarProductos extends EsquemaOpciones{

    public void cobrarProductos() {

        String nombre;

        float montoTotal = 0;

        do {

            ArrayList<Producto> productos = this.productoDAO.buscarProductos();
            int contador = 0;
            if (productos != null) {
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getStock() > 0) {
                        contador += 1;
                        LOGGER.info(contador + ". " + productos.get(i).getNombre() + " " + productos.get(i).getStock() + " unidades disponibles.");
                    }
                }
            } else {
                LOGGER.info("No hay productos, debe comprar para poder venderlos");
                return;
            }
            LOGGER.info("Ingrese el nombre del producto. Si no desea ingresar mas productos unicamente presione ENTER");
            nombre = sc.nextLine();

            if (!nombre.equals("")) {

                Producto producto = productoDAO.buscarProducto(nombre);

                if ((producto != null)) {

                    LOGGER.info("Cuantas unidades del producto se venderan?");
                    int cantidad = Integer.parseInt(sc.nextLine());

                    if ((producto.getStock() - cantidad) >= 0) {

                        producto.setStock(producto.getStock() - cantidad);

                        montoTotal += cantidad * producto.getPrecio();

                        productoDAO.modificarProducto(producto);

                    } else {
                        LOGGER.info("No hay suficientes unidades del producto seleccionado!");
                    }

                } else {
                    LOGGER.info("El producto ingresado no existe!");
                }

            } else {
                if (nombre.equals("")) {
                    break;
                }
            }

        } while (true);

        Venta venta = new Venta(new Date(), montoTotal);

        ventaDAO.insertarVenta(venta);

    }

}
