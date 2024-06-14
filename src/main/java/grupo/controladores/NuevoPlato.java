package grupo.controladores;

import grupo.entidades.Plato;

public class NuevoPlato extends EsquemaOpciones{

    public void nuevoPlato(){

        Plato plato = crearPlato();

        platoDAO.insertarPlato(plato);

    }

    public Plato crearPlato(){

        Plato plato = new Plato();

        LOGGER.info("Ingrese el nombre del plato:");
        plato.setNombre(sc.nextLine());

        LOGGER.info("Ingresar el precio del plato:");
        plato.setPrecio(Float.parseFloat(sc.nextLine()));

        plato.setVecesPedido(0);

        return plato;

    }

}
