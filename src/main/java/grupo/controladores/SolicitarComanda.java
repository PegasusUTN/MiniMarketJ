package grupo.controladores;

import java.util.ArrayList;
import java.util.Date;

import grupo.entidades.Comanda;
import grupo.entidades.Plato;

public class SolicitarComanda extends EsquemaOpciones{

    public void solicitarComanda(){

        Comanda comanda = new Comanda();

        float montoTotal = agregarPlato();

        comanda.setMontoTotal(montoTotal);
        comanda.setFecha(new Date());

        comandaDAO.insertarComanda(comanda);

        LOGGER.info("Comanda realizada!");

    }

    public float agregarPlato() {

        float montoTotal = 0;

        do {

            mostrarPlatos();

            LOGGER.info("Ingrese el nombre del plato. Si no desea agregar mas platos presione unicamente ENTER:");
            String nombrePlato = sc.nextLine();

            if (nombrePlato.equals("")) {
                break;
            }

            Plato plato = platoDAO.consultarPlato(nombrePlato);

            if (plato != null) {
                
                montoTotal += plato.getPrecio();
                int pedidoPlato = plato.getVecesPedido() + 1;

                plato.setVecesPedido(pedidoPlato);

                platoDAO.modificarPlato(plato);
                LOGGER.info(plato.getNombre() + " agregado a la comanda");
            
            } else {
                LOGGER.info("Plato inválido..");

            }
        } while (true);

        return montoTotal;
        
    }

    public void mostrarPlatos(){

        ArrayList<Plato> platos = platoDAO.consultarPlatos();

        if (platos != null) {
            
            for (Plato plato : platos) {
                
                LOGGER.info(String.format("""
                        ----------------------------------
                        %s        $%.2f
                        ----------------------------------
                        """, plato.getNombre(), plato.getPrecio()));
    
            }

        }else{
            LOGGER.info("No hay platos cargados! Primero ingrese un plato");
        }


    }

}
