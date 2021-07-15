package com.example.recyclerview_iiiwe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeHolder extends RecyclerView.ViewHolder {
    private TextView mName;
    private TextView mAge;
    private TextView mAddress;
    private ImageView mIvEdit;
    private ItemClickLIstener itemClickLIstener;
    public EmployeeHolder(@NonNull View itemView, ItemClickLIstener itemClickLIstener) {
        super(itemView);
        initview(itemView);
        this.itemClickLIstener=itemClickLIstener;
    }

    private void initview(View itemView) {
        mName=itemView.findViewById(R.id.tvName);
        mAge=itemView.findViewById(R.id.tvAge);
        mAddress=itemView.findViewById(R.id.tvAddress);
        mIvEdit=itemView.findViewById(R.id.ivEdit);
    }
    public void setData(Employee employee)

    {
        mName.setText(employee.getmName());
        mAge.setText(employee.getmAge()+"");
        mAddress.setText(employee.getmAddress());
        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickLIstener.onItemClick(getAdapterPosition(),employee);
            }
        });
    }
}
