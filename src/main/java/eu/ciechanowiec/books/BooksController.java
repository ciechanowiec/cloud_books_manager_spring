package eu.ciechanowiec.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Herman Ciechanowiec
 */
@Controller
@RequestMapping("/")
@AllArgsConstructor
class BooksController {

    private final BooksService booksService;

    @GetMapping
    String allBooks(Model model) {
        List<Book> books = booksService.allBooks();
        model.addAttribute("books", books);
        return "all_books.html";
    }

    @GetMapping("/new")
    String addBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add_book.html";
    }

    @PostMapping("/new")
    String addBook(@ModelAttribute(name = "book") Book book) {
        booksService.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    String editBookForm(
           Model model,
           @PathVariable(name = "id")
           long id) {
        Book bookBeforeEditing = booksService.findById(id);
        model.addAttribute("editedBook", bookBeforeEditing);
        return "edit_book.html";
    }

    @PutMapping("/edit/{id}")
    String editBook(
           @PathVariable(name = "id")
           long id,
           @ModelAttribute(name = "editedBook") Book bookAfterEditing) {
        booksService.editBook(id, bookAfterEditing);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    String deleteBook(@PathVariable(name = "id") long id) {
        booksService.deleteBook(id);
        return "redirect:/";
    }
}
