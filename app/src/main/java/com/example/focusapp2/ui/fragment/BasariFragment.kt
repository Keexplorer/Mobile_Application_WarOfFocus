package com.example.focusapp2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.focusapp2.R
import com.example.focusapp2.data.entity.Basari
import com.example.focusapp2.ui.adapter.BasariAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BasariFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasariFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BasariAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basari, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerBasarilar)

        val sampleData = listOf(
            Basari("İlk Görevi Tamamla", "İlk görevini başarıyla tamamladın!", R.drawable.cheer),
            Basari("Profilini Doldur", "Profilini %100 tamamladın.", R.drawable.cheer),
            Basari("İlk Mesaj", "İlk mesajını gönderdin.", R.drawable.cheer),
            Basari("Giriş Serisi", "3 gün üst üste giriş yaptın!", R.drawable.cheer),
            Basari("İlk Odaklanma", "Bir odaklanma seansı tamamladın.", R.drawable.cheer),
            Basari("5 Görev Tamamla", "5 farklı görevi başarıyla bitirdin.", R.drawable.cheer),
            Basari("Arkadaşını Davet Et", "Bir arkadaşını uygulamaya davet ettin.", R.drawable.cheer),
            Basari("Avatar Oluştur", "Avatarını ilk kez özelleştirdin.", R.drawable.cheer),
            Basari("Hedef Belirle", "Kendine bir gelişim hedefi koydun.", R.drawable.cheer),
            Basari("İlk Başarı", "İlk rozetini kazandın.", R.drawable.cheer),
            Basari("Sabah Erken Kalk", "Sabah 7’den önce giriş yaptın.", R.drawable.cheer),
            Basari("Motivasyon Oku", "Bir motivasyon yazısı okudun.", R.drawable.cheer),
            Basari("Günlük Tamamla", "Bir günlüğü başarıyla doldurdun.", R.drawable.cheer),
            Basari("Topluluğa Katıl", "Topluluk forumuna ilk mesajını attın.", R.drawable.cheer),
            Basari("Favori Belirle", "Bir görevi favorilerine ekledin.", R.drawable.cheer),
            Basari("Yorum Yap", "İlk yorumunu bıraktın.", R.drawable.cheer),
            Basari("7 Günlük Seri", "7 gün boyunca aralıksız giriş yaptın!", R.drawable.cheer),
            Basari("Öz Disiplin", "Günlük görevlerini 5 gün üst üste tamamladın.", R.drawable.cheer),
            Basari("Zihinsel Güç", "Meditasyon görevini tamamladın.", R.drawable.cheer),
            Basari("Yıldız Oyuncu", "Tüm başarıların %50’sini topladın!", R.drawable.cheer)
        )


        adapter = BasariAdapter(sampleData)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}
