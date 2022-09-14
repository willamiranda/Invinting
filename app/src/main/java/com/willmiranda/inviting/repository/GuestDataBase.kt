package com.willmiranda.inviting.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.willmiranda.inviting.constants.DataBaseConstants
import com.willmiranda.inviting.model.GuestModel

//class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {
@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBase() : RoomDatabase() {

    abstract fun guestDAO(): GuestDao

    companion object {
        private lateinit var INSTANCE: GuestDataBase
        fun getDataBase(context: Context): GuestDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(GuestDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "guestdb")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
        private val MIGRATION_1_2: Migration = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                TODO("Not yet implemented")
            }

        }
    }
    /*
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}*/

}