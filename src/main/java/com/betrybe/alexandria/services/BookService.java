package com.betrybe.alexandria.services;

import com.betrybe.alexandria.models.entities.Book;
import com.betrybe.alexandria.models.entities.BookDetail;
import com.betrybe.alexandria.models.repositories.BookDetailRepository;
import com.betrybe.alexandria.models.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final BookRepository bookRepository;
  private final BookDetailRepository bookDetailRepository;

  @Autowired
  public BookService(BookRepository bookRepository, BookDetailRepository bookDetailRepository) {
    this.bookRepository = bookRepository;
    this.bookDetailRepository = bookDetailRepository;
  }

  public Book insertBook(Book book) {
    return bookRepository.save(book);
  }

  public Optional<Book> updateBook(Long id, Book book) {
    Optional<Book> optionalBook = bookRepository.findById(id);

    if (optionalBook.isPresent()) {
      Book bookFromDB = optionalBook.get();
      bookFromDB.setTitle(book.getTitle());
      bookFromDB.setGenre(book.getGenre());

      Book updatedBook = bookRepository.save(bookFromDB);
      return Optional.of(updatedBook);
    }
    return optionalBook;
  }

  public Optional<Book> removeBookById(Long id) {
    Optional<Book> optionalBook = bookRepository.findById(id);

    if (optionalBook.isPresent()) {
      bookRepository.deleteById(id);
    }

    return optionalBook;
  }

  public Optional<Book> getBookById(Long id) {
    return bookRepository.findById(id);
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  // CRUD para BookDetail
  public BookDetail insertBookDetail(BookDetail bookDetail) {
    return bookDetailRepository.save(bookDetail);
  }
  public Optional<BookDetail> getBookDetailById(Long id) {
    return bookDetailRepository.findById(id);
  }

  public Optional<BookDetail> updateBookDetail(Long id, BookDetail bookDetail) {
    Optional<BookDetail> optionalBook = bookDetailRepository.findById(id);

    if (optionalBook.isPresent()) {
      BookDetail bookFromDB = optionalBook.get();
      bookFromDB.setSumary(bookDetail.getSumary());
      bookFromDB.setPageCount(bookDetail.getPageCount());
      bookFromDB.setYear(bookDetail.getYear());
      bookFromDB.setIsbn(bookDetail.getIsbn());

      BookDetail updatedBook = bookDetailRepository.save(bookFromDB);
      return Optional.of(updatedBook);
    }
    return optionalBook;
  }

  public Optional<BookDetail> removeBookDetailById(Long id) {
    Optional<BookDetail> optionalBook = bookDetailRepository.findById(id);

    if (optionalBook.isPresent()) {
      bookDetailRepository.deleteById(id);
    }

    return optionalBook;
  }
}
