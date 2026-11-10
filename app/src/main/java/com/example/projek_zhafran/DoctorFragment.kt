package com.example.projek_zhafran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projek_zhafran.databinding.FragmentDoctorBinding
import com.google.android.material.chip.Chip

class DoctorFragment : Fragment() {
    private var _binding: FragmentDoctorBinding? = null
    private val binding get() = _binding!!

    private val allDoctors = listOf(
        Doctor("dr. Arif Rahman", "Dokter Umum", "https://i.pravatar.cc/150?img=11"),
        Doctor("dr. Bima Putra", "Spesialis Jantung", "https://i.pravatar.cc/150?img=53"),
        Doctor("dr. Fajar Pratama", "Spesialis Penyakit Dalam", "https://i.pravatar.cc/150?img=48"),
        Doctor("dr. Siti Rahma", "Spesialis Anak", "https://i.pravatar.cc/150?img=32"),
        Doctor("dr. Maya Putri", "Spesialis Kulit", "https://i.pravatar.cc/150?img=44")
    )

    private var currentList = allDoctors.toList()
    private lateinit var adapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DoctorAdapter(requireContext(), currentList)
        binding.listViewDoctors.adapter = adapter

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                val filterText = chip.text.toString()

                currentList = if (filterText == "Semua") {
                    allDoctors
                } else {
                    allDoctors.filter { it.specialization.equals(filterText, ignoreCase = true) }
                }

                adapter = DoctorAdapter(requireContext(), currentList)
                binding.listViewDoctors.adapter = adapter
                Toast.makeText(requireContext(), "Filter: $filterText", Toast.LENGTH_SHORT).show()
            }
        }

        binding.listViewDoctors.setOnItemClickListener { _, _, position, _ ->
            val doctor = currentList[position]
            Toast.makeText(requireContext(), "Memilih: ${doctor.name} (${doctor.specialization})", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
