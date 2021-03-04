package com.example.data_binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.data_binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String name,email,city;
    UserModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        model=new UserModel();
        MyHandler handler=new MyHandler();
        binding.setHandler(handler);
        
    }
    public class MyHandler{
        public void onButtonClick(View v){
            name=binding.nameEdit.getText().toString();
            email=binding.emailEdit.getText().toString();
            city=binding.cityEdit.getText().toString();
            if(name.isEmpty()||city.isEmpty()||email.isEmpty()){
                Toast.makeText(MainActivity.this, "Empty Field", Toast.LENGTH_SHORT).show();
            }else {
                model.setName("Your Name"+name);
                model.setEmail("Email:"+email);
                model.setCity("City"+city);
                binding.setUser(model);
            }

        }

    }
}