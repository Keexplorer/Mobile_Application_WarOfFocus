package com.example.focusapp2.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.focusapp2.R
import com.example.focusapp2.data.entity.Secenekler
import com.example.focusapp2.databinding.SecenekCardTasarimBinding
import com.example.focusapp2.ui.fragment.SeceneklerFragment

class SeceneklerAdapter(var mContext: Context,var seceneklerListesi:List<Secenekler>,val fragment: androidx.fragment.app.Fragment,):RecyclerView.Adapter<SeceneklerAdapter.CardTasarimHolder>() {

    inner class CardTasarimHolder(var design: SecenekCardTasarimBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
            val binding = SecenekCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
            return CardTasarimHolder(binding)

        }

    override fun getItemCount(): Int {
        return seceneklerListesi.size

    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val secenek = seceneklerListesi.get(position)

        val t = holder.design

        t.textView.setText(secenek.isim)
        t.imageView3.setImageResource(mContext.resources.getIdentifier(secenek.resim,"drawable",mContext.packageName))

        t.secenekCard.setOnClickListener(){
            //BURA düzeltilecek
            val navController = fragment.findNavController()  // Fragment üzerinden NavController al
            navController.navigate(R.id.gecisFocus)

        }



    }
//

}