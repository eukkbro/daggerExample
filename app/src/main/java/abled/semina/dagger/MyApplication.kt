package abled.semina.dagger

import android.app.Application

class MyApplication: Application() {

    var repository: Repository? = null

    override fun onCreate() {
        super.onCreate()
        repository = DaggerRepository.builder().build()
    }
}