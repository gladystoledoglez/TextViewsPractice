package com.example.textviewspractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.textviewspractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCount.text = savedInstanceState?.getString(KEY_TEXT)

        var count = 1
        binding.btnPlusOne.setOnClickListener {
            binding.tvCount.text = count.toString()
            count++
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val text = binding.tvCount.text.toString()
        outState.putString(KEY_TEXT, text)
    }

    companion object {
        const val KEY_TEXT = "KEY_TEXT"
    }
}