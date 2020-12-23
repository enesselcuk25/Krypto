package com.enes.krypto.service;

import androidx.lifecycle.Observer;

import com.enes.krypto.model.cryptomodel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface cryptoApi {

    @GET("prices?key=c9fff85cc8efc97fad8079550df70b2c")

    Observable<List<cryptomodel>> getData();




}
