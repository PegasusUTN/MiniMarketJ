package grupo.main;

import java.util.Locale;

import grupo.persistencia.CrearTablasDAO;

public class Main {

    private static final CrearTablasDAO crearTablasDAO = new CrearTablasDAO();

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        crearTablasDAO.crearTablas();

        MenuPrincipal menu = new MenuPrincipal();
    
        menu.menuPrincipal();

    }

}