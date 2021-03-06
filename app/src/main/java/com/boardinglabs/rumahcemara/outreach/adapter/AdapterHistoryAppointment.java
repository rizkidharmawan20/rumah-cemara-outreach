package com.boardinglabs.rumahcemara.outreach.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.boardinglabs.rumahcemara.outreach.DetailHistoryAppointmentActivity;
import com.boardinglabs.rumahcemara.outreach.R;
import com.boardinglabs.rumahcemara.outreach.models.HistoryModel;
import com.boardinglabs.rumahcemara.outreach.models.RequestModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class AdapterHistoryAppointment extends RecyclerView.Adapter<AdapterHistoryAppointment.ViewHolder> {
    private List<HistoryModel> articleModels;
    private Context context;

    public AdapterHistoryAppointment(List<HistoryModel> articleModels, Context context){
        this.articleModels = articleModels;
        this.context = context;
    }

    @Override
    public AdapterHistoryAppointment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_history_appointment, parent, false);

        return new AdapterHistoryAppointment.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterHistoryAppointment.ViewHolder holder, int position){
        final HistoryModel articleModel = articleModels.get(position);
        final String serviceId = articleModel.getServiceId();
        final String serviceName = articleModel.getServiceName();
        final String imgUrl = articleModel.getImgUrl();
        final String fullName = articleModel.getFullName();
        final String phoneNumber = articleModel.getPhoneNumber();
        final String startDate = articleModel.getStart_date();
        final String endDate = articleModel.getEnd_date();
        final String description = articleModel.getDescription();
        final String rating = articleModel.getRating();
        final String comment = articleModel.getComment();
        final String location = articleModel.getAttachment();

        Glide.with(context).applyDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_person_signup)).load(articleModel.getImgUrl()).into(holder.imageView);
        holder.textViewFullname.setText(articleModel.getFullName());
//        holder.textViewPhoneNumber.setText(articleModel.getPhoneNumber());
        holder.linearLayout.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("serviceId", serviceId);
            bundle.putString("serviceName", serviceName);
            bundle.putString("imgUrl", imgUrl);
            bundle.putString("fullName", fullName);
            bundle.putString("phoneNumber", phoneNumber);
            bundle.putString("startDate", startDate);
            bundle.putString("endDate", endDate);
            bundle.putString("description", description);
            bundle.putString("rating", rating);
            bundle.putString("comment", comment);
            bundle.putString("location", location);

            Intent in=new Intent(context, DetailHistoryAppointmentActivity.class);
            in.putExtra("myData", bundle);
            context.startActivity(in);
        });
    }

    @Override
    public int getItemCount(){ return articleModels.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CircularImageView imageView;
        public TextView textViewFullname;
//        public TextView textViewPhoneNumber;
        public FrameLayout linearLayout;

        public ViewHolder(View v){
            super(v);

            imageView = (CircularImageView) v.findViewById(R.id.imgListProfile);
            textViewFullname = (TextView) v.findViewById(R.id.tvName);
//            textViewPhoneNumber = (TextView) v.findViewById(R.id.tvPhoneNumber);
            linearLayout = (FrameLayout) v.findViewById(R.id.layout_article);
        }
    }

}
