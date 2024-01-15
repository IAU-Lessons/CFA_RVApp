package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // ---------------------------
    /*
    * Kullanıcının daha önceden sisteme kaydolduğunu varsayıyoruz.
    * Kullanıcı kaydolurken bu kullanıcı adı ve şifreyi girmiş olsun.
    * Daha sonraki giriş işlemlerinde biz bu verileri kullanarak
    * giriş işlemini gerçekleştireceğiz ve kontrolleri bunun üzerinden yapacağız.
    * */
    String uname = "deneme@deneme.com";
    String pass = "123123";
    // -------------------------


    EditText usernameField;
    EditText passwordField;

    Button loginBtn, registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);

        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtn:
                loginBtnClicked();
                break;
            case R.id.registerBtn:
                registerBtnClicked();
                break;
        }
    }

    private void loginBtnClicked(){

        String kullanicininGirdigiUsername = usernameField.getText().toString();
        String kullanicininGirdigiPassword = passwordField.getText().toString();

        // İki string değerin birbirine eşitlik durumu kontrol edilirken
        // equals fonksiyonu kullanılmalıdır.
        // Yazım Kuralı : KONTROLEDİLMEKİSTENENSTRINGDEGER.equals(DIGERSTRINGDEGER);
        if(kullanicininGirdigiUsername.equals(uname)){
            if(kullanicininGirdigiPassword.equals(pass)){

                // Diğer sayfaya geçiş
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent); // diğer sayfayı başlat
                finish(); // Geri butonunun çalışmaması için tarihi sil.

            }else{
                showErrorDialog("Parolanız hatalı, tekrar deneyiniz.");
            }
        }else{
            showErrorDialog("Kullanıcı adınız yanlış veya daha önce kayıt olunmamış.");
        }

    }

    private void registerBtnClicked(){
        Intent intent = new Intent(MainActivity.this, DesignActivity.class);
        startActivity(intent);
    }

    private void showErrorDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hata");
        builder.setMessage(msg);
        builder.setPositiveButton("Tamam", null);
        builder.setNegativeButton("İptal", null);
        builder.show();
    }


}