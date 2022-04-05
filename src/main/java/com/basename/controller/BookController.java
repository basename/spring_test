package com.basename.controller;

import com.basename.config.DatasourceConfiguration;
import com.basename.interfaces.Report;
import com.basename.lib.ResponseData;
import com.basename.models.dto.BookDto;
import com.basename.models.dto.PageListDto;
import com.basename.models.pojo.Book;
import com.basename.models.query.BookPage;
import com.basename.service.BookService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${server.port:}")
    private int port;

    @Autowired
    private DatasourceConfiguration datasourceConfiguration;

    /**
     * 新增获取
     * @param bookDto
     * @return
     */
    @PostMapping
    public ResponseData save(@Validated @RequestBody BookDto bookDto){

        System.out.println(datasourceConfiguration.getPassword());
        System.out.println(datasourceConfiguration.getUserName());

//        boolean b = bookService.saveBook(bookDto);
        return ResponseData.success(bookDto);
    }

    /**
     * 分页获取书籍
     * @param bookPage
     * @return
     */
    @GetMapping
    public ResponseData getList(@Validated @RequestBody BookPage bookPage){
        Page<Book> forPage = bookService.getForPage(bookPage);

        PageListDto pageListDto = new PageListDto();
        pageListDto.setPage(forPage.getPageNum());
        pageListDto.setPageSize(forPage.getPageSize());
        pageListDto.setTotal((int) forPage.getTotal());
        pageListDto.setList(forPage.getResult());

        return  ResponseData.success(pageListDto);
    }
}
