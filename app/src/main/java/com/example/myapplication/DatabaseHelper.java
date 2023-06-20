package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String dbname = "dbname.db";
    private static final int dbver = 1;

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context){
        super(context, dbname, null, dbver);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table sinhvien(" +
                "id integer primary key autoincrement," +
                "name text," +
                "namSinh text," +
                "que text," +
                "namHoc text" +
                ")";
        db.execSQL(sql);
        sql = "create table lop(" +
                "id integer primary key autoincrement," +
                "name text," +
                "moTa text" +
                ")";
        db.execSQL(sql);
        sql = "create table SVlop(" +
                "id integer primary key autoincrement," +
                "idSV integer," +
                "idLop integer" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "drop table sinhvien";
        db.execSQL(sql);
        sql = "drop table lop";
        db.execSQL(sql);
        sql = "drop table SVlop";
        db.execSQL(sql);
    }

    public void addSV(String name, String namSinh, String que, String namHoc){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "insert into sinhvien(name, namSinh, que, namHoc) values (" +
                "\"" + name + "\",\"" + namSinh + "\",\"" + que + "\",\"" + namHoc +
                "\")";
        db.execSQL(sql);
    }

    public void addLop(String name, String mota){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "insert into lop(name, moTa) values (" +
                name + "," + mota +
                ")";
        db.execSQL(sql);
    }

    public void addSVLop(int idSV, int idLop){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "insert into SVlop(idSV, idLop) values (" +
                idSV + "," + idLop +
                ")";
        db.execSQL(sql);
    }

    public ArrayList<SinhVien> getSV(){
        ArrayList<SinhVien> a = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from sinhvien";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String namSinh = cursor.getString(cursor.getColumnIndex("namSinh"));
                @SuppressLint("Range") String que = cursor.getString(cursor.getColumnIndex("que"));
                @SuppressLint("Range") String namHoc = cursor.getString(cursor.getColumnIndex("namHoc"));
                a.add(new SinhVien(id, name, namSinh, que, namHoc));
            } while(cursor.moveToNext());
        }
        return a;
    }

    public ArrayList<Lop> getLop(){
        ArrayList<Lop> a = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from lop";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String ten = cursor.getString(cursor.getColumnIndex("ten"));
                @SuppressLint("Range") String moTa = cursor.getString(cursor.getColumnIndex("moTa"));
                a.add(new Lop(id, ten, moTa));
            } while(cursor.moveToNext());
        }
        return a;
    }
}
