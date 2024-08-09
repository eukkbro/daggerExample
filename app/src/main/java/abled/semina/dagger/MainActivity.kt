package abled.semina.dagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import jakarta.inject.Inject
import java.util.Random

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var numberRepository: NumberRepository

//    @Inject
//    lateinit var charRepository: CharRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MyApplication).repository?.inject(this)

        println(numberRepository.text)

        startActivity(Intent(this,MainActivity2::class.java))

    }
}


@Component(modules = arrayOf(RepositoryModule::class))
interface Repository {
    fun inject (app: MainActivity)
//    fun inject (app: MainActivity2)
}


@Module
object RepositoryModule{

    @Provides
    fun provideNumberRepository(): NumberRepository = NumberRepository()

    @Provides
    fun provideCharRepository(): CharRepository = CharRepository()

}

class NumberRepository {
        var text = run{ Random().nextInt(100).toString()}
}

class CharRepository {
        var text = run{ Random().nextInt(100).toChar().toString()}
}