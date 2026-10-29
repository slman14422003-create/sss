package com.example.messaging.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;
import androidx.room.OnConflictStrategy;

import com.example.messaging.model.Conversation;

import java.util.List;

@Dao
public interface ConversationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(Conversation conversation);

    @Query("SELECT * FROM conversations ORDER BY lastMessageTime DESC")
    LiveData<List<Conversation>> getAllConversations();

    @Delete
    void delete(Conversation conversation);
}
