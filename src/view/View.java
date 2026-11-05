package view;

import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;
import controller.Controller;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unaig
 */
public class View {

    Controller c = new Controller();

    public boolean cargaArchivos() {
        String tmp;
        System.out.println("######                                                                                                                                                           \n"
                + "#     #   ##    ####  ######    #####  ######    #####    ##   #####  ####   ####     #####  ######    #####  ###### #      #  ####  #    # #        ##    ####  \n"
                + "#     #  #  #  #      #         #    # #         #    #  #  #    #   #    # #         #    # #         #    # #      #      # #    # #    # #       #  #  #      \n"
                + "######  #    #  ####  #####     #    # #####     #    # #    #   #   #    #  ####     #    # #####     #    # #####  #      # #      #    # #      #    #  ####  \n"
                + "#     # ######      # #         #    # #         #    # ######   #   #    #      #    #    # #         #####  #      #      # #      #    # #      ######      # \n"
                + "#     # #    # #    # #         #    # #         #    # #    #   #   #    # #    #    #    # #         #      #      #      # #    # #    # #      #    # #    # \n"
                + "######  #    #  ####  ######    #####  ######    #####  #    #   #    ####   ####     #####  ######    #      ###### ###### #  ####   ####  ###### #    #  ####  \n\n");
        tmp = readString("Pulsa Intro");

        //Búsqueda y carga del fichero peliculas.bin y en su defecto peliculas.txt
        if (c.buscarPeliculasBin()) {
            if (c.leerPeliculasBin()) {
                System.out.println("La carga de peliculas.bin se ha realizado correctamente");
                //return true;
            } else {
                System.out.println("La carga de peliculas.bin ha fallado, se procederá a cargar peliculas.txt");
                if (c.buscarPeliculasTxt()) {
                    if (c.leerPeliculasTxt()) {
                        System.out.println("La carga de peliculas.txt se ha realizado correctamente");
                    }
                } else {
                    System.err.println("Los datos no se han cargado correctamente");
                }
            }
        } else {
            System.out.println("La búsqueda de peliculas.bin ha fallado, se procederá a cargar peliculas.txt");
            if (c.buscarPeliculasTxt()) {
                if (c.leerPeliculasTxt()) {
                    System.out.println("La carga de peliculas.txt se ha realizado correctamente");
                }
            } else {
                System.err.println("Los datos no se han cargado correctamente");
            }
        }

        //Búsqueda y carga del fichero directores.bin y en su defecto directores.txt
        if (c.buscarDirectoresBin()) {
            if (c.leerDirectoresBin()) {
                System.out.println("La carga de directores.bin se ha realizado correctamente");
                //return true;
            } else {
                System.out.println("La carga de directores.bin ha fallado, se procederá a cargar directores.txt");
                if (c.buscarDirectoresTxt()) {
                    if (c.leerDirectoresTxt()) {
                        System.out.println("La carga de directores.txt se ha realizado correctamente");
                    }
                } else {
                    System.err.println("Los datos no se han cargado correctamente");
                }
            }
        } else {
            System.out.println("La búsqueda de directores.bin ha fallado, se procederá a cargar directores.txt");
            if (c.buscarDirectoresTxt()) {
                if (c.leerDirectoresTxt()) {
                    System.out.println("La carga de directores.txt se ha realizado correctamente");
                }
            } else {
                System.err.println("Los datos no se han cargado correctamente");
            }
        }

        //Búsqueda y carga del fichero actores.bin y en su defecto actores.txt
        if (c.buscarActoresBin()) {
            if (c.leerActoresBin()) {
                System.out.println("La carga de actores.bin se ha realizado correctamente");
                //return true;
            } else {
                System.out.println("La carga de actores.bin ha fallado, se procederá a cargar actores.txt");
                if (c.buscarActoresTxt()) {
                    if (c.leerActoresTxt()) {
                        System.out.println("La carga de actores.txt se ha realizado correctamente");
                    }
                } else {
                    System.err.println("Los datos no se han cargado correctamente");
                }
            }
        } else {
            System.out.println("La búsqueda de actores.bin ha fallado, se procederá a cargar actores.txt");
            if (c.buscarActoresTxt()) {
                if (c.leerActoresTxt()) {
                    System.out.println("La carga de actores.txt se ha realizado correctamente");
                }
            } else {
                System.err.println("Los datos no se han cargado correctamente");
            }
        }

        return false;
    }

    public void save() {
        System.out.println("Guardando datos en peliculas.bin...");
        c.guardarPeliculas();

        System.out.println("Guardando datos en directores.bin...");
        c.guardarDirectores();

        System.out.println("Guardando datos en actores.bin...");
        c.guardarActores();
    }

    public void runMenu() throws Exception {

        boolean exit = false;

        while (!exit) {
            String menu = """
                          
                          Menú Principal
                          ==============
                          1) Opción Archivos
                          2) Opción Películas
                          3) Opción Directores
                          4) Opción Actores
                          5) Opción Listados
                          s) Salir
                          
                          """;

            String option = readString(menu).toLowerCase();

            switch (option) {
                case "1":
                    this.subMenuArchivos();
                    break;
                case "2":
                    this.subMenuPeliculas();
                    break;
                case "3":
                    this.subMenuDirectores();
                    break;
                case "4":
                    this.subMenuActores();
                    break;
                case "5":
                    this.subMenuListados();
                case "s":
                    exit = yesOrNo("Desea realmente salir de la aplicación");
                    break;
                default:
                    System.out.println("ERROR. Opción Inválida.");
            }
        }
    }

    private void subMenuArchivos() {

        clear();

        boolean exit = false;

        while (!exit) {
            String menu = """
                          
                          Menú Archivos
                          =============
                          1) Exportar Directores
                          2) Exportar Películas
                          3) Atrás
                          
                          """;

            String option = readString(menu).toLowerCase();

            switch (option) {
                case "1":
                    this.exportarDirectoresCOL();
                    break;
                case "2":
                    this.exportarPeliculasHTML();
                    break;
                case "3":
                    exit = yesOrNo("Realmente quiere salir?");
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }
    }

    private void exportarDirectoresCOL() {
        c.crearCOLDirectores();
        System.out.printf("%nCreado correctamente %s%n", c.getNombreArchivoCOL());
    }

    private void exportarPeliculasHTML() {
        c.crearHTMLPeliculas();
        System.out.printf("%nCreado correctamente %s%n", c.getNombreArchivoHTML());
    }

    private void subMenuPeliculas() {

        clear();

        boolean exit = false;

        while (!exit) {
            String menu = """
                          
                          Menú Películas
                          ==============
                          1) Dar de alta una película
                          2) Dar de baja una película
                          3) Modificar datos de una película
                          4) Consultar película
                          5) Atrás
                          
                          """;

            String option = readString(menu).toLowerCase();

            switch (option) {
                case "1":
                    this.nuevaPelicula();
                    break;
                case "2":
                    this.eliminarPelicula();
                    break;
                case "3":
                    this.modificarPelicula();
                    break;
                case "4":
                    this.mostrarPelicula();
                    break;
                case "5":
                    exit = yesOrNo("Realmente quiere salir?");
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }
    }

    private void nuevaPelicula() {
        boolean tituloV = false;
        String titulo;
        do {
            titulo = readString_ne("Introduzca el título de la película: ");
            if (!c.comprobarPelicula(titulo)) {
                tituloV = true;
            } else {
                System.err.println("La película ya existe, introduzca otra");
            }
        } while (!tituloV);

        int año = readInt("Introduzca el año de estreno: ");
        int duracion = readInt("Introduzca la duración: ");
        String pais = readString_ne("Introduzca el país: ");
        String direccion = readString_ne("Introduzca los directores: ");
        String guionista = readString_ne("Introduzca el guionista: ");
        String musica = readString_ne("Introduzca el encargado de la música: ");
        String reparto = readString_ne("Introduzca el reparto: ");
        String productora = readString_ne("Introduzca la productora: ");
        String genero = readString_ne("Introduzca el género: ");
        String sinopsis = readString_ne("Introduzca la sinópsis: ");

        c.nuevaPelicula(titulo, año, duracion, pais, direccion, guionista, musica, reparto, productora, genero, sinopsis);
    }

    private void eliminarPelicula() {
        String titulo = readString_ne("Introduzca el título de la película: ");
        if (c.comprobarPelicula(titulo)) {
            if (yesOrNo("Realmente quiere eliminar esta Película?")) {
                c.eliminarPelicula(titulo);
                System.out.println("Datos eliminados correctamente");
            }
        } else {
            System.err.println("Esa película no está registrada");
        }
    }

    private void modificarPelicula() {
        clear();

        String titulo = readString_ne("Introduzca el título de la película a modificar: ");

        String menu = """
                          
                          Menú Modificar
                          ==============
                          1) Año
                          2) Duración
                          3) País
                          5) Guionista
                          6) Música
                          8) Productora
                          9) Genero
                          10) Sinopsis
                          """;

        System.out.println(menu);
        
        int indiceMod = readInt("Qué parámetro desea modificar?: ");
        
        c.modificarPelicula(titulo, indiceMod);
        System.out.println("Datos modificados correctamente");
    }

    private void mostrarPelicula() {
        List<String> tmp = new ArrayList<>();
        String titulo = readString_ne("Introduzca el título de la película: ");
        tmp = c.mostrarPelicula(titulo);
        if (c.comprobarPelicula(titulo)) {
            System.out.println("Mostrar película");
            System.out.printf("|%-55s|%-10s|%-10s|%-30s|%-40s|%-40s|%-40s|%-100s|%-100s|%-20s|%-300s|\n", 
                    "Título", "Año", "Duración", "País", "Dirección", "Guionista", "Música", "Reparto", "Productora", "Género", "Sinópsis");
            System.out.printf("-%55s-%10s-%10s-%30s-%40s-%40s-%40s-%100s-%100s-%20s-%300s-\n", "", "", "", "", "", "", "", "", "", "", "");

            for (String s : tmp) {
            System.out.println(s);
            }
            
            System.out.printf("-%55s-%10s-%10s-%30s-%40s-%40s-%40s-%100s-%100s-%20s-%300s-\n", "", "", "", "", "", "", "", "", "", "", "");
        } else {
            System.err.println("Esa película no está registrada");
        }
    }

    private void subMenuDirectores() {

        clear();

        boolean exit = false;

        while (!exit) {
            String menu = """
                          
                          Menú Directores
                          ===============
                          1) Dar de alta un Director/Directora
                          2) Dar de baja un Director/Directora
                          3) Modificar datos de un Director/Directora
                          4) Atrás
                          
                          """;

            String option = readString(menu).toLowerCase();

            switch (option) {
                case "1":
                    this.nuevoDirector();
                    break;
                case "2":
                    this.eliminarDirector();
                    break;
                case "3":
                    this.modificarDirector();
                    break;
                case "4":
                    exit = yesOrNo("Realmente quiere salir?");
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }
    }

    private void nuevoDirector() {
        boolean nombreV = false;
        String nombre;
        do {
            nombre = readString_ne("Introduzca el nombre del director: ");
            if (!c.comprobarDirector(nombre)) {
                nombreV = true;
            } else {
                System.err.println("El director ya existe, introduzca otro");
            }
        } while (!nombreV);

        String fechaNac = readString_ne("Introduzca la fecha de nacimiento: ");
        String nacionalidad = readString_ne("Introduzca la nacionalidad: ");
        String ocupacion = readString_ne("Introduzca la ocupación: ");
        String peliculas = readString_ne("Introduzca las películas: ");

        c.nuevoDirector(nombre, fechaNac, nacionalidad, ocupacion, peliculas);
    }

    private void eliminarDirector() {
        String nombre = readString_ne("Introduzca el nombre del director: ");
        if (c.comprobarDirector(nombre)) {
            if (yesOrNo("Realmente quiere eliminar este Director?")) {
                c.eliminarDirector(nombre);
                System.out.println("Datos eliminados correctamente");
            }
        } else {
            System.err.println("Ese director no está registrado");
        }
    }

    private void modificarDirector() {
        clear();

        String nombre = readString_ne("Introduzca el nombre del director a modificar: ");

        String menu = """
                          
                          Menú Modificar
                          ==============
                          1) Fecha de Nacimiento
                          2) Nacionalidad
                          3) Ocupación
                          """;

        System.out.println(menu);
        
        int indiceMod = readInt("Qué parámetro desea modificar?: ");
        
        c.modificarDirector(nombre, indiceMod);
        System.out.println("Datos modificados correctamente");
    }

    private void subMenuActores() {

        clear();

        boolean exit = false;

        while (!exit) {
            String menu = """
                          
                          Menú Actor
                          ==========
                          1) Dar de alta un Actor/Actriz
                          2) Dar de baja un Actor/Actriz
                          3) Modificar datos de un Actor/Actriz
                          4) Mostrar las películas de un Actor/Actriz
                          5) Atrás
                          
                          """;

            String option = readString(menu).toLowerCase();

            switch (option) {
                case "1":
                    this.nuevoActor();
                    break;
                case "2":
                    this.eliminarActor();
                    break;
                case "3":
                    this.modificarActor();
                    break;
                case "4":
                    this.peliculasActor();
                    break;
                case "5":
                    exit = yesOrNo("Realmente quiere salir?");
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }
    }

    private void nuevoActor() {
        boolean nombreV = false;
        String nombre;
        do {
            nombre = readString_ne("Introduzca el nombre del actor: ");
            if (!c.comprobarActor(nombre)) {
                nombreV = true;
            } else {
                System.err.println("El actor ya existe, introduzca otro");
            }
        } while (!nombreV);

        String fechaNac = readString_ne("Introduzca la fecha de nacimiento: ");
        String nacionalidad = readString_ne("Introduzca la nacionalidad: ");
        int debut = readInt("Introduzca el año de debut: ");
        String peliculas = readString_ne("Introduzca las películas: ");

        c.nuevoActor(nombre, fechaNac, nacionalidad, debut, peliculas);
    }

    private void eliminarActor() {
        String nombre = readString_ne("Introduzca el nombre del actor: ");
        if (c.comprobarActor(nombre)) {
            if (yesOrNo("Realmente quiere eliminar este Actor?")) {
                c.eliminarActor(nombre);
                System.out.println("Datos eliminados correctamente");
            }
        } else {
            System.err.println("Ese actor no está registrado");
        }
    }

    private void modificarActor() {
        clear();

        String nombre = readString_ne("Introduzca el nombre del actor a modificar: ");

        String menu = """
                          
                          Menú Modificar
                          ==============
                          1) Fecha de Nacimiento
                          2) Nacionalidad
                          3) Año debut
                          """;

        System.out.println(menu);
        
        int indiceMod = readInt("Qué parámetro desea modificar?: ");
        
        c.modificarActor(nombre, indiceMod);
        System.out.println("Datos modificados correctamente");
    }

    private void peliculasActor() {
        List<String> tmp = new ArrayList<>();
        tmp = c.listadoPeliculas();
        String nombre = readString_ne("Introduzca el nombre del actor: ");
        if (c.comprobarActor(nombre)) {
            System.out.println("Listado de Películas");
            System.out.printf("|%-55s|%-10s|%-10s|%-30s|%-20s|\n", "Título", "Año", "Duración", "País", "Género");
            System.out.printf("-%55s-%10s-%10s-%30s-%20s-\n", "", "", "", "", "");

            for (String s : tmp) {
                System.out.println(s);
            }
            System.out.printf("-%55s-%10s-%10s-%30s-%20s-\n", "", "", "", "", "");
        } else {
            System.err.println("Ese actor no está registrado");
        }
    }

    private void subMenuListados() {

        clear();

        boolean exit = false;

        while (!exit) {
            String menu = """
                          
                          Menú Listados
                          =============
                          1) Mostrar Películas
                          2) Mostrar Directores
                          3) Mostrar Actores
                          4) Atrás
                          
                          """;

            String option = readString(menu).toLowerCase();

            switch (option) {
                case "1":
                    this.listadoPeliculas();
                    break;
                case "2":
                    this.listadoDirectores();
                    break;
                case "3":
                    this.listadoActores();
                    break;
                case "4":
                    exit = yesOrNo("Realmente quiere salir?");
                    break;
                default:
                    System.out.println("Opción Inválida.");
            }
        }
    }

    private void listadoPeliculas() {
        List<String> tmp = new ArrayList<>();
        tmp = c.listadoPeliculas();
        System.out.println("Listado de Películas");
        System.out.printf("|%-55s|%-10s|%-10s|%-30s|%-20s|\n", "Título", "Año", "Duración", "País", "Género");
        System.out.printf("-%55s-%10s-%10s-%30s-%20s-\n", "", "", "", "", "");

        for (String s : tmp) {
            System.out.println(s);
        }
        System.out.printf("-%55s-%10s-%10s-%30s-%20s-\n", "", "", "", "", "");
    }

    private void listadoDirectores() {
        List<String> tmp = new ArrayList<>();
        tmp = c.listadoDirectores();
        System.out.println("Listado de Directores");
        System.out.printf("|%-30s|%-15s|%-20s|%-75s|%-75s|\n", "Nombre", "Fecha Nac.", "Nacionalidad", "Ocupación", "Películas");
        System.out.printf("-%30s-%15s-%20s-%75s-%75s-\n", "", "", "", "", "");

        for (String s : tmp) {
            System.out.println(s);
        }
        System.out.printf("-%30s-%15s-%20s-%75s-%75s-\n", "", "", "", "", "");
    }

    private void listadoActores() {
        List<String> tmp = new ArrayList<>();
        tmp = c.listadoActores();
        System.out.println("Listado de Actores");
        System.out.printf("|%-30s|%-15s|%-20s|%-12s|%-150s|\n", "Nombre", "Fecha Nac.", "Nacionalidad", "Año Debut", "Películas");
        System.out.printf("-%30s-%15s-%20s-%12s-%150s-\n", "", "", "", "", "");

        for (String s : tmp) {
            System.out.println(s);
        }
        System.out.printf("-%30s-%15s-%20s-%12s-%150s-\n", "", "", "", "", "");
    }
}
