package com.example.projek_zhafran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projek_zhafran.databinding.FragmentDoctorBinding

class DoctorFragment : Fragment() {
    private var _binding: FragmentDoctorBinding? = null
    private val binding get() = _binding!!

    private val doctorList = listOf(
        Doctor("dr. Andi Pratama", "Dokter Umum", "https://i.pravatar.cc/150?img=11"),
        Doctor("dr. Siti Rahma", "Spesialis Anak", "https://i.pravatar.cc/150?img=32"),
        Doctor("dr. Budi Santoso", "Spesialis Jantung", "https://i.pravatar.cc/150?img=53"),
        Doctor("dr. Maya Putri", "Spesialis Kulit", "https://i.pravatar.cc/150?img=44"),
        Doctor("dr. Rina Amelia", "Spesialis Penyakit Dalam", "https://i.pravatar.cc/150?img=48")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DoctorAdapter(requireContext(), doctorList)
        binding.listViewDoctors.adapter = adapter

        binding.listViewDoctors.setOnItemClickListener { _, _, position, _ ->
            val doctor = doctorList[position]
            Toast.makeText(requireContext(), "Memilih: ${doctor.name} (${doctor.specialization})", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
