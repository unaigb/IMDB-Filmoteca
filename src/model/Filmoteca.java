package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author unaig
 */
public class Filmoteca implements Serializable {

    public final String peliculasBin = "binarios" + File.separator + "peliculas.bin";
    public final String directoresBin = "binarios" + File.separator + "directores.bin";
    public final String actoresBin = "binarios" + File.separator + "actores.bin";
    public final String peliculasTxt = "datos" + File.separator + "peliculas.txt";
    public final String directoresTxt = "datos" + File.separator + "directores.txt";
    public final String actoresTxt = "datos" + File.separator + "actores.txt";
    public final String nombreCarpeta = "IMDB21";
    public final String nombreArchivoHTML = "peliculas.html";
    public final String nombreArchivoCOL = "directores.col";
    public List<Pelicula> pelicula = new ArrayList<>();
    public List<Director> director = new ArrayList<>();
    public List<Actor> actor = new ArrayList<>();
}
