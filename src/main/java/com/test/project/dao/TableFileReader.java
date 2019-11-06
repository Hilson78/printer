package com.test.project.dao;

import com.test.project.dto.Table;

import java.util.List;

public interface TableFileReader<T extends Table> {

    String[] getHeader();
    List<T> getData();
}
