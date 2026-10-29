package com.example.messaging.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;

import com.example.messaging.model.Message;

import java.util.List;

@Dao
public interface MessageDao {

    @Insert
    long insert(Message message);

    @Query("SELECT * FROM messages WHERE conversationId = :conversationId ORDER BY timestamp ASC")
    LiveData<List<Message>> getMessagesForConversation(String conversationId);

    @Query("DELETE FROM messages WHERE conversationId = :conversationId")
    void deleteAllForConversation(String conversationId);
}
