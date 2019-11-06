package com.test.project.util;

import com.test.project.dto.Table;

public interface TableUtil<T extends Table> {
    void printTable();
}
