package org.curso.domain;

public class Book {
    private int id = ++cont;
    private String titulo;
    private String descipcion;
    private double precio;

    static int cont;

    public Book(String titulo, String descipcion, double precio) {
        this.titulo = titulo;
        this.descipcion = descipcion;
        this.precio = precio;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descipcion='" + descipcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
