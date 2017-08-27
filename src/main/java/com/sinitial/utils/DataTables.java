package com.sinitial.utils;

import com.sinitial.domain.User;

import java.util.List;

/**
 * Created by nekuata on 2017/7/19.
 */
public class DataTables {
    private int recordsTotal;
    private int recordsFiltered;
    private List<User> data;

    public DataTables() {
    }

    public DataTables(int recordsTotal, int recordsFiltered, List<User> data) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
