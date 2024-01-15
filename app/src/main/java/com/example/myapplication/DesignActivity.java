package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profileSettingsBtn:
                Log.d("MESAJ", "Profile ayarları seçildi");
                Toast.makeText(this, "Profil ayarları Seçildi", Toast.LENGTH_LONG).show();
                return true;
            case R.id.privacyContractBtn:
                Log.d("MESAJ", "Gizlilik seçildi");
                return true;
            case R.id.exitBtn:
                Log.d("MESAJ", "Çıkış seçildi");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}