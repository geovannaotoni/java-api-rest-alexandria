package com.betrybe.alexandria.controllers;

import com.betrybe.alexandria.controllers.dto.BookDTO;
import com.betrybe.alexandria.controllers.dto.BookDetailDTO;
import com.betrybe.alexandria.controllers.dto.ResponseDTO;
import com.betrybe.alexandria.models.entities.Book;
import com.betrybe.alexandria.models.entities.BookDetail;
import com.betrybe.alexandria.services.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

//  @GetMapping
//  public String healthCheck() {
//    return "Ok";
//  }

  @PostMapping
  public ResponseEntity<ResponseDTO<Book>> createBook(@RequestBody BookDTO bookDTO) {
    Book newBook = bookService.insertBook(bookDTO.toBook());
    ResponseDTO<Book> responseDTO = new ResponseDTO<Book>("Livro criado com sucesso.", newBook);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

  @PutMapping("/{bookId}")
  public ResponseEntity<ResponseDTO<Book>> updateBook(@PathVariable Long bookId, @RequestBody BookDTO bookDTO) {
    Optional<Book> optionalBook = bookService.updateBook(bookId, bookDTO.toBook());

    if (optionalBook.isEmpty()) {
      ResponseDTO<Book> responseDTO = new ResponseDTO<>(String.format("Livro com id %d não encontrado", bookId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Book> responseDTO = new ResponseDTO<>("Livro atualizado com sucesso.", optionalBook.get());
    return ResponseEntity.ok(responseDTO);
  }

  @DeleteMapping("/{bookId}")
  public ResponseEntity<ResponseDTO<Book>> removeBookById(@PathVariable Long bookId) {
    Optional<Book> optionalBook = bookService.removeBookById(bookId);

    if (optionalBook.isEmpty()) {
      ResponseDTO<Book> responseDTO = new ResponseDTO<>(String.format("Livro com id %d não encontrado", bookId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Book> responseDTO = new ResponseDTO<>("Livro removido com sucesso", optionalBook.get());
    return ResponseEntity.ok(responseDTO);
  }

  @GetMapping("/{bookId}")
  public ResponseEntity<ResponseDTO<Book>> getBookById(@PathVariable Long bookId) {
    Optional<Book> optionalBook = bookService.getBookById(bookId);

    if (optionalBook.isEmpty()) {
      ResponseDTO<Book> responseDTO = new ResponseDTO<>(String.format("Livro com id %d não encontrado", bookId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Book> responseDTO = new ResponseDTO<>("Livro encontrado com sucesso", optionalBook.get());
    return ResponseEntity.ok(responseDTO);
  }

  @GetMapping
  public List<BookDTO> getAllBooks() {
    List<Book> allBooks = bookService.getAllBooks();
    return allBooks.stream()
        .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getGenre()))
        .toList();
  }

  // CRUD para BookDetail
  @PostMapping("/{bookId}/details")
  public ResponseEntity<ResponseDTO<BookDetail>> createBookDetail(@RequestBody BookDetailDTO bookDetailDTO) {
    BookDetail newBook = bookService.insertBookDetail(bookDetailDTO.toBookDetail());
    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Detalhes do livro criado com sucesso.", newBook);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

  @PutMapping("/{bookId}/details/{id}")
  public ResponseEntity<ResponseDTO<BookDetail>> updateBookDetail(@PathVariable Long id, @RequestBody BookDetailDTO bookDetailDTO) {
    Optional<BookDetail> optionalBook = bookService.updateBookDetail(id, bookDetailDTO.toBookDetail());

    if (optionalBook.isEmpty()) {
      ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(String.format("Detalhes com id %d não encontrado", id), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Detalhes do livro atualizado com sucesso.", optionalBook.get());
    return ResponseEntity.ok(responseDTO);
  }

  @DeleteMapping("/{bookId}/details/{id}")
  public ResponseEntity<ResponseDTO<BookDetail>> removeBookDetailById(@PathVariable Long id) {
    Optional<BookDetail> optionalBook = bookService.removeBookDetailById(id);

    if (optionalBook.isEmpty()) {
      ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(String.format("Detalhes com id %d não encontrado", id), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Detalhes do livro removido com sucesso", optionalBook.get());
    return ResponseEntity.ok(responseDTO);
  }

  @GetMapping("/{bookId}/details/{id}")
  public ResponseEntity<ResponseDTO<BookDetail>> getBookDetailById(@PathVariable Long id) {
    Optional<BookDetail> optionalBook = bookService.getBookDetailById(id);

    if (optionalBook.isEmpty()) {
      ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(String.format("Detalhes com id %d não encontrado", id), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Detalhes do livro encontrado com sucesso", optionalBook.get());
    return ResponseEntity.ok(responseDTO);
  }
}
