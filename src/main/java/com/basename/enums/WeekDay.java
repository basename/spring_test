package com.basename.enums;

import lombok.Data;

public enum WeekDay {
    ONE("第一个","ONE",1),
    TWO("第二个","TWO",2),
    THREE("第三个","THREE",3);

    private String name;
    private String status;
    private Integer sort;

    WeekDay(String name,String status,Integer sort){
        this.name = name;
        this.status = status;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
