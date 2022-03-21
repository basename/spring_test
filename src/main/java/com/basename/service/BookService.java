package com.basename.service;

import com.basename.models.dto.BookDto;
import com.basename.models.pojo.Book;
import com.basename.models.query.BookPage;
import com.github.pagehelper.Page;

public interface BookService {

    /**
     * 新增更新书籍
     * @param bookDto
     * @return
     */
    boolean saveBook(BookDto bookDto);

    /**
     * 分页获取信息
     * @param bookPage
     * @return
     */
    Page<Book> getForPage(BookPage bookPage);
}
