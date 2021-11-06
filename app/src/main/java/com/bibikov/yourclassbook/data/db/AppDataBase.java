package com.bibikov.yourclassbook.data.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bibikov.yourclassbook.data.entity.Group;

@Database(entities = {Group.class}, version = 1)

public abstract class AppDataBase extends RoomDatabase {

    public abstract GroupDao groupDao();

}
