package com.example.demo.util;

import java.util.List;

public class ResponseDTO<T> {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    private int total;
    private List<T> rows;

    public ResponseDTO (boolean success, int total, List<T> rows) {
        this.success = success;
        this.total = total;
        this.rows = rows;
    }

}
