package com.sulaimanms.presensimdnu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sulaimanms.presensimdnu.Api.Presensi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sulaiman MS on 5/30/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Presensi> presensiList;
    public static ArrayList<String> answer;

    public Adapter(List<Presensi> presensiList) {
        this.presensiList = presensiList;
        answer = new ArrayList<>();
        for (int i=0; i<presensiList.size(); i++){
            answer.add("no no no");
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_name.setText(presensiList.get(position).getNama().trim());
        holder.radioGroup.clearCheck();
        holder.rb_hadir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answer.set(position,"hadir");
                }
            }
        });
        holder.rb_alfa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answer.set(position,"alfa");
                }
            }
        });
        holder.rb_sakit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answer.set(position,"sakit");
                }
            }
        });
        holder.rb_izin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    answer.set(position,"izin");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return presensiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private RadioButton rb_hadir, rb_alfa, rb_izin, rb_sakit;
        private RadioGroup radioGroup;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            radioGroup = (RadioGroup)view.findViewById(R.id.radioPresensi);
            rb_hadir = (RadioButton) view.findViewById(R.id.h);
            rb_alfa = (RadioButton) view.findViewById(R.id.a);
            rb_izin = (RadioButton) view.findViewById(R.id.iz);
            rb_sakit = (RadioButton) view.findViewById(R.id.s);
        }
    }
}
