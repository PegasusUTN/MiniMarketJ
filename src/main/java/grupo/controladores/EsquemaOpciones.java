package grupo.controladores;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grupo.persistencia.ComandaDAO;
import grupo.persistencia.PlatoDAO;
import grupo.persistencia.ProductoDAO;
import grupo.persistencia.ProveedorDAO;
import grupo.persistencia.VentaDAO;

public abstract class EsquemaOpciones {

    protected Logger LOGGER = LogManager.getLogger();
    protected Scanner sc = new Scanner(System.in);
    protected ProductoDAO productoDAO = new ProductoDAO();
    protected VentaDAO ventaDAO = new VentaDAO();
    protected ProveedorDAO proveedorDAO = new ProveedorDAO();
    protected PlatoDAO platoDAO = new PlatoDAO();
    protected ComandaDAO comandaDAO = new ComandaDAO();

}
