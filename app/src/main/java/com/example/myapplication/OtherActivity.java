package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends AppCompatActivity implements IElementClickListener {

    RecyclerView rv;

    List<DataModel> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initializeDatas();
        rv = findViewById(R.id.rv);

        DataAdapter adapter = new DataAdapter(this, datas, this);
        rv.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(manager);

    }

    private void initializeDatas(){
        datas.add(new DataModel("Fotoğraf Makinesi", "150.00 TL", getDrawable(R.drawable.tr)));
        datas.add(new DataModel("Video Kamera", "100.00 TL", getDrawable(R.drawable.tr)));
        datas.add(new DataModel("Dizüstü Bilgisayar", "500.00 TL", getDrawable(R.drawable.uk)));
        datas.add(new DataModel("Kahve Makinesi", "600.00 TL", getDrawable(R.drawable.uk)));
        datas.add(new DataModel("Süpürge", "250.00 TL", getDrawable(R.drawable.tr)));
    }

    @Override
    public void ElementClicked(int position) {
        DataModel model = this.datas.get(position);

        Log.d("MESAJ","Element clicked " + String.valueOf(model.GetName()));
    }
}