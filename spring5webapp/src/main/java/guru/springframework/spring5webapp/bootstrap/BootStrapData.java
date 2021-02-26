package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepsitory;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepsitory authorRepsitory;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepsitory authorRepsitory, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepsitory = authorRepsitory;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootsrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("St peterburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepsitory.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEBJ = new Book("J2EE development without EJB", "1231231");
        rod.getBooks().add(noEBJ);
        noEBJ.getAuthors().add(rod);

        noEBJ.setPublisher(publisher);
        publisher.getBooks().add(noEBJ);

        authorRepsitory.save(rod);
        bookRepository.save(noEBJ);
        publisherRepository.save(publisher);


        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepsitory.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());


    }
}
