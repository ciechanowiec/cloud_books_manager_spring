package eu.ciechanowiec.books;

import java.util.List;
import java.util.TimerTask;

/**
 * @author Herman Ciechanowiec
 */
class ResetTask extends TimerTask {

    private final BooksRepository booksRepository;

    ResetTask(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void run() {
        booksRepository.deleteAll();
        booksRepository.resetIdCount();
        List<Book> samples = Book.generateSamples();
        booksRepository.saveAll(samples);
    }
}
