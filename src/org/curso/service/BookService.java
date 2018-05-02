package org.curso.service;

import org.curso.domain.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/gestion")
public class BookService {

    static List<Book> BOOKS;
    static {
            BOOKS = new ArrayList<>(Arrays.asList(
                    new Book("book1", "book1", 10),
                    new Book("book2", "book2", 20),
                    new Book("book3", "book3", 30)
            ));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML) -> para generar un XML
    public List<Book> getAllBooks(){
        return BOOKS;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String altaLibro(@FormParam("titulo") String titulo, @FormParam("descripcion") String descripcion, @FormParam("precio") double precio){
        Book book = new Book(titulo, descripcion, precio);
        System.out.println(book);
        BOOKS.add(book);
        return "Book created";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookByID(@PathParam("id") int id){
        for (Book l : BOOKS){
            if(l.getId() == id){
                return l;
            }
        }
        return null;
    }

    @GET
    @Path("search/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getByQuery(@PathParam("query") String consulta){
        List<Book> libros = new ArrayList<>();
        for(Book l : BOOKS){
            if(l.getDescipcion().contains(consulta)){
                libros.add(l);
            }
        }
        return libros;
    }
}
