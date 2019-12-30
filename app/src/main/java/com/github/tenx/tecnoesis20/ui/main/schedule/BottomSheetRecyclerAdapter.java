package com.github.tenx.tecnoesis20.ui.main.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.LocationDetailBody;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomSheetRecyclerAdapter extends RecyclerView.Adapter<BottomSheetRecyclerAdapter.CustomViewHolder> {

    private List<LocationDetailBody.MarkerEvent> eventList;

    public BottomSheetRecyclerAdapter() {
        this.eventList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_bot_sheet_items, parent, false);

        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        LocationDetailBody.MarkerEvent currentData = eventList.get(position);
            holder.tvBotSheetEventDate.setText(currentData.getDate());
            holder.tvBotSheetEventName.setText(currentData.getName());
    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_bot_sheet_event_name)
        TextView tvBotSheetEventName;
        @BindView(R.id.tv_bot_sheet_event_date)
        TextView tvBotSheetEventDate;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);

        }
    }

    public void setEventList(List<LocationDetailBody.MarkerEvent> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }
}
