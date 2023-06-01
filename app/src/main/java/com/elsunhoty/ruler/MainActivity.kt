package com.elsunhoty.ruler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.elsunhoty.rulerpicker.lib.RulerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewRuler: RulerView
    private lateinit var tvOnRulerValueChanges: TextView
    private lateinit var tvCurrentValue: TextView
    private lateinit var btnCurrentValue: Button
    private lateinit var btnScrollToPosition: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        actions()

    }

    private fun setupView() {
        viewRuler = findViewById(R.id.viewRuler)
        tvOnRulerValueChanges = findViewById(R.id.tvOnRulerValueChanges)
        tvCurrentValue = findViewById(R.id.tvCurrentValue)
        btnCurrentValue = findViewById(R.id.btnCurrentValue)
        btnScrollToPosition = findViewById(R.id.btnScrollToPosition)
    }

    private fun actions() {
        viewRuler.setOnRulerEvent { value, fromUser ->
            tvOnRulerValueChanges.text =
                "onRulerValueChanges : $value from user $fromUser"
        }
        btnCurrentValue.setOnClickListener { _ ->
            val currentValue = viewRuler.currentValue
            tvCurrentValue.text =
                "CurrentValue : $currentValue"
        }
        btnScrollToPosition.setOnClickListener { _ ->
            viewRuler.currentValue = 100
        }
    }

}