package com.enes.krypto.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.enes.krypto.R;
import com.enes.krypto.adaptir.adaptir;
import com.enes.krypto.model.cryptomodel;
import com.enes.krypto.service.cryptoApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

ArrayList<cryptomodel> cryptomodels;
private String base_url = "https://api.nomics.com/v1/";
Retrofit retrofit;
private RecyclerView recyclerView;
private adaptir adaptir;

    CompositeDisposable compositeDisposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Gson gson =new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder().baseUrl(base_url).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();


            loadData();


    }
    private  void loadData(){
        cryptoApi cryptoApi = retrofit.create(cryptoApi.class);

        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(cryptoApi.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::hadlerpesonsible));


    }
    private void hadlerpesonsible(List<cryptomodel> cryptomodelList){
        cryptomodels = new ArrayList<>(cryptomodelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adaptir = new adaptir(cryptomodels);
        recyclerView.setAdapter(adaptir);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();

    }
}