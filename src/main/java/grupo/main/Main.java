package grupo.main;

import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grupo.entidades.Producto;
import grupo.entidades.Venta;
import grupo.persistencia.CrearTablasDAO;
import grupo.persistencia.ProductoDAO;
import grupo.persistencia.VentaDAO;

public class Main {

    ProductoDAO productoDAO = new ProductoDAO();
    VentaDAO ventaDAO = new VentaDAO();

    private static final Logger LOGGER = LogManager.getLogger();
    private static final CrearTablasDAO crearTablasDAO = new CrearTablasDAO();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Main principal = new Main();    
        crearTablasDAO.crearTablas();

        principal.menuPrincipal();

    }

    public void menuPrincipal(){

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
                    cobrarProductos();
                    break;

                case "2":

                    break;

                default:
                    throw new AssertionError();
            }

        } while (!opcion.equals("9"));


    }

}