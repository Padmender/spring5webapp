package guru.springframework.spring5webapp.bootStrap;

import guru.springframework.spring5webapp.entity.Author;
import guru.springframework.spring5webapp.entity.Book;
import guru.springframework.spring5webapp.entity.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;

import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub=new Publisher("Apart 310,building 216","Dubai","Dubai",2000l);
        publisherRepository.save(pub);

        System.out.println("no. of publisher:"+publisherRepository.count());


        Author aut=new Author("Padmender","singh");
        Book book=new Book("my first book", "1123456");
        aut.getBooks().add(book);
        book.getAuthors().add(aut);

        authorRepository.save(aut);
        bookRepository.save(book);

        Author aut2=new Author("Sachin","Reevan");
        Book book2=new Book("my Second book", "98765");
        aut2.getBooks().add(book);
        book2.getAuthors().add(aut);

        authorRepository.save(aut2);
        bookRepository.save(book2);

        System.out.println("No. of books:"+bookRepository.count());



    }
}
