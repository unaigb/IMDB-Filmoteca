package model;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.Rutas.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author unaig
 */
public class Model {

    private Filmoteca fi = new Filmoteca();
    private Pelicula pel;

    public boolean buscarPeliculasBin() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.peliculasBin);
        return f.exists();
    }

    public boolean leerPeliculasBin() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.peliculasBin);
        try {
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            fi.pelicula = (List<Pelicula>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error al leer los datos de peliculas.bin");
            return false;
        }
        return true;
    }

    public boolean buscarPeliculasTxt() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.peliculasTxt);
        return f.exists();
    }

    public boolean leerPeliculasTxt() {
        fi.pelicula.clear();

        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.peliculasTxt);
        try {
            List<String> lineas = Files.readAllLines(f.toPath());
            for (String linea : lineas) {
                String[] campos = linea.split("#");
                Pelicula p = Pelicula.leerCamposPelicula(campos);
                if (p != null) {
                    fi.pelicula.add(p);
                } else {
                    System.err.println("Error al añadir los datos de películas a la lista");
                    return false;
                }
            }
            return true;
        } catch (IOException ex) {
            System.err.println("Error al leer el fichero peliculas.txt");
            return false;
        }
    }

    public boolean buscarDirectoresBin() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.directoresBin);
        return f.exists();
    }

    public boolean leerDirectoresBin() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.directoresBin);
        try {
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            fi.director = (List<Director>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error al leer los datos de director.bin");
            return false;
        }
        return true;
    }

    public boolean buscarDirectoresTxt() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.directoresTxt);
        return f.exists();
    }

    public boolean leerDirectoresTxt() {
        fi.director.clear();

        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.directoresTxt);
        try {
            List<String> lineas = Files.readAllLines(f.toPath());
            for (String linea : lineas) {
                String[] campos = linea.split("#");
                Director d = Director.leerCamposDirector(campos);
                if (d != null) {
                    fi.director.add(d);
                } else {
                    System.err.println("Error al añadir los datos de directores a la lista");
                    return false;
                }
            }
            return true;
        } catch (IOException ex) {
            System.err.println("Error al leer el fichero directores.txt");
            return false;
        }
    }

    public boolean buscarActoresBin() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.actoresBin);
        return f.exists();
    }

    public boolean leerActoresBin() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.actoresBin);
        try {
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            fi.actor = (List<Actor>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error al leer los datos de actores.bin");
            return false;
        }
        return true;
    }

    public boolean buscarActoresTxt() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.actoresTxt);
        return f.exists();
    }

    public boolean leerActoresTxt() {
        fi.actor.clear();

        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.actoresTxt);
        try {
            List<String> lineas = Files.readAllLines(f.toPath());
            for (String linea : lineas) {
                String[] campos = linea.split("#");
                Actor a = Actor.leerCamposActor(campos);
                if (a != null) {
                    fi.actor.add(a);
                } else {
                    System.err.println("Error al añadir los datos de actores a la lista");
                    return false;
                }
            }
            return true;
        } catch (IOException ex) {
            System.err.println("Error al leer el fichero actores.txt");
            return false;
        }
    }

    public void guardarPeliculas() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.peliculasBin);

        try {
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(fi.pelicula);
            oos.close();
        } catch (IOException ex) {
            System.err.println("Error al guardar el archivo peliculas.bin");
            System.err.println(ex.toString());
        }
    }

    public void guardarDirectores() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.directoresBin);

        try {
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(fi.director);
            oos.close();
        } catch (IOException ex) {
            System.err.println("Error al guardar el archivo directores.bin");
            System.err.println(ex.toString());
        }
    }

    public void guardarActores() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.actoresBin);

        try {
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(fi.actor);
            oos.close();
        } catch (IOException ex) {
            System.err.println("Error al guardar el archivo actores.bin");
            System.err.println(ex.toString());
        }
    }

    public String getNombreArchivoHTML() {
        return this.fi.nombreArchivoHTML;
    }

    public void crearHTMLPeliculas() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.nombreArchivoHTML);
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.printf("<!DOCTYPE html>%n"
                    + "<HTML>%n"
                    + "<HEAD>%n"
                    + "<meta charset=\"UTF-8\">%n"
                    + "<H1>Listado de peliculas</H1>%n"
                    + "</HEAD>%n"
                    + "</BODY>%n");
            pw.printf("<TABLE BORDER=1>%n");

            pw.printf("<TR>"
                    + "<TH>Título</TH>"
                    + "<TH>Año</TH>"
                    + "<TH>Duración</TH>"
                    + "<TH>País</TH>"
                    + "<TH>Dirección</TH>"
                    + "<TH>Guionista</TH>"
                    + "<TH>Música</TH>"
                    + "<TH>Reparto</TH>"
                    + "<TH>Productora</TH>"
                    + "<TH>Género</TH>"
                    + "<TH>Sinópsis</TH>"
                    + "</TR>");

            for (Pelicula pel : fi.pelicula) {
                pw.printf("%s%n", pel.comoFilaDeUnaTablaEnHTML());
            }
            pw.printf("</TABLE>%n</BODY>%n</HTML>%n");
            pw.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("ERROR: no se ha creado %s%n", f.toString());
            return;
        }
        System.out.printf("%nSe ha creado una tabla con %d registros%n", this.fi.pelicula.size());
        System.out.printf("Ruta del archivo: " + f.toString());
    }

    public String getNombreArchivoCOL() {
        return this.fi.nombreArchivoCOL;
    }

    public void crearCOLDirectores() {
        File f = fileToFileInFolderOnDesktop(fi.nombreCarpeta, fi.nombreArchivoCOL);

        int[] numCols = {30, 15, 20, 75, 150};

        List<String> filas = new ArrayList<>();
        for (Director dir : fi.director) {
            String fila = dir.asColumns(numCols);
            filas.add(fila);
        }
        try {
            Files.write(f.toPath(), filas, Charset.defaultCharset(), StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.err.println("ERROR: no se pudo crear el archivo exportado");
            System.err.println(ex.getLocalizedMessage());
        }
    }

    public List<String> listadoPeliculas() {
        List<String> orden = new ArrayList<>();
        String s;
        Comparator<Pelicula> comp = Comparator.comparing(Pelicula::getTitulo);
        fi.pelicula.sort(comp);
        for (int i = 1; i < fi.pelicula.size(); i++) {
            s = new String();
            s = String.format("|%-55s|%-10s|%-10s|%-30s|%-20s|", fi.pelicula.get(i).getTitulo(), fi.pelicula.get(i).getAño(),
                    fi.pelicula.get(i).getDuracion(), fi.pelicula.get(i).getPais(), fi.pelicula.get(i).getGenero());
            orden.add(s);
        }
        return orden;
    }

    public List<String> listadoDirectores() {
        List<String> orden = new ArrayList<>();
        String s;
        Comparator<Director> comp = Comparator.comparing(Director::getNacionalidad).thenComparing(Director::getFechaNac);
        fi.director.sort(comp);
        for (int i = 0; i < fi.director.size(); i++) {
            s = new String();
            s = String.format("|%-30s|%-15s|%-20s|%-75s|%-75s|", fi.director.get(i).getNombre(), fi.director.get(i).getFechaNac(),
                    fi.director.get(i).getNacionalidad(), fi.director.get(i).getOcupacion(), fi.director.get(i).getPeliculas());
            orden.add(s);
        }
        return orden;
    }

    public List<String> listadoActores() {
        List<String> orden = new ArrayList<>();
        String s;
        Comparator<Actor> comp = Comparator.comparing(Actor::getDebut).thenComparing(Actor::getNombre);
        fi.actor.sort(comp);
        for (int i = 0; i < fi.actor.size(); i++) {
            s = new String();
            s = String.format("|%-30s|%-15s|%-20s|%-12s|%-150s|", fi.actor.get(i).getNombre(), fi.actor.get(i).getFechaNac(),
                    fi.actor.get(i).getNacionalidad(), fi.actor.get(i).getDebut(), fi.actor.get(i).getPeliculas());
            orden.add(s);
        }
        return orden;
    }

    public void nuevoDirector(String nombre, String fechaNac, String nacionalidad, String ocupacion, String peliculas) {
        Director d = Director.factoryDirector(nombre, fechaNac, nacionalidad, ocupacion, peliculas);
        if (d != null) {
            fi.director.add(d);
        } else {
            System.err.println("No se ha añadido el director");
        }
    }

    public boolean comprobarDirector(String nombre) {
        for (Director director : fi.director) {
            if (director.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void modificarDirector(String nombre, int indiceMod) {
        for (Director dirMod : fi.director) {
            if (dirMod.getNombre().equalsIgnoreCase(nombre)) {
                switch (indiceMod) {
                    case 1 ->
                        dirMod.setFechaNac(readString("Introducir la fecha de nacimiento: "));
                    case 2 ->
                        dirMod.setNacionalidad(readString("Introducir la nacionalidad: "));
                    case 3 ->
                        dirMod.setOcupacion(readString("Introducir la ocupación: "));
                    default ->
                        System.out.println("Opción inválida");
                }
            }
        }
    }

    public void eliminarDirector(String nombre) {
        ListIterator<Director> iter = fi.director.listIterator();
        while (iter.hasNext()) {
            if (iter.next().getNombre().equalsIgnoreCase(nombre)) {
                iter.remove();
            }
        }
    }

    public boolean comprobarActor(String nombre) {
        for (Actor actor : fi.actor) {
            if (actor.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void nuevoActor(String nombre, String fechaNac, String nacionalidad, int debut, String peliculas) {
        Actor a = Actor.factoryActor(nombre, fechaNac, nacionalidad, debut, peliculas);
        if (a != null) {
            fi.actor.add(a);
        } else {
            System.err.println("No se ha añadido el director");
        }
    }

    public void eliminarActor(String nombre) {
        ListIterator<Actor> iter = fi.actor.listIterator();
        while (iter.hasNext()) {
            if (iter.next().getNombre().equalsIgnoreCase(nombre)) {
                iter.remove();
            }
        }
    }

    public void modificarActor(String nombre, int indiceMod) {
        for (Actor acMod : fi.actor) {
            if (acMod.getNombre().equalsIgnoreCase(nombre)) {
                switch (indiceMod) {
                    case 1 ->
                        acMod.setFechaNac(readString("Introducir la fecha de nacimiento: "));
                    case 2 ->
                        acMod.setNacionalidad(readString("Introducir la nacionalidad: "));
                    case 3 ->
                        acMod.setDebut(readInt("Introducir el año de debut: "));
                    default ->
                        System.out.println("Opción inválida");
                }
            }
        }
    }

    public boolean comprobarPelicula(String titulo) {
        for (Pelicula pelicula : fi.pelicula) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public void nuevaPelicula(String titulo, int año, int duracion, String pais, String direccion, String guionista, String musica, String reparto, String productora, String genero, String sinopsis) {
        boolean flag;

        Pelicula p = Pelicula.factoryPelicula(titulo, año, duracion, pais, direccion, guionista, musica, reparto, productora, genero, sinopsis);
        if (p != null) {
            fi.pelicula.add(p);
        }

        for (Pelicula peli : fi.pelicula) {
            flag = false;
            for (String s : peli.direccion) {
                for (Director director : fi.director) {
                    if (director.getNombre().equalsIgnoreCase(s)) {
                        director.peliculas.add(peli.titulo);
                    }
                }
            }
        }

        for (Pelicula peli : fi.pelicula) {
            flag = false;
            for (String s : peli.reparto) {
                for (Actor actor : fi.actor) {
                    if (actor.getNombre().equalsIgnoreCase(s)) {
                        actor.peliculas.add(peli.titulo);
                    }
                }
            }
        }
    }

    public void eliminarPelicula(String titulo) {
        for (Director dir : fi.director) {
            for (String s : dir.peliculas) {
                for (Pelicula peli : fi.pelicula) {
                    if (peli.getTitulo().equalsIgnoreCase(s)) {
                        peli.direccion.remove(peli.titulo);
                    }
                }
            }
        }

        for (Actor ac : fi.actor) {
            for (String s : ac.peliculas) {
                for (Pelicula peli : fi.pelicula) {
                    if (peli.getTitulo().equalsIgnoreCase(s)) {
                        peli.reparto.remove(peli.titulo);
                    }
                }
            }
        }

        ListIterator<Pelicula> iter = fi.pelicula.listIterator();
        while (iter.hasNext()) {
            if (iter.next().getTitulo().equalsIgnoreCase(titulo)) {
                iter.remove();
            }
        }
    }

    public void modificarPelicula(String titulo, int indiceMod) {
        for (Pelicula peliMod : fi.pelicula) {
            if (peliMod.getTitulo().equalsIgnoreCase(titulo)) {
                switch (indiceMod) {
                    case 1 ->
                        peliMod.setAño(readInt("Introducir el año: "));
                    case 2 ->
                        peliMod.setDuracion(readInt("Introducir la duración de la película: "));
                    case 3 ->
                        peliMod.setPais(readString("Introducir el país: "));
                    case 5 ->
                        peliMod.setGuionista(readString("Introducir el guionista: "));
                    case 6 ->
                        peliMod.setMusica(readString("Introducir el encargado de la música: "));
                    case 8 ->
                        peliMod.setProductora(readString("Introducir la productora: "));
                    case 9 ->
                        peliMod.setGenero(readString("Introducir el género: "));
                    case 10 ->
                        peliMod.setSinopsis(readString("Introducir la Sinópsis: "));
                    default ->
                        System.out.println("Opción inválida");
                }
            }
        }
    }

    public List<String> mostrarPelicula(String titulo) {
        List<String> peli = new ArrayList<>();
        String s;

        for (Pelicula peliMos : fi.pelicula) {
            if (peliMos.getTitulo().equalsIgnoreCase(titulo)) {
                s = new String();
                s = String.format("|%-55s|%-10d|%-10d|%-30s|%-40s|%-40s|%-40s|%-100s|%-100s|%-20s|%-300s|", peliMos.titulo, peliMos.año,
                        peliMos.duracion, peliMos.pais, peliMos.direccion, peliMos.guionista, peliMos.musica, 
                        peliMos.reparto, peliMos.productora, peliMos.genero, peliMos.sinopsis);
                peli.add(s);
            }
        }
        return peli;
    }
}
