package com.example.nguyentrungkhanhb17dccn343.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.nguyentrungkhanhb17dccn343.model.MaTeacher;
import com.example.nguyentrungkhanhb17dccn343.model.Major;
import com.example.nguyentrungkhanhb17dccn343.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "NGUYENTRUNGKHANH_Final";
    private static final String TABLE = "teacher";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String YEAR = "year";
    private static final String LEVEL =  "level";
    //Major
    private static final String TABLE_MAJOR = "major";
    private static final String MAJOR_ID = "majorID";
    private static final String MAJOR_NAME = "majorName";
    private static final String MAJOR_DES = "majorDes";
    //major-teacher
    private static final String TABLE_MT = "majorTeacher";
    private static final String MT_ID = "maTeacherID";
    private static final String MT_ID_TEACHER = "teacherID";
    private static final String MT_ID_MAJOR = "MajorID";
    private static final String MT_YEAR = "yearEx";

    private Context context;

    public DatabaseHelper( Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQueryStu = "CREATE TABLE "+TABLE +" (" +
                ID +" integer primary key, "+
                NAME + " TEXT, "+
                YEAR +" TEXT, " +
               LEVEL+" TEXT)";
        db.execSQL(sqlQueryStu);
        String sqlQueryClass = "CREATE TABLE "+TABLE_MAJOR +" (" +
                MAJOR_ID +" integer primary key, "+
                MAJOR_NAME + " TEXT, "+
                MAJOR_DES+" TEXT)";
        db.execSQL(sqlQueryClass);
        String sqlQueryMT = "CREATE TABLE "+TABLE_MT +" (" +
                MT_ID +" integer primary key, "+
                MT_ID_TEACHER + " integer, "+
                MT_YEAR +"integer," +
                MT_ID_MAJOR+" integer)";
        db.execSQL(sqlQueryMT);

        Toast.makeText(context, "Create Database successfully", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
    public void addTeacher(Teacher teacher){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, teacher.getName());
        values.put(YEAR, teacher.getYear());
        values.put(LEVEL, teacher.getLevel());

        //Neu de null thi khi value bang null thi loi
        db.insert(TABLE,null,values);
        db.close();
    }
    public List<Teacher> getAllTeacher() {

        List<Teacher> listStudent = new ArrayList<Teacher>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Teacher teacher = new Teacher();
                teacher.setId(cursor.getInt(0));
                teacher.setName(cursor.getString(1));
                teacher.setYear(cursor.getInt(2));
                teacher.setLevel(cursor.getString(3));
                               listStudent.add(teacher);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listStudent;
    }
    public void addMajor(Major major){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MAJOR_NAME, major.getName();
        values.put(MAJOR_DES, major.getDes());


        //Neu de null thi khi value bang null thi loi
        db.insert(TABLE,null,values);
        db.close();
    }
    public List<Major> getAllMajor() {

        List<Major> listClass = new ArrayList<Major>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MAJOR;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Major major= new Major();
                major.setId(cursor.getInt(0));
                major.setName(cursor.getString(1));
                major.setDes(cursor.getString(2));
                listClass.add(major);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listClass;
    }
    public void addMaTeacher(MaTeacher mt){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MT_ID_TEACHER, mt.getIdTeacher());
        values.put(MT_ID_MAJOR, mt.getIdMajor());
        values.put(MT_YEAR, mt.getYear());

        //Neu de null thi khi value bang null thi loi
        db.insert(TABLE,null,values);
        db.close();
    }
    public List<MaTeacher> getAllMaTeacher() {

        List<MaTeacher> listMa = new ArrayList<MaTeacher>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MT;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MaTeacher maTeacher= new MaTeacher();
                maTeacher.setId(cursor.getInt(0));
                maTeacher.setIdTeacher(cursor.getInt(1));
                maTeacher.setIdMajor(cursor.getInt(2));
                maTeacher.setId(cursor.getInt(3));
                listMa.add(maTeacher);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listMa;
    }

}
