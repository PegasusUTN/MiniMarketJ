package grupo.controladores;

import java.util.ArrayList;

import grupo.entidades.Plato;

public class InfoEstadisticaPlatos extends EsquemaOpciones{

    public void infoEstadisticaPlatos(){

        ArrayList<Plato> platosMasPedidos = masPedidos();

        int i = 1;

        for (Plato plato : platosMasPedidos) {
            
            LOGGER.info(String.format("""
                    Plato %d
                    Nombre: %s
                    Precio: $%.2f
                    Veces pedido: %d
                    """, i , plato.getNombre(), plato.getPrecio(), plato.getVecesPedido()));
            
            i++;

        }

    }

    public ArrayList<Plato> masPedidos() {

        ArrayList<Plato> platos = new ArrayList<>(platoDAO.consultarPlatos());
    
        platos.sort((p1, p2) -> Integer.compare(p2.getVecesPedido(), p1.getVecesPedido()));
    
        ArrayList<Plato> masPedidos = new ArrayList<>();

        for (int i = 0; i < Math.min(3, platos.size()); i++) {
            masPedidos.add(platos.get(i));
        }
    
        return masPedidos;
    }

}
