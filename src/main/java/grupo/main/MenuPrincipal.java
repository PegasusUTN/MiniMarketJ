package grupo.main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grupo.controladores.ControladorPrincipal;

public class MenuPrincipal {

    ControladorPrincipal controlador = new ControladorPrincipal();
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Scanner sc = new Scanner(System.in);

    public void menuPrincipal(){


        String opcion;

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
                        9. Nuevo plato
                        10. Salir
                        ==================================
            """);

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    controlador.getCobrarProductosControlador().cobrarProductos();
                    break;

                case "2":
                    controlador.getIngresoMercaderiaControlador().ingresoMercaderia();
                    break;

                case "3":
                    controlador.getPagoProveedor().pagoProveedor();
                    break;

                case "4":
                    controlador.getConsultaDeVentas().consultaDeVentas();
                    break;

                case "5":
                    controlador.getBalance().balance();
                    break;
                
                case "6":
                    controlador.getSolicitarComanda().solicitarComanda();
                    break;

                case "7":
                    controlador.getPagarCuenta().pagarCuenta();
                    break;

                case "8":
                    controlador.getInfoEstadisticaPlatos().infoEstadisticaPlatos();
                    break;

                case "9":
                    controlador.getNuevoPlato().nuevoPlato();
                    break;

                default:

            }

            if (opcion.equals("10")) break;

        } while (true);

        LOGGER.info("Saliendo del sistema");

    }

}
