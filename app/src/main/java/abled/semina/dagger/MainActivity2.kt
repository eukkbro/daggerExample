package abled.semina.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import jakarta.inject.Inject

class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var numberRepository: NumberRepository

    @Inject
    lateinit var charRepository: CharRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // MainActivity2 지정
        //Module과 Component를 생성한뒤 프로젝트 Rebuild를 하면 Dagger+Component가 활성화 된다.
        //component 초기화
        DaggerRepositoryComponent.builder().build().inject(this)

        Log.d("TAG", "mainActivity2: ${numberRepository.text}")
        Log.d("TAG", "mainActivity2: ${charRepository.text}")
    }
}