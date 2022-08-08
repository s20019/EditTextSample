package com.example.edittextsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextWatcher
import android.widget.EditText
import com.example.edittextsample.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity(){
    
    private lateinit var binding: ActivityMainBinding

    var countDownMilli = binding.editTextNumber.text.toString().toLong()
    val countDownInterval: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val timer = object : CountDownTimer(countDownMilli, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val second = ceil(millisUntilFinished / 1000.0).toInt()
                binding.countText.text = second.toString()
            }

            override fun onFinish() {
                binding.start.isEnabled = true
            }
        }

        binding.start.setOnClickListener {
            binding.start.isEnabled = false
            binding.countText.text = "$countDownMilli"
            timer.start()
        }
    }
}