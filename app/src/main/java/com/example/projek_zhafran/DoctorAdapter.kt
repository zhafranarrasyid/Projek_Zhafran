package com.example.projek_zhafran

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.projek_zhafran.databinding.ItemDoctorBinding

class DoctorAdapter(
    context: Context,
    private val doctors: List<Doctor>
) : ArrayAdapter<Doctor>(context, 0, doctors) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemDoctorBinding
        val view: View

        if (convertView == null) {
            binding = ItemDoctorBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemDoctorBinding
        }

        val doctor = doctors[position]
        binding.tvDoctorName.text = doctor.name
        binding.tvDoctorSpecialization.text = doctor.specialization

        Glide.with(context)
            .load(doctor.photoUrl)
            .circleCrop()
            .into(binding.imgDoctor)

        return view
    }
}
