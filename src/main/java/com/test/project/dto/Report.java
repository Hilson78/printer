package com.test.project.dto;

import java.util.Map;

public class Report implements Table {

    private Map<String, String> table;
    private int length;

    public Report() {
    }

    public Report(Map<String, String> table, int length) {
        this.table = table;
        this.length = length;
    }

    public Map<String, String> getTable() {

        return table;
    }

    public void setTable(Map<String, String> table) {
        this.table = table;
    }

    public int getLength() {

        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "com.test.project.dto.Report{" +
                "table=" + table +
                '}';
    }
}
