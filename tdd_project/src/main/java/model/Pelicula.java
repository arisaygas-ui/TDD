package model;

import exception.*;


public class Pelicula {
    private String nombre;
    private String autor;
    private int duracion;
    private String horario;
    private int sala;
    private String descripcion;

    //constructor con 6 datos completo
    public Pelicula(String nombre, String autor, int duracion, String horario, int sala, String descripcion){

        this.nombre = nombre;
        this.autor = autor;
        this.duracion = duracion;
        this.horario = horario;
        this.sala = sala;
        this.descripcion = descripcion;
    }
    public static Pelicula newPelicula(String nombre, String autor, int duracion, String horario, int sala, String descripcion){
        if(nombre == null || nombre.isBlank()){
            throw new nombreNoValidoException("El nombre de la pelicula es obligatorio");
        }

        if(autor == null || autor.isBlank()){
            throw new autorObligatorioException("El autor debe ser obligatorio");
        }

        if(duracion <= 0){
            throw new duracionNegativaException("La duración debe ser mayor a 0");
        }

        if(horario == null || horario.isBlank()){
            throw new horarioObligatorioException("El horario es obligatorio");
        }

        if(sala < 1){
            throw new salaMayorAUnoException("La sala debe ser mayor a 1");
        }
        return new Pelicula(nombre,autor,duracion,horario,sala, descripcion);
    }

    public String getNombre() { return nombre; }
    public String getAutor() { return autor; }
    public int getDuracion() { return duracion; }
    public String getHorario() { return horario; }
    public int getSala() { return sala; }
    public String getDescripcion() { return descripcion; }
}
