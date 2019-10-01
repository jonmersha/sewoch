package com.gebeya.sewoch.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface FriendDAO {
    @Insert
    public void insert(FriendList... friends);

    @Update
    public void update(FriendList... friends);

    @Delete
    public void delete(FriendList friends);
    @Query("SELECT * FROM friends")
    public List<FriendList> getContacts();

    @Query("SELECT * FROM friends WHERE phoneNumber = :number")
    public FriendList getContactWithId(String number);


}
