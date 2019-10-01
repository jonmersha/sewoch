package com.gebeya.sewoch.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FriendList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FriendDAO getFriendDAO();
}