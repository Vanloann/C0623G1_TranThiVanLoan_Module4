package com.example.bookrent.repository;

import com.example.bookrent.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookCodeRepo extends JpaRepository<BookCode, Integer> {
    @Query(nativeQuery = true, value = "select bc.* from book_code bc left join book b on book_id where bc.code=:bookCode")
    BookCode findByCode(@Param("bookCode") Integer code);

}
