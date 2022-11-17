package com.monte.carlo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.monte.carlo.databinding.ActivityEndBinding

class EndActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView4.text = "Дано правильных ответов ${intent.getStringExtra("count")}/7"
        binding.button3.setOnClickListener {
            startActivity(Intent(applicationContext,ActivityGame::class.java))
            finish()
        }
    }
}