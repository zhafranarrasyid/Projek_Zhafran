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
        MedicalRecord("15 Okt 2025", "Konsultasi Umum", "dr. Arif Rahman"),
        MedicalRecord("02 Sep 2025", "Pemeriksaan Rutin", "dr. Bima Putra"),
        MedicalRecord("18 Jul 2025", "Konsultasi Umum", "dr. Fajar Pratama")
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
