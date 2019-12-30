//package com.github.tenx.tecnoesis20.ui.main.HomeEventBody;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.github.tenx.tecnoesis20.Config;
//import com.github.tenx.tecnoesis20.R;
//import com.github.tenx.tecnoesis20.data.models.ModuleBody;
//import com.github.tenx.tecnoesis20.ui.module.ModuleActivity;
//import com.google.android.material.button.MaterialButton;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class FirebaseModuleAdapter extends FirebaseRecyclerAdapter<ModuleBody, FirebaseModuleAdapter.CustomViewHolder> {
//
//
//    private Context context;
//
//    public FirebaseModuleAdapter(@NonNull FirebaseRecyclerOptions<ModuleBody> options , Context context) {
//        super(options);
//        this.context = context;
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull CustomViewHolder holder, int position, @NonNull ModuleBody model) {
//
//        Glide.with(context).load(model.getImage()).into(holder.ivModuleImage);
//        holder.tvModuleName.setText(model.getName().toUpperCase());
//        holder.tvModuleDescription.setText(model.getDescription());
//        holder.btnEventsModuleItemReadMore.setOnClickListener(v -> {
//            changeActivity(position);
//        });
//    }
//
//    @NonNull
//    @Override
//    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_module_item, parent, false);
//
//        return new CustomViewHolder(v);
//    }
//
//    private void changeActivity(int position){
//        Intent intent = new Intent(context , ModuleActivity.class);
//        intent.putExtra(Config.INITIAL_PAGE, position);
//        context.startActivity(intent);
//    }
//
//    class CustomViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.iv_module_image)
//        ImageView ivModuleImage;
//        @BindView(R.id.tv_module_name)
//        TextView tvModuleName;
//        @BindView(R.id.tv_module_description)
//        TextView tvModuleDescription;
//        @BindView(R.id.btn_events_module_item_read_more)
//        MaterialButton btnEventsModuleItemReadMore;
//        public CustomViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }
//}
