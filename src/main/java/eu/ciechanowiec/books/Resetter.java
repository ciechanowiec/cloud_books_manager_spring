package eu.ciechanowiec.books;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @author Herman Ciechanowiec
 */
@Component
class Resetter {

    private final Timer timer;
    private final BooksRepository booksRepository;

    Resetter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
        timer = new Timer();
        polluteEmptyTableWithSamples();
        scheduleResetTask();
    }

    private void polluteEmptyTableWithSamples() {
        if (isTableEmpty()) {
            booksRepository.deleteAll();
            booksRepository.resetIdCount();
            List<Book> samples = Book.generateSamples();
            booksRepository.saveAll(samples);
        }
    }

    private boolean isTableEmpty() {
        List<Book> allEntries = booksRepository.findAll();
        return allEntries.isEmpty();
    }

    private void scheduleResetTask() {
        ResetTask resetTask = new ResetTask(booksRepository);
        long delayFromStart = TimeUnit.DAYS.toMillis(1);
        long resetPeriod = TimeUnit.DAYS.toMillis(1);
        timer.schedule(resetTask, delayFromStart, resetPeriod);
    }
}
