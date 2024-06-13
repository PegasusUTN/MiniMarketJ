package grupo.controladores;

public class IngresoMercaderiaControlador {

    public void ingresoMercaderia(){

        LOGGER.info("Ingrese el nombre del proveedor:");
        String nombreProveedor = sc.nextLine();

        Proveedor proveedor = proveedorDAO.buscarProveedor(nombreProveedor);

        if(proveedor == null){

            LOGGER.info("El proveedor " + nombreProveedor + " no existe, ingrese los datos del nuevo");

            proveedor.setNombreComercial(nombreProveedor);
            

            proveedor.setCuit();

        }


    }

}
