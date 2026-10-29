package com.example.messaging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter لعرض الرسائل في RecyclerView.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private final List<Message> messages;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;
        View bubble;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            bubble = itemView.findViewById(R.id.bubble);
        }
    }

    @Override
    public int getItemViewType(int position) {
        // نستخدم نوعين من الـ layout: للرسائل المرسلة والرسائل المستقبلة
        return messages.get(position).isSentByUser() ? 1 : 0;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = (viewType == 1) ?
                R.layout.item_message_sent :
                R.layout.item_message_received;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message msg = messages.get(position);
        holder.tvMessage.setText(msg.getText());
        // يمكن إضافة المزيد من التنسيق إذا رغبت
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
