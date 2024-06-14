package grupo.controladores;

import java.time.LocalDate;
import java.util.ArrayList;

import grupo.entidades.Venta;

public class ConsultaDeVentas extends EsquemaOpciones{

    public void consultaDeVentas(){

        LOGGER.info("""
            =============Consulta de ventas==============
            a - Diaria
            b - Mensual
            =============================================
        """);
        String opcion = sc.nextLine().toLowerCase();

        if (opcion.equals("a")){

            menuA();

        }else if (opcion.equals("b")){

            menuB();

        }else{
            LOGGER.info("Volviendo al menu...");
        }

    }

    public void menuA(){
     
        ArrayList<Venta> ventas = new ArrayList<>(ventaDAO.consultarVentasDiarias(LocalDate.now()));

        if (ventas.size() > 0) {
            
            for (Venta venta : ventas) {
                
                LOGGER.info(String.format("""
                        -------------------------------
                        Venta:
                        Fecha: %s
                        Monto total: $%.2f
                        """, venta.getFecha(), venta.getMontoTotal()));
    
            }

        }else {
            LOGGER.info("No hay ventas el dia de hoy");
        }


    }
    
    private void menuB() {
        
        LOGGER.info("Anio a consultar:");
        int anio = Integer.parseInt(sc.nextLine());

        LOGGER.info("Mes del anio ingresado:");
        int mes = Integer.parseInt(sc.nextLine());

        ArrayList<Venta> ventas = new ArrayList<>(ventaDAO.consultarVentasMensuales(mes, anio));

        if (ventas.size() > 0) {
            
            for (Venta venta : ventas) {
                
                LOGGER.info(String.format("""
                        -------------------------------
                        Venta:
                        Fecha: %s
                        Monto total: $%.2f
                        """, venta.getFecha(), venta.getMontoTotal()));
    
            }

        }else{
            LOGGER.info("No hay en el periodo seleccionado");
        }


    }
}
