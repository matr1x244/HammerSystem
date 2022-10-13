package com.example.hammersystem.domain

import com.example.hammersystem.data.web.FoodAPI
import com.example.hammersystem.data.web.RetrofitRequestImpl
import com.example.hammersystem.domain.model.RepositoryFood
import com.example.hammersystem.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModuleKoin = module {

    val apiUrl = "https://api.sampleapis.com/coffee/"
    single<RepositoryFood> { RetrofitRequestImpl(get()) }
    single<FoodAPI> { get<Retrofit>().create(FoodAPI::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .build()
    }

    factory<Converter.Factory> { GsonConverterFactory.create() }
    factory<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }

    viewModel { MainViewModel(get()) }
}