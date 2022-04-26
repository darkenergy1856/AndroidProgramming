package com.darkenergy.program_15

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME  = "STUDENT"
const val TABLE_NAME = "STUDENTRECORD"

class SqlClass(context: Context) : SQLiteOpenHelper(context ,
    DATABASE_NAME , null , 1 ) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME (rollNo INTEGER PRIMARY KEY , name TEXT NOT NULL)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val query = "DROP TABLE IF EXISTS $TABLE_NAME"
        p0?.execSQL(query)
        onCreate(p0)
    }

    fun addData(rollNo : Int , name : String){
        val values = ContentValues()
        values.put("rollNo", rollNo )
        values.put("name", name )
        val database = this.writableDatabase
        database.insert(TABLE_NAME , null , values)
        database.close()
    }

    fun updateData(rollNo : Int , name : String) {
        val query =
            "UPDATE $TABLE_NAME set name = '$name' where rollNo = $rollNo"
        val database = this.writableDatabase
        database.execSQL(query)
        database.close()
    }

    fun deleteData(rollNo : Int){
        val query = "DELETE from $TABLE_NAME where rollNo = $rollNo"
        val database = this.writableDatabase
        database.execSQL(query)
        database.close()

    }

    fun viewData() : Cursor?{
        val query = "SELECT * FROM $TABLE_NAME"
        val database = this.readableDatabase
        return database.rawQuery(query , null)
    }

}