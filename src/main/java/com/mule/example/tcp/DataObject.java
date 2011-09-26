package com.mule.example.tcp;

import java.io.Serializable;

public class DataObject implements Serializable{
    private static final long serialVersionUID = 7531686044701924086L;
    private Integer id;

    public DataObject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
