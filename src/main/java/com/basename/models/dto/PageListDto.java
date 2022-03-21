package com.basename.models.dto;

import lombok.Data;

import java.util.List;


@Data
public class PageListDto<T> {
    private Integer page;
    private Integer pageSize;
    private Integer total;
    private List<T> list;
}
