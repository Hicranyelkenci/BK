package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.regex.Pattern;

import static com.example.myapplication.user.PASSWORD_PATTERN;

public class yeniUye extends AppCompatActivity {

    Button butonHome;
    ImageButton butonUser;
    EditText sifre;
    EditText sifreTekrar;
    EditText eposta;
    EditText editAd;
    EditText editSoyad;
    EditText editTel;
    Button kayıtol;
    Database Database;
    public  static final Pattern PHONE_PATTERN = Pattern.compile("^"+
            "(?=.*[05])"+
            "(?=.*[0-9])"+
            ".{11}"+
            "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_uyee);
        editAd = findViewById(R.id.editAd);
        editSoyad =findViewById(R.id.editSoyad);
        editTel = findViewById(R.id.editTel);
        eposta = findViewById(R.id.eposta);
        butonHome = findViewById(R.id.bkturizm);

        butonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(yeniUye.this,MainActivity.class);
                startActivity(gecisYap);
            }
        });
        eposta = findViewById(R.id.eposta);
        sifre = findViewById(R.id.sifre);
        sifreTekrar = findViewById(R.id.sifreTekrar);

        butonUser = findViewById(R.id.butonuser);
        butonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(yeniUye.this,user.class);
                startActivity(gecisYap);


            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            eposta.setText(bundle.getString("eposta"));
            sifre.setText(bundle.getString("sifre"));
            sifreTekrar.setText(bundle.getString("sifreTekrar"));
            editTel.setText(bundle.getInt("editTel"));
            editAd.setText(bundle.getString("editAd"));
            editSoyad.setText(bundle.getString("editSoyad"));
        }
        kayıtol = findViewById(R.id.girisyap);
        kayıtol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validatePassword()==true&& validateSoyad()==true&& validateAd()==true&&validateEposta()==true&&validateTel()==true){
                    String ad = editAd.getText().toString();
                    String soyad = editSoyad.getText().toString();
                    String epost =eposta.getText().toString();
                    String sifr = sifre.getText().toString();
                    String sifrtekrar = sifreTekrar.getText().toString();
                    String tell = editTel.getText().toString();
                    Database = new Database(yeniUye.this);
                    Database.addData(ad,soyad,epost,sifr,sifrtekrar,tell);
                    Intent intentList = new Intent(yeniUye.this, ListDataActivity.class);
                    startActivity(intentList);

                }

                validatePassword();
                passAgain();
                validateAd();
                validateSoyad();
                validateTel();


            }
        });

    }
    private boolean validateEposta() {
        String mail = eposta.getText().toString().trim();
        if (mail.isEmpty()) {
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
    private boolean validatePassword() {
        String password = sifre.getText().toString().trim();

        if (password.isEmpty()) {
            sifre.setError("Şifre boş olamaz.");
            return false;

        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            // Toast.makeText(getApplicationContext(),"Şifre 8 karakter uzunluğunda olmalıdır.",Toast.LENGTH_LONG).show();
            sifre.setError("Şifre en az 1 büyük harf, 1 küçük harf, 1 özel karakter içermeli ve 8 karakter uzunluğunda olmalıdır.");
            return false;
        } else {
            sifre.setError(null);
            return true;
        }
    }
    private boolean passAgain(){
        String againpass = sifreTekrar.getText().toString().trim();
        String password = sifre.getText().toString().trim();
        if (!(password.equals(againpass))) {
            sifreTekrar.setError("Şifreler eşleşmemektedir.");
            //Toast.makeText(getApplicationContext(),"Şifreler eşleşmemektedir.",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            sifreTekrar.setError(null);
        return true;

    }
    private boolean validateTel() {
        String tel = editTel.getText().toString().trim();
        if (tel.isEmpty()){
            editTel.setError("Telefon numarası boş olamaz.");
            return false;
        }else if (!PHONE_PATTERN.matcher(tel).matches()) {
            editTel.setError("05 ile başlamalıdır.");
            return false;
        }
        else {
            editTel.setError(null);
            return true;
        }
    }

    private boolean validateSoyad(){
        String soyad = editSoyad.getText().toString().trim();
        if (soyad.isEmpty()){
            editSoyad.setError("Soyad boş olamaz.");
            return false;
        }else {
            editSoyad.setError(null);
            return true;
        }

    }
    private boolean validateAd(){
        String ad = editAd.getText().toString().trim();
        if (ad.isEmpty()){
            editAd.setError("Ad boş olamaz.");
            return false;
        }else {
            editAd.setError(null);
            return true;
        }

    }

}
