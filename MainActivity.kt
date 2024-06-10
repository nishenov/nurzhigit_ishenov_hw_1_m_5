package com.example.nurzhigit_ishenov_hw_1_m_5

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nurzhigit_ishenov_hw_1_m_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private val countPresenter = CounterPresenter()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        countPresenter.attachView(this)

        with(binding) {
            btnPlus.setOnClickListener {
                countPresenter.onPlusClicked()
            }

            btnMinus.setOnClickListener {
                countPresenter.onMinusClicked()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(text: String) {
        Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
    }

    override fun setTextColorGreen() {
        binding.tvResult.setTextColor(Color.GREEN)
    }

    override fun setTextColorBlack() {
        binding.tvResult.setTextColor(Color.BLACK)
    }

    override fun onDestroy() {
        super.onDestroy()
        countPresenter.detachView()
    }
}