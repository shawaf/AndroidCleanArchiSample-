package com.elshawaf.androidcleanarchsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elshawaf.androidcleanarchsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar?.title="Authors"
    }
}