package com.example.giso.tadm_listasensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listDatos;
    RecyclerView recycler;

    TextView textView = null;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        listDatos = new ArrayList<String>();
        sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        List<Sensor> lista = sensorManager.getSensorList(Sensor.TYPE_ALL);
        //StringBuilder data = new StringBuilder();
        listDatos = new ArrayList<String>();
        for(int i=1; i<lista.size(); i++){
            listDatos.add("Name: "+lista.get(i).getName()+
                    "\nVendor: "+lista.get(i).getVendor()+
                    "\nVersion: "+ lista.get(i).getVersion()+
                    "\nMax Range: "+ lista.get(i).getMaximumRange()+
                    "\nMin Delay: "+ lista.get(i).getMinDelay()+
                    "\nPower: "+ lista.get(i).getPower()
            );
        }

        AdapterDatos adapterDatos = new AdapterDatos(listDatos);
        recycler.setAdapter(adapterDatos);
    }
}
