package com.example.focusapp2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.focusapp2.R
import com.example.focusapp2.data.entity.Secenekler
import com.example.focusapp2.databinding.FragmentSeceneklerBinding
import com.example.focusapp2.databinding.SecenekCardTasarimBinding
import com.example.focusapp2.ui.adapter.SeceneklerAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SeceneklerFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSeceneklerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSeceneklerBinding.inflate(inflater,container,false)
        binding.rv.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)


        val seceneklerListesi = ArrayList<Secenekler>()
        val s1 = Secenekler("Spor","baseline_sports_volleyball_24")
        val s2 = Secenekler("Meditasyon","m_24")
        val s3 = Secenekler("Okuma","b_24")
        val s4 = Secenekler("Zaman","t_24")
        val s5 = Secenekler("Üretkenlik","h_24")
        val s6 = Secenekler("Hedef","z_24")

        seceneklerListesi.add(s1)
        seceneklerListesi.add(s2)
        seceneklerListesi.add(s3)
        seceneklerListesi.add(s4)
        seceneklerListesi.add(s5)
        seceneklerListesi.add(s6)

        val seceneklerAdapter = SeceneklerAdapter(requireContext(),seceneklerListesi,this)
        binding.rv.adapter=seceneklerAdapter

        return binding.root

    }


}