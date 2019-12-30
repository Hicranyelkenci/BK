package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.StorageReference;

import java.util.regex.Pattern;

public class user extends AppCompatActivity {
    Button girisyap;
    EditText eposta;
    EditText sifre;
    Button butonHome;
    ImageButton butonUser;
    Button butonyeniuye;
    public FirebaseAuth mAuth;
    public StorageReference mStorageRef;
    public  static final Pattern PASSWORD_PATTERN = Pattern.compile("^"+
            "(?=.*[0-9])"+
            "(?=.*[a-z])"+
            "(?=.*[A-Z])"+
            "(?=.*[@#$%^&+=])"+
            "(?=\\S+$)"+
            ".{8}"+
            "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        girisyap = findViewById(R.id.girisyap);
        eposta = findViewById(R.id.eposta);
        sifre = findViewById(R.id.sifre);


        butonyeniuye = findViewById(R.id.yeniuye);
        butonyeniuye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IyeniUye = new Intent(user.this, yeniUye.class);
                startActivity(IyeniUye);
            }
        });
        butonHome = findViewById(R.id.bkturizm);
        butonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(user.this, MainActivity.class);
                startActivity(gecisYap);
            }
        });

        butonUser = findViewById(R.id.butonuser);
        butonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(user.this, user.class);
                startActivity(gecisYap);
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            eposta.setText(bundle.getString("eposta"));
            sifre.setText(bundle.getString("sifre"));
        }
        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddr = eposta.getText().toString();
                String pass = sifre.getText().toString();
                validateEposta();
                validatePassword();

                if(validatePassword()==true) {
                    Intent intentGiris = new Intent(user.this, MainActivity.class);
                    startActivity(intentGiris);
                }
                else
                    Toast.makeText(user.this,"Başarısız",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean validateEposta() {
        String mail = eposta.getText().toString().trim();
        if (mail.isEmpty()) {
            // Toast.makeText(getApplicationContext(),"Geçerli bir eposta girin.",Toast.LENGTH_LONG).show();
            eposta.setError("E posta boş olamaz.");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            eposta.setError("Geçerli bir e-posta girin.");
            return false;
        } else {
            eposta.setError(null);
            return true;
        }


    }

    public boolean validatePassword() {
        String password = sifre.getText().toString().trim();

        if (password.isEmpty()) {
            sifre.setError("Şifre boş olamaz.");
            return false;

        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            // Toast.makeText(getApplicationContext(),"Şifre 8 karakter uzunluğunda olmalıdır.",Toast.LENGTH_LONG).show();
            sifre.setError("Şifre en az 1 büyük harf, 1 küçük harf, 1 özel karakter içermeli ve 8 karakter uzunluğunda olmalıdır.");
            return false;
        } else {
            eposta.setError(null);
            return true;
        }


    }
}
