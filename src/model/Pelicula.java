package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author unaig
 */
public class Pelicula implements Serializable {

    public String titulo;
    public int año;
    public int duracion;
    public String pais;
    public List<String> direccion;
    public String guionista;
    public String musica;
    public List<String> reparto;
    public String productora;
    public String genero;
    public String sinopsis;

    public Pelicula(String titulo, int año, int duracion, String pais, String direccion, String guionista, String musica, String reparto, String productora, String genero, String sinopsis) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = new ArrayList<>();
        this.direccion.add(direccion);
        this.guionista = guionista;
        this.musica = musica;
        this.reparto = new ArrayList<>();
        this.reparto.add(reparto);
        this.productora = productora;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public static Pelicula factoryPelicula(String titulo, int año, int duracion, String pais, String direccion, String guionista, String musica, String reparto, String productora, String genero, String sinopsis) {
        try {
            return new Pelicula(titulo, año, duracion, pais, direccion, guionista, musica, reparto, productora, genero, sinopsis);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Pelicula leerCamposPelicula(String[] campos) {
        try {
            String titulo = campos[0];
            int año = Integer.parseInt(campos[1]);
            int duracion = Integer.parseInt(campos[2]);
            String pais = campos[3];
            String direccion = camposDireccion(campos[4]);
            String guionista = campos[5];
            String musica = campos[6];
            String reparto = camposReparto(campos[7]);
            String productora = campos[8];
            String genero = campos[9];
            String sinopsis = campos[10];
            return new Pelicula(titulo, año, duracion, pais, direccion, guionista, musica, reparto, productora, genero, sinopsis);
        } catch (Exception e) {
            System.err.println("Error al leer los datos de peliculas.bin o peliculas.txt");
            return null;
        }
    }

    private static String camposDireccion(String campo) {
        List<String> lineas = new ArrayList<>(Arrays.asList(campo.split("\t")));
        String direcciones = "";
        for (String linea : lineas) {
            direcciones += linea + " ";
        }
        return direcciones;
    }

    private static String camposReparto(String campo) {
        List<String> lineas = new ArrayList<>(Arrays.asList(campo.split("\t")));
        String cast = "";
        for (String linea : lineas) {
            cast += linea + " ";
        }
        return cast;
    }

    public String comoFilaDeUnaTablaEnHTML() {
        String resultado;
        resultado = String.format("<TR>"
                + "<TD>%s</TD>" // Título
                + "<TD>%d</TD>" // Año
                + "<TD>%d</TD>" // Duración
                + "<TD>%s</TD>" // País
                + "<TD>%s</TD>" // Dirección
                + "<TD>%s</TD>" // Guionista
                + "<TD>%s</TD>" // Música
                + "<TD>%s</TD>" // Reparto
                + "<TD>%s</TD>" // Productora
                + "<TD>%s</TD>" // Género
                + "<TD>%s</TD>" // Sinópsis
                + "</TR>",
                this.titulo, this.año, this.duracion, this.pais, this.direccion, this.guionista, this.musica, this.reparto, this.productora, this.genero, this.sinopsis);
        return resultado;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<String> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<String> direccion) {
        this.direccion = direccion;
    }

    public String getGuionista() {
        return guionista;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public List<String> getReparto() {
        return reparto;
    }

    public void setReparto(List<String> reparto) {
        this.reparto = reparto;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
