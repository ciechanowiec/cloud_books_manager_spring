package eu.ciechanowiec.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Herman Ciechanowiec
 */
@Service
@AllArgsConstructor
class BooksService {

    private final BooksRepository booksRepository;

    List<Book> allBooks() {
        return booksRepository.findAll();
    }

    void addBook(Book book) {
        booksRepository.save(book);
    }

    Book findById(long id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        return optionalBook.orElseThrow(() ->
                    {String resourceName = Book.class.getName();
                     String resourceId = String.valueOf(id);
                     return new ResourceNotFoundException(resourceName, resourceId);
                    });
    }

    void editBook(long id, Book bookAfterEditing) {
        Book bookFromDB = findById(id);
        bookFromDB.setTitle(bookAfterEditing.getTitle());
        bookFromDB.setAuthor(bookAfterEditing.getAuthor());
        bookFromDB.setPrice(bookAfterEditing.getPrice());
        booksRepository.save(bookFromDB);
    }

    void deleteBook(long id) {
        booksRepository.deleteById(id);
    }
}
