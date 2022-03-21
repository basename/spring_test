package com.basename.service.Impl;

import com.basename.dao.BookMapper;
import com.basename.models.dto.BookDto;
import com.basename.models.pojo.Book;
import com.basename.models.query.BookPage;
import com.basename.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean saveBook(BookDto bookDto) {
        Integer affectedRows = 0;

        Book book = new Book();
        BeanUtils.copyProperties(bookDto,book);
        affectedRows = bookMapper.insert(book);

        if (affectedRows > 0){
            return true;
        }
        return false;
    }

    @Override
    public Page<Book> getForPage(BookPage bookPage) {

        Page<Book> page = null;

        Integer currentPage = bookPage.getPage();
        Integer pageSize = bookPage.getPageSize();

        if (pageSize != 0){
            page = PageHelper.startPage(currentPage,pageSize,true);
        }
        List<Book> list = bookMapper.selectAll();
        return  page;
    }
}
