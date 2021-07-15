package com.example.recyclerview_iiiwe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickLIstener {
    private ArrayList<Employee> employeeArrayList=new ArrayList<>();
    private RecyclerView mRview;
    private CardView meditcardView;
    private EditText mEdtName;
    private EditText mEDtAge;
    private EditText mEdtAddress;
    private Button mBtnDone;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        buildEmployeeList();
        setRecyclerview();
    }

    private void setRecyclerview() {
        adapter=new Adapter(employeeArrayList,this);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager((this));
        mRview.setLayoutManager(linearLayoutManager);
        mRview.setAdapter(adapter);
    }

    private void buildEmployeeList() {
        for(int i=0;i<50;i++)
        {
            Employee employee=new Employee("ABC"+i,20,"Kolkata"+(700000+i));
            employeeArrayList.add(employee);
        }
    }

    private void initviews() {
        mRview=findViewById(R.id.recyclerView);
        meditcardView=findViewById(R.id.editCardView);
        mEdtName=findViewById(R.id.etName);
        mEDtAge=findViewById(R.id.etAge);
        mEdtAddress=findViewById(R.id.etAddress);
        mBtnDone = findViewById(R.id.btnDone);
    }

    @Override
    public void onItemClick(int position, Employee employee) {
        meditcardView.setVisibility(View.VISIBLE);
        mEdtName.setText(employee.getmName());
        mEDtAge.setText(employee.getmAge()+"");
        mEdtAddress.setText(employee.getmAddress());

        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meditcardView.setVisibility(View.GONE);
                Employee employee1=new Employee(mEdtName.getText().toString(),Integer.parseInt(mEDtAge.getText().toString()),mEdtAddress.getText().toString());

                employeeArrayList.set(position,employee1);
                adapter.notifyDataSetChanged();
            }
        });
    }
}