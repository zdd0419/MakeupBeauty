package com.example.makeupbeauty.util

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(var context: Context?, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    public var createBook="create table history (" +
            "id integer primary key autoincrement," +
            "person text," +
            "message text," +
            "time text)"

    override fun onCreate(db: SQLiteDatabase?) {
//        下面这个todo 如果不注释掉的话就会报错。
        db?.execSQL(createBook)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Book")
        onCreate(db)
    }
}
