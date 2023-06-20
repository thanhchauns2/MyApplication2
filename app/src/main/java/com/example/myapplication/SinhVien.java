package com.example.myapplication;

public class SinhVien {
    int id;
    String name, namSinh, que, namHoc;

    public SinhVien() {
    }

    public SinhVien(int id, String name, String namSinh, String que, String namHoc) {
        this.id = id;
        this.name = name;
        this.namSinh = namSinh;
        this.que = que;
        this.namHoc = namHoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    @Override
    public String toString(){
        return id + " " + name;
    }
}
