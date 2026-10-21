package com.example.projek_zhafran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projek_zhafran.databinding.FragmentMedicalRecordBinding

class MedicalRecordFragment : Fragment() {
    private var _binding: FragmentMedicalRecordBinding? = null
    private val binding get() = _binding!!

    private val recordList = listOf(
        MedicalRecord("12 Oktober 2026", "Konsultasi Dokter Umum", "dr. Andi Pratama"),
        MedicalRecord("14 Oktober 2026", "Konsultasi Spesialis Anak", "dr. Siti Rahma"),
        MedicalRecord("16 Oktober 2026", "Pemeriksaan Kesehatan", "dr. Budi Santoso"),
        MedicalRecord("18 Oktober 2026", "Konsultasi Spesialis Kulit", "dr. Maya Putri")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicalRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MedicalRecordAdapter(requireContext(), recordList)
        binding.listViewMedicalRecords.adapter = adapter

        binding.listViewMedicalRecords.setOnItemClickListener { _, _, position, _ ->
            val record = recordList[position]
            Toast.makeText(requireContext(), "Rekam Medis: ${record.consultationType} oleh ${record.doctorName}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
