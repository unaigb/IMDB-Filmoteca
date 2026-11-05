package controller;

import java.util.List;
import model.Model;

/**
 *
 * @author unaig
 */
public class Controller {

    Model m = new Model();

    public boolean buscarPeliculasBin() {
        return m.buscarPeliculasBin();
    }

    public boolean leerPeliculasBin() {
        return m.leerPeliculasBin();
    }

    public boolean buscarPeliculasTxt() {
        return m.buscarPeliculasTxt();
    }

    public boolean leerPeliculasTxt() {
        return m.leerPeliculasTxt();
    }

    public boolean buscarDirectoresBin() {
        return m.buscarDirectoresBin();
    }

    public boolean leerDirectoresBin() {
        return m.leerDirectoresBin();
    }

    public boolean buscarDirectoresTxt() {
        return m.buscarDirectoresTxt();
    }

    public boolean leerDirectoresTxt() {
        return m.leerDirectoresTxt();
    }

    public boolean buscarActoresBin() {
        return m.buscarActoresBin();
    }

    public boolean leerActoresBin() {
        return m.leerActoresBin();
    }

    public boolean buscarActoresTxt() {
        return m.buscarActoresTxt();
    }

    public boolean leerActoresTxt() {
        return m.leerActoresTxt();
    }

    public void guardarPeliculas() {
        m.guardarPeliculas();
    }

    public void guardarDirectores() {
        m.guardarDirectores();
    }

    public void guardarActores() {
        m.guardarActores();
    }

    public void crearHTMLPeliculas() {
        m.crearHTMLPeliculas();
    }

    public String getNombreArchivoHTML() {
        return m.getNombreArchivoHTML();
    }

    public void crearCOLDirectores() {
        m.crearCOLDirectores();
    }

    public String getNombreArchivoCOL() {
        return m.getNombreArchivoCOL();
    }

    public List<String> listadoPeliculas() {
        return m.listadoPeliculas();
    }

    public List<String> listadoDirectores() {
        return m.listadoDirectores();
    }

    public List<String> listadoActores() {
        return m.listadoActores();
    }

    public void nuevoDirector(String nombre,String fechaNac,String nacionalidad,String ocupacion,String peliculas) {
        m.nuevoDirector(nombre,fechaNac,nacionalidad,ocupacion,peliculas);
    }

    public boolean comprobarDirector(String nombre) {
        return m.comprobarDirector(nombre);
    }

    public void modificarDirector(String nombre, int indiceMod) {
        m.modificarDirector(nombre, indiceMod);
    }

    public void eliminarDirector(String nombre) {
        m.eliminarDirector(nombre);
    }

    public boolean comprobarActor(String nombre) {
        return m.comprobarActor(nombre);
    }

    public void nuevoActor(String nombre, String fechaNac, String nacionalidad, int debut, String peliculas) {
        m.nuevoActor(nombre,fechaNac,nacionalidad,debut,peliculas);
    }

    public void eliminarActor(String nombre) {
        m.eliminarActor(nombre);
    }

    public void modificarActor(String nombre, int indiceMod) {
        m.modificarActor(nombre, indiceMod);
    }

    public boolean comprobarPelicula(String titulo) {
        return m.comprobarPelicula(titulo);
    }
    
    public void nuevaPelicula(String titulo, int año, int duracion, String pais, String direccion, String guionista, String musica, String reparto, String productora, String genero, String sinopsis) {
        m.nuevaPelicula(titulo, año, duracion, pais, direccion, guionista, musica, reparto, productora, genero, sinopsis);
    }

    public void eliminarPelicula(String titulo) {
        m.eliminarPelicula(titulo);
    }

    public void modificarPelicula(String titulo, int indiceMod) {
        m.modificarPelicula(titulo, indiceMod);
    }

    public List<String> mostrarPelicula(String titulo) {
        return m.mostrarPelicula(titulo);
    }
}
