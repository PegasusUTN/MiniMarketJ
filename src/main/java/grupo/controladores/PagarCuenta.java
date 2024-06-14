package grupo.controladores;

import java.util.ArrayList;

import grupo.entidades.Comanda;

public class PagarCuenta extends EsquemaOpciones{

    public void pagarCuenta(){

        mostrarComandasAPagar();

        LOGGER.info("Ingrese el numero de la comanda que se abonara:");
        int numeroComanda = Integer.parseInt(sc.nextLine());
        
        if (comandaDAO.consultarComandaPorID(numeroComanda) != null && comandaDAO.consultarComandaPorID(numeroComanda).getMontoTotal() > 0) {
            
            Comanda comanda = comandaDAO.consultarComandaPorID(numeroComanda);
    
            comanda.setMontoTotal(0);
    
            comandaDAO.modificarComanda(comanda);
    
            LOGGER.info("Cuenta pagada!!!");
        }else{
            LOGGER.info("La comanda seleccionada no existe o ya fue pagada!");
        }


    }

    public void mostrarComandasAPagar(){

        ArrayList<Comanda> comandas = comandaDAO.consultarComandasAPagar();

        if (comandas != null) {
            
            for (Comanda comanda : comandas) {
                
                LOGGER.info(String.format("""
                        -----------------------------
                        Numero de comanda: %d
                        Fecha: %s
                        Monto a pagar: %.2f
                        """, comanda.getId(), comanda.getFecha(), comanda.getMontoTotal()));

            }

        }else{
            LOGGER.info("No hay comandas a pagar!");
        }

    }

}
