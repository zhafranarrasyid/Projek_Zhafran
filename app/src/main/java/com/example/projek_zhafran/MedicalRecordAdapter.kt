package com.example.projek_zhafran

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.projek_zhafran.databinding.ItemMedicalRecordBinding

class MedicalRecordAdapter(
    context: Context,
    private val records: List<MedicalRecord>
) : ArrayAdapter<MedicalRecord>(context, 0, records) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMedicalRecordBinding
        val view: View

        if (convertView == null) {
            binding = ItemMedicalRecordBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemMedicalRecordBinding
        }

        val record = records[position]
        binding.tvDate.text = record.date
        binding.tvConsultationType.text = record.consultationType
        binding.tvDoctorName.text = record.doctorName

        return view
    }
}
