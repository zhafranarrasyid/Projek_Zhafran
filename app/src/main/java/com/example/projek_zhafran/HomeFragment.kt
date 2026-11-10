package com.example.projek_zhafran

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.projek_zhafran.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Dinda")
        binding.tvUsername.text = "Halo, $username"

        // Load recommended doctor avatar
        Glide.with(this)
            .load("https://i.pravatar.cc/150?img=11")
            .circleCrop()
            .into(binding.imgRecDoc)

        binding.btnDetail.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }

        binding.btnMulaiKonsultasi.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }

        binding.btnWebView.setOnClickListener {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(
                binding.root,
                "💡 Tips SehatKu: Jaga kesehatan dengan minum air putih cukup & istirahat teratur.",
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction("Mengerti") {
                    Log.e("Info Snackbar", "Tips kesehatan ditutup oleh pengguna")
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
