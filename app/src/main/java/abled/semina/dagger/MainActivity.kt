package abled.semina.dagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.Component
import dagger.Module
import dagger.Provides
import jakarta.inject.Inject
import java.util.Random

class MainActivity : AppCompatActivity() {

    //주입 대상 지정
    @Inject
    lateinit var numberRepository: NumberRepository

    @Inject
    lateinit var charRepository: CharRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MainActivity 지정
        //Module과 Component를 생성한뒤 프로젝트 Rebuild를 하면 Dagger+Component가 활성화 된다.
        //component 초기화
        DaggerRepositoryComponent.builder().build().inject(this)

        //출력
        Log.d("TAG", "mainActivity: ${numberRepository.text}")
        Log.d("TAG", "mainActivity: ${charRepository.text}")


        //Main2로 이동
        startActivity(Intent(this,MainActivity2::class.java))

    }
}


// Module을 연결하고, 주입할 위치를 지정하는 곳
@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun inject (app: MainActivity)
    fun inject (app: MainActivity2)
}


// 주입할 의존성을 셋팅하는 곳
@Module
class RepositoryModule{

    @Provides
    fun provideNumberRepository(): NumberRepository = NumberRepository()

    @Provides
    fun provideCharRepository(): CharRepository = CharRepository()

}

//랜덤한 숫자를 text 변수에 갖고있는 클래스
class NumberRepository {
        var text = run{ Random().nextInt(100).toString()}
}

//class NumberRepository @Inject constructor(){}

//랜덤한 문자를 text 변수에 갖고 있는 클래스
class CharRepository {
        var text = run{ Random().nextInt(100).toChar().toString()}
}