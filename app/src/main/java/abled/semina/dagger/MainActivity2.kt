package abled.semina.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jakarta.inject.Inject

class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var numberRepository: NumberRepository

    @Inject
    lateinit var charRepository: CharRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        (applicationContext as MyApplication).repository?.inject(this)

        println(numberRepository.text)
        println(charRepository.text)
    }
}