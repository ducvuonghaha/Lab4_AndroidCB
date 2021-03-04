package com.dcvg.lab4_androidcb.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dcvg.lab4_androidcb.R;
import com.dcvg.lab4_androidcb.adapter.UserAdapter;
import com.dcvg.lab4_androidcb.dao.UserDAO;
import com.dcvg.lab4_androidcb.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText edtFullnameUser;
    private EditText edtPhoneUser;
    private Button btnAdd;
    private RecyclerView rcvUserClass;
    private UserDAO userDAO;
    private UserAdapter userAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        if (userDAO.getAllUsers().size() != 0) {
            userAdapter = new UserAdapter(this, userDAO.getAllUsers());
            rcvUserClass.setAdapter(userAdapter);
            rcvUserClass.setLayoutManager(linearLayoutManager);
            userAdapter.notifyDataSetChanged();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtFullnameUser.getText().toString().trim().isEmpty() || edtPhoneUser.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (userDAO.insertUser(new User(edtFullnameUser.getText().toString().trim(), edtPhoneUser.getText().toString().trim())) > 0) {
                        userAdapter = new UserAdapter(MainActivity.this, userDAO.getAllUsers());
                        rcvUserClass.setAdapter(userAdapter);
                        rcvUserClass.setLayoutManager(linearLayoutManager);
                        userAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Thêm người dùng thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Thêm người dùng thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void initView() {
        edtFullnameUser = (EditText) findViewById(R.id.edtFullnameUser);
        edtPhoneUser = (EditText) findViewById(R.id.edtPhoneUser);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        rcvUserClass = (RecyclerView) findViewById(R.id.rcvUserClass);
        userDAO = new UserDAO(this);
        linearLayoutManager = new LinearLayoutManager(this);
    }
}