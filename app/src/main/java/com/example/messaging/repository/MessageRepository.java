package com.example.messaging.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.messaging.data.AppDatabase;
import com.example.messaging.model.Message;
import com.example.messaging.model.Conversation;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * طبقة تجريدية بين ViewModel و Room.
 */
public class MessageRepository {

    private static final String DB_NAME = "messaging-db";
    private final AppDatabase db;
    private final Executor executor = Executors.newSingleThreadExecutor();

    public MessageRepository(Context context) {
        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    // ---------- Conversation ----------
    public LiveData<List<Conversation>> getAllConversations() {
        return db.conversationDao().getAllConversations();
    }

    public void upsertConversation(Conversation conversation) {
        executor.execute(() -> db.conversationDao().insertOrUpdate(conversation));
    }

    // ---------- Message ----------
    public LiveData<List<Message>> getMessages(String conversationId) {
        return db.messageDao().getMessagesForConversation(conversationId);
    }

    public void insertMessage(Message message) {
        executor.execute(() -> {
            long id = db.messageDao().insert(message);
            // بعد إدخال الرسالة، نحدّث وقت آخر رسالة للمحادثة
            Conversation conv = new Conversation(
                    message.conversationId,
                    // إذا لم يكن هناك عنوان، نستخدم "دردشة"
                    "دردشة", 
                    message.timestamp);
            db.conversationDao().insertOrUpdate(conv);
        });
    }
}
