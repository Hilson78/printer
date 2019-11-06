package com.test.project.dao.impl;

import com.test.project.dto.Report;
import com.test.project.dao.TableFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.test.project.constant.DaoConstants.SPLIT;

public class CSVTableFileReader implements TableFileReader<Report> {

    private String file;

    public CSVTableFileReader(String file) {
        this.file = file;
    }

    @Override
    public String[] getHeader() {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            if ((line = br.readLine()) != null) {
                return line.split(SPLIT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String[0];
    }

    public List<Report> getData() {
        ArrayList<Report> reports = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            List<String[]> result = new ArrayList<>();
            List<Integer> sizes = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] strings = line.split(SPLIT);
                result.add(strings);
                sizes.add(line.length());
            }


            String[] header = result.get(0);

            for (int i = 1; i < result.size(); i++) {
                String[] row = result.get(i);

                HashMap<String, String> table = new HashMap<>();
                for (int j = 0; j < row.length; j++) {
                    table.put(header[j], row[j]);
                }

                reports.add(new Report(table, sizes.get(i)));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return reports;
    }
}
