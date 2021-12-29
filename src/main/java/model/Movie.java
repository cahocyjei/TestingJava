package model;

import java.util.Objects;

public class Movie {

    private  Integer id;
    private String titulo;
    private String pais;
    private String fecha;
    private Genre genre;
    private double duracion;
    private int capitulo;



    public Movie(Integer id, String titulo, String pais, String fecha, Genre genre, double duracion, int capitulo) {
        this.id = id;
        this.titulo = titulo;
        this.pais = pais;
        this.fecha = fecha;
        this.genre = genre;
        this.duracion = duracion;
        this.capitulo = capitulo;
    }

    public Movie(String titulo,String pais,String fecha,Genre genre,double duracion,int capitulo) {
        this(null,titulo,pais,fecha,genre,duracion,capitulo);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", pais='" + pais + '\'' +
                ", fecha='" + fecha + '\'' +
                ", genre=" + genre +
                ", duracion=" + duracion +
                ", capitulo=" + capitulo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.duracion, duracion) == 0 && capitulo == movie.capitulo && Objects.equals(id, movie.id) && Objects.equals(titulo, movie.titulo) && Objects.equals(pais, movie.pais) && Objects.equals(fecha, movie.fecha) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, pais, fecha, genre, duracion, capitulo);
    }
}
