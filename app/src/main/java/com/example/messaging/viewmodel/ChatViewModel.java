package com.example.messaging.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.messaging.model.Message;
import com.example.messaging.repository.MessageRepository;

import java.util.List;

/**
 * ViewModel الخاص بواجهة المحادثة.
 */
public class ChatViewModel extends AndroidViewModel {

    private final MessageRepository repository;
    private LiveData<List<Message>> messages;
    private String currentConversationId;

    public ChatViewModel(@NonNull Application application) {
        super(application);
        repository = new MessageRepository(application);
    }

    public void setConversationId(String conversationId) {
        if (conversationId == null) return;
        if (!conversationId.equals(this.currentConversationId)) {
            this.currentConversationId = conversationId;
            messages = repository.getMessages(conversationId);
        }
    }

    public LiveData<List<Message>> getMessages() {
        return messages;
    }

    public void sendMessage(String text)
