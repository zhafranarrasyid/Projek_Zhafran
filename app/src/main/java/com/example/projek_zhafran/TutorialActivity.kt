package com.example.projek_zhafran

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.projek_zhafran.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )

        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialViewPager)

        binding.tutorialViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == fragmentsList.size - 1) {
                    binding.btnNext.text = "Mulai Sekarang"
                } else {
                    binding.btnNext.text = "Lanjut"
                }
            }
        })

        binding.btnNext.setOnClickListener {
            val currentItem = binding.tutorialViewPager.currentItem
            if (currentItem < fragmentsList.size - 1) {
                binding.tutorialViewPager.currentItem = currentItem + 1
            } else {
                finishTutorial()
            }
        }
    }

    private fun finishTutorial() {
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("hasSeenTutorial", true)
        editor.apply()

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
