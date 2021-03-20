package test.project.Spring5web.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.project.Spring5web.domain.Author;
import test.project.Spring5web.domain.Book;
import test.project.Spring5web.domain.Publisher;
import test.project.Spring5web.repositories.AuthorRepository;
import test.project.Spring5web.repositories.BookRepository;
import test.project.Spring5web.repositories.PublisherRepository;

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
    public void run(String... args) throws Exception{

        System.out.println("Started in Bootstrap");

        Publisher publisher=new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St. Petersburg");
        publisher.setState("RL");

        publisherRepository.save(publisher);

        System.out.println("publisher Count: "+publisherRepository.count());

        Author eric=new Author("Eric", "Evans");
        Book d=new Book("Domain Driven Design", "123123");

        eric.getBooks().add(d);
        d.getAuthors().add(eric);

        d.setPublisher(publisher);
        publisher.getBooks().add(d);

        authorRepository.save(eric);
        bookRepository.save(d);
        publisherRepository.save(publisher);

        Author rod=new Author("Rod", "Johnson");
        Book noEJB=new Book("J2EE Development without EJB", "1233334");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Publisher Number of Books: "+publisher.getBooks().size());
    }
}
