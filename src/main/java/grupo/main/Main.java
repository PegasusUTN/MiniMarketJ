package grupo.main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grupo.entidades.Producto;
import grupo.persistencia.CrearTablasDAO;
import grupo.persistencia.ProductoDAO;

public class Main {

    ProductoDAO productoDAO = new ProductoDAO();

    private static final Logger LOGGER = LogManager.getLogger();
    private static final CrearTablasDAO crearTablasDAO = new CrearTablasDAO();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        crearTablasDAO.crearTablas();

        menuPrincipal();

    }

    public static void menuPrincipal(){

        String opcion = null;

        do { 
            
            LOGGER.info("""
                        ==========Menu Principal==========
                        1. Vender/Cobrar productos
                        2. Ingreso de mercaderia
                        3. Pago a proveedor
                        4. Consulta de ventas
                        5. Balance
                        6. Solicitar comanda
                        7. Pagar cuenta
                        8. Informacion estadistica de platos mas pedidos
                        9. Salir
                        ==================================
            """);

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    
                    break;
                default:
                    throw new AssertionError();
            }

        } while (!opcion.equals("9"));


    }

    public void cobrarProductos(){

        String nombre;

        float montoTotal = 0;

        do {
            
            LOGGER.info("Ingrese el nombre del producto. Si no desea ingresar mas productos unicamente presione ENTER");
            nombre = sc.nextLine();

            if (!nombre.equals("")) {
                
                Producto producto = productoDAO.buscarProducto(nombre);
    
                if((producto != null)){
    
                    LOGGER.info("Cuantas unidades del producto se venderan?");
                    int cantidad = Integer.parseInt(sc.nextLine());
    
                    if ((producto.getStock() - cantidad) >= 0){
    
                        producto.setStock(producto.getStock()-cantidad);

                        montoTotal += cantidad*producto.getPrecio();

                        productoDAO.modificarProducto(producto);
    
                    }else{
                        LOGGER.info("No hay suficientes unidades del producto seleccionado!");
                    }
    
                }else{
                    LOGGER.info("El producto ingresado no existe!");
                }

            }

        } while (nombre.equals(""));

    }

}