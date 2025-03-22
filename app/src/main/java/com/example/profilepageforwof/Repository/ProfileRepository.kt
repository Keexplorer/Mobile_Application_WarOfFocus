package com.example.profilepageforwof.Repository

import com.example.profilepageforwof.Domain.ContentDomain

class ProfileRepository {
    val contentItems: MutableList<ContentDomain> = mutableListOf(
        ContentDomain("5 Boss kestin"),
        ContentDomain("10 gündür giriş yapıyorsun"),
        ContentDomain("25. Levele ulaştın"),
        ContentDomain("Örnek")
    )
    val statsItem: MutableList<ContentDomain> = mutableListOf(
        ContentDomain("Zekasal Odaklanma "),
        ContentDomain("Spor Odaklanma "),
        ContentDomain(" Odaklanma ")
    )
    val  categoryItems: MutableList<String> = mutableListOf(
        "Başarımlarım",
        "İstatistiklerim",
        "Avatarım"
    )
}