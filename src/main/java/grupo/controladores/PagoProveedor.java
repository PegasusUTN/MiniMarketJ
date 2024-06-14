package grupo.controladores;

import java.util.ArrayList;

import grupo.entidades.Proveedor;

public class PagoProveedor extends EsquemaOpciones{

    // METODO A INVOCAR EN EL MAIN
    public void pagoProveedor(){
        Proveedor proveedor = this.visualizarYSeleccionarProveedor();
        float montoASaldar = this.ingresarMontoASaldar();
        this.actualizarDeuda(proveedor, montoASaldar);
    }
    
    public void actualizarDeuda(Proveedor proveedor, float montoASaldar) {
        float deudaFinal = proveedor.getDeuda() - montoASaldar;
        proveedor.setDeuda(deudaFinal);
        this.proveedorDAO.modificarProveedor(proveedor);
    }

    // Con este metodo la idea es que al seleccionar la opcion 3 del main
    // pueda seleccionar un proveedor de los que ya existen
    public Proveedor visualizarYSeleccionarProveedor() {

        ArrayList<Proveedor> proveedores = this.proveedorDAO.buscarProveedores();
        int opcionSeleccionada;

        LOGGER.info("Ingrese el numero que corresponde al proveedor: ");
        for (int i = 0; i < proveedores.size(); i++) {
            LOGGER.info(i + 1 + ". " + proveedores.get(i).getNombreComercial() + "  $" + proveedores.get(i).getDeuda());
        }
        try {
            opcionSeleccionada = this.sc.nextInt();
            //Para limpiar el buffer
            this.sc.nextLine();

            if (opcionSeleccionada <= proveedores.size()) {
                return proveedores.get(opcionSeleccionada - 1);
            } else {
                LOGGER.info("Seleccion inválida, pruebe otra vez.");
                return this.visualizarYSeleccionarProveedor();
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            LOGGER.info("Algo salio mal");
            //Para ingresar nuevamente un valor valido
            return this.visualizarYSeleccionarProveedor();
        }
    }

    public float ingresarMontoASaldar() {

        float montoASaldar;
        LOGGER.info("Ingrese el monto a pagar a el proveedor");
        try {
            montoASaldar = this.sc.nextFloat();

            //Para limpiar el buffer
            this.sc.nextLine();
            return montoASaldar;
        } catch (Exception e) {
            e.getMessage();
            // Para volver a ingresar un numero valido
            return this.ingresarMontoASaldar();
        }
    }

}
