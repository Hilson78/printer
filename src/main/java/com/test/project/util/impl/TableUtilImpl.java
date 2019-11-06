package com.test.project.util.impl;

import com.test.project.dto.Report;
import com.test.project.util.TableUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableUtilImpl implements TableUtil<Report> {

    private List<Report> data;
    private String[] headers;


    public TableUtilImpl(List<Report> data, String[] headers) {
        this.data = data;
        this.headers = headers;
    }


    @Override
    public void printTable() {


        int maxLength = getRowLineSize() + (headers.length + 1) * 2;
        Map<String, Integer> length = countMaxRowSize();

        drawRowLine(maxLength);
        printHeader(length);
        drawRowLine(maxLength);


        for (int i = 0; i < data.size(); i++) {
            Map<String, String> report = data.get(i).getTable();

            split();
            for (int j = 0; j < headers.length; j++) {
                String valueByHeader = report.get(headers[j]);
                System.out.print(valueByHeader);
                addSpaces(length.get(headers[j]) - valueByHeader.length());
                split();
            }
            enter();
            drawRowLine(maxLength);
        }

        enter();
    }

    private void printHeader(Map<String, Integer> length) {
        split();
        for (String headerElement : headers) {
            System.out.print(headerElement);
            addSpaces(length.get(headerElement) - headerElement.length());
            split();
        }
        enter();
    }

    private Map<String, Integer> countMaxRowSize() {
        Map<String, Integer> length = new HashMap<>();
        for (Report report : data) {
            Map<String, String> table = report.getTable();

            for (String headerName : headers) {
                String value = table.get(headerName);

                Integer integer = length.get(headerName);
                if (integer == null || integer < value.length() || integer < headerName.length()) {
                    length.put(headerName, Math.max(headerName.length(), value.length()));
                }
            }
        }

        return length;
    }

    private int getRowLineSize() {
        int maxLength = 0;

        for (Report datum : data) {
            int length = datum.getLength();
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }


    private void addSpaces(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
    }

    private void drawRowLine(int maxLength) {
        for (int i = 0; i < maxLength; i++) {
            System.out.print("-");
        }
        enter();
    }

    private void split() {
        System.out.print("|");
    }

    private void enter() {
        System.out.println();
    }
}
