package com.sinitial.utils;

import com.sinitial.domain.Author;

import java.util.List;

/**
 * Created by nekuata on 2017/7/20.
 */
public class BootstrapTable {
    private int total;
    private List<Author> rows;

    public BootstrapTable() {
    }

    public BootstrapTable(int total, List<Author> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Author> getRows() {
        return rows;
    }

    public void setRows(List<Author> rows) {
        this.rows = rows;
    }
}
