package eu.ciechanowiec.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Herman Ciechanowiec
 */
interface BooksRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE books AUTO_INCREMENT = 1", nativeQuery = true)
    void resetIdCount();
}
