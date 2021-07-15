package com.example.recyclerview_iiiwe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<EmployeeHolder>{

    private ArrayList<Employee> employeeArrayList;
    private ItemClickLIstener itemClickLIstener;
    public Adapter(ArrayList<Employee> employeeArrayList, ItemClickLIstener itemClickLIstener) {
        this.employeeArrayList = employeeArrayList;
        this.itemClickLIstener=itemClickLIstener;
    }
    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new EmployeeHolder(view,itemClickLIstener);
    }

    @Override
    public void onBindViewHolder(@NonNull  EmployeeHolder holder, int position) {
        Employee employee=employeeArrayList.get(position);
        holder.setData(employee);
    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();

    }

}
