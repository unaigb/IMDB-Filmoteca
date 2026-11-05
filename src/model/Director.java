package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author unaig
 */
public class Director implements Serializable {

    public String nombre;
    public String fechaNac;
    public String nacionalidad;
    public String ocupacion;
    public List<String> peliculas;

    public Director(String nombre, String fechaNac, String nacionalidad, String ocupacion, String peliculas) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
        this.peliculas = new ArrayList<>();
        this.peliculas.add(peliculas);
    }

    public static Director factoryDirector(String nombre, String fechaNac, String nacionalidad, String ocupacion, String peliculas) {
        try {
            return new Director(nombre, fechaNac, nacionalidad, ocupacion, peliculas);
        } catch (Exception e) {
            return null;
        }
    }

    public static Director leerCamposDirector(String[] campos) {
        try {
            String nombre = campos[0];
            String fechaNac = campos[1];
            String nacionalidad = campos[2];
            String ocupacion = campos[3];
            String peliculas = camposPeliculas(campos[4]);
            return new Director(nombre, fechaNac, nacionalidad, ocupacion, peliculas);
        } catch (Exception e) {
            System.err.println("Error al leer los datos de actores.bin o actores.txt");
            return null;
        }
    }

    private static String camposPeliculas(String campo) {
        List<String> lineas = new ArrayList<>(Arrays.asList(campo.split("\t")));
        String pelis = "";
        for (String linea : lineas) {
            pelis += linea + " ";
        }
        return pelis;
    }

    public String asColumns(int[] numCols) {
        String theFormat = "%-"
                + numCols[0]
                + "s%-"
                + numCols[1]
                + "s%-"
                + numCols[2]
                + "s%-"
                + numCols[3]
                + "s%-"
                + numCols[4]
                + "s";
        return String.format(theFormat, this.nombre, this.fechaNac, this.nacionalidad, this.ocupacion, this.peliculas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public List<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<String> peliculas) {
        this.peliculas = peliculas;
    }
}
