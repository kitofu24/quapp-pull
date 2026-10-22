package com.example.quapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Queue cards, for Browse and for the owner's Queues tab. Pass stats to get the organizer
 * footer (waiting · served · no-shows); without them it's the queuer footer (the wait).
 */
public class QueueAdapter extends RecyclerView.Adapter<QueueAdapter.QueueViewHolder> {

    public interface OnQueueClickListener {
        void onQueueClick(Queue queue);
    }

    private final List<Queue> queues = new ArrayList<>();
    private final Map<String, QueueStats> statsById = new HashMap<>();
    private final OnQueueClickListener clickListener;

    public QueueAdapter(OnQueueClickListener clickListener) {
        this.clickListener = clickListener;
    }

    /** Browse: no stats. */
    public void submitQueues(List<Queue> newQueues) {
        submitQueues(newQueues, null);
    }

    /** Owner: stats keyed by queue id; the adapter only shows them, never fetches them. */
    public void submitQueues(List<Queue> newQueues, @Nullable Map<String, QueueStats> newStats) {
        final List<Queue> previous = new ArrayList<>(queues);
        final List<Queue> next = new ArrayList<>(newQueues);
        DiffUtil.DiffResult changes = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override public int getOldListSize() { return previous.size(); }
            @Override public int getNewListSize() { return next.size(); }
            @Override public boolean areItemsTheSame(int oldPosition, int newPosition) {
                return previous.get(oldPosition).getId().equals(next.get(newPosition).getId());
            }
            @Override public boolean areContentsTheSame(int oldPosition, int newPosition) {
                // Queue instances can mutate in place; always rebind current values and stats.
                return false;
            }
        });
        queues.clear();
        queues.addAll(next);
        statsById.clear();
        if (newStats != null) {
            statsById.putAll(newStats);
        }
        changes.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public QueueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_queue_card, parent, false);
        return new QueueViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QueueViewHolder holder, int position) {
        Queue queue = queues.get(position);
        holder.bind(queue, statsById.get(queue.getId()), clickListener);
    }

    @Override
    public int getItemCount() {
        return queues.size();
    }

    static class QueueViewHolder extends RecyclerView.ViewHolder {

        QueueViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(final Queue queue, @Nullable QueueStats stats,
                  final OnQueueClickListener clickListener) {
            QueueCards.bind(itemView, queue, stats);
            // A straight column keeps the catalogue details readable in long scrolling lists.
            itemView.setRotation(0f);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onQueueClick(queue);
                }
            });
        }
    }
}
