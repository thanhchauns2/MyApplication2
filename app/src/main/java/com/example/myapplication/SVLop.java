package com.example.myapplication;

public class SVLop {
    int id, idSV, idLop;

    public SVLop() {
    }

    public SVLop(int id, int idSV, int idLop) {
        this.id = id;
        this.idSV = idSV;
        this.idLop = idLop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }
}
