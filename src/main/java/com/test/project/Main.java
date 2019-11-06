package com.test.project;

import com.test.project.dao.impl.CSVTableFileReader;
import com.test.project.dao.TableFileReader;
import com.test.project.dto.Report;
import com.test.project.util.TableUtil;
import com.test.project.util.impl.TableUtilImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TableFileReader<Report> reader = new CSVTableFileReader("D:\\Java\\printer\\report2017.csv");

        List<Report> data = reader.getData();
        String[] header = reader.getHeader();

        TableUtil<Report> tableUtil = new TableUtilImpl(data, header);

        tableUtil.printTable();


    }
}
