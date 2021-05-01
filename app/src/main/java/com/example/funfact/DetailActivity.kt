package com.example.funfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funfact.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var binding: ActivityDetailBinding? = null
    private var logo = 0
    private var name: String? = ""
    private var detail: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        logo = intent.getIntExtra(FactAdapter.LOGO_EXTRAS, 0)
        name = intent.getStringExtra(FactAdapter.NAME_EXTRAS)
        detail = intent.getStringExtra(FactAdapter.FACT_EXTRAS)
        setupFactDetail()
    }

    private fun setupFactDetail() {
        binding?.textDetail?.text = detail
        binding?.imageLogo?.setImageResource(logo)
        title = name
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}