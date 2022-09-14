package com.example.databindingberita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingberita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BeritaAdapter.ItemClickListener {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val list = arrayListOf(
            DataBerita("Perdi Sambung Ayam", "10 September 2020", "Paijo",R.drawable.ferdisambu,"Bripka Ricky Rizal (Bripka RR) memutuskan tak lagi mengikuti skenario mantan Kadiv Propam Polri, Irjen Ferdy Sambo, terkait kasus pembunuhan berencana Brigadir Joshua Hutabarat (Brigadir J).Mengikuti jejak Bharada Richard Eliezer (Bharada E), Bripka RR mulai membongkar satu per satu fakta yang diketahuinya terkait pembunuhan Brigadir J.Lewat kuasa hukumnya, Erman Umar, Bripka RR membeberkan kejadian di Magelang, Jawa Tengah.Ia juga mengungkapkan adanya janji dari Ferdy Sambo soal uang sebagai bentuk ucapan terima kasih."),
            DataBerita("Demo Tolak Kenaikan Harga BBM", "13 September 2022", "Boim",R.drawable.demobbm,"TRIBUNNEWS.COM, JAKARTA - Demo tolak kenaikan harga Bahan Bakar Minyak (BBM) masihberlangsung, Selasa (13/9/2022) malam.Aksi massa yang tergabung dalam sejumlah elemen mahasiswa ini kembali memanas.Massa mulai menyalakan kembang api dan melempar benda-benda keras ke arah barisan pengamanan polisi."),
            DataBerita("Asal-usul Hacker Bjorkar", "13 September 2002", "Arif Tio Buqi Abdulah",R.drawable.bjorka,"Hacker Bjorka masih menjadi perbincangan publik lantaran sepak terjangnya yang meretas dan membocorkan data sejumlah pejabat.Meski akun media sosialnya kerap ditangguhkan, namun Bjorka seringkali kembali muncul dengan akun baru.Beberapa akun milik Bjorka yang telah ditangguhkan, di antaranya yakni @bjorkanism, @bjorxanism, kemudian kini muncul dengan @bjorkanesian."),
            DataBerita("Cerita Perempuan Berkuku Panjang", "13 September 2022", "Sarwan",R.drawable.kukupanjang,"Inilah cerita perempuan di Kota Yogyakarta yang mempunyai kuku panjang hingga belasan centimeter. Perempuan bernama Dewi Setiyowati ini memiliki kuku panjang sampai 15 Cm.Beberapa waktu lalu, ia mengunggah video di akun TikToknya @dewiyahya_79 yang memperlihatkan dirinya tengah makan di sebuah restoran padang.Dalam video itu, Dewi menunjukkan caranya mengambil nasi menggunakan kuku panjangnya dan dimasukkan ke mulut.Sontak, video tersebut menarik perhatian publik hingga viral, dilihat puluhan juta kali."),
            DataBerita("Evos Memenangkan Kejuaraan Dunia M1 Series", "18 November 2019", "Doni",R.drawable.evos,"Suara.com - Indonesia yang diwakili oleh tim esports Evos Legends berhasil merengkuh gelar juara dunia Mobile Legends M1 World Championship yang berlangsung di Axiata Arena, Kuala Lumpur, Malaysia, Minggu (18/11/2019). Evos menjadi juara setelah menumbangkan tim esports Indonesia lainnya yakni Req Regum Qeon (RRQ) dengan skor tipis 4-3 pada partai grandfinal best of seven (bo7). Hal ini pun membuktikan kekuatan Merah Putih dalam sebuah turnamen Mobile Legends Bang Bang."),
            DataBerita("GPX Farewell Hans4You, Segera Comeback ke AURA", "13 September 2022", "Dandesignlab",R.drawable.gpxhanz4you, "Setelah membela tim di PMPL ID Fall 2022 bersama dengan Rosemary cs, Hans4You resmi meninggalkan GPX dan akan segera kembali ke AURA Esports seusai kontrak pinjamannya berakhir. Hans4You sebelumnya telah membela tim GPX di PMPL bersama dengan Rosemary cs yang tercatat memberikan performa signifikan di liga hingga akhirnya mereka finis di urutan ke-5 finals."),
            DataBerita("FIFA Mobile CEW - Series 5 Digelar di Bandung", "13 September 2022", "Billy Rifki",R.drawable.fifa,"Electronic Arts mengungkap acara komunitas EA SPORTS FIFA Mobile selanjutnya, yakni pada tanggal 24 September 2022, dimana Kota Bandung akan menjadi tujuan FIFA Mobile Community Exhibition Weekend (CEW) - Series 5, dengan venue di Laswee Creative Space. Mengusung tema “Merayakan Bandung, Merayakan Sepak Bola”, acara komunitas EA SPORTS FIFA Mobile kali ini sekaligus diadakan sebagai perayaan ulang tahun ke-212 dari Kota Kembang."),
            DataBerita("VOIN Umumkan Perpisahan Dengan Viraa", "13 September 2022", "Dandesignlab",R.drawable.voinvira,"Viraa belum diketahui akan segera berpindah ke tim mana selanjutnya. Kemungkinan ia akan menjadi free agent dalam waktu sementara atau telah terdapat tim yang menjalin kesepakatan dengannya jelang musim mendatang. Sangat disayangkan Viraa harus pergi disaat yang cukup krusial menjelang FFIM 2022 Fall. Kini, VOIN memiliki satu slot kosong yang perlu diisi untuk dapat bersaing di quarter finals."),
            DataBerita("AE Terbantai 10-0 Lawan GEEK, Efek Takabur?", "13 September 2022", "Dandesignlab",R.drawable.aeterbantai,"GEEK FAM telah berhasil menumbangkan Alter Ego Esports pada 10 September 2022 kemarin dengan skor bersih 2-0 atas penampilan match yang memukau dari Caderaa cs. Setelah kalah berkali-kali dan tersesat di dasar klasemen, GEEK dapat menemukan asa nya kembali untuk menambahkan poin mereka di pekan kelima berkat kemenangan tersebut."),
            DataBerita("RRQ Hoshi Terpuruk, Pak AP Komitmen Lolos M4!", "13 September 2022", "Dandesignlab",R.drawable.pakap,"MPL ID S10 semakin menghadirkan banyak kejutan pada regular season dimana para tim kuda hitam berhasil menunjukkan titik kebangkitannya dan mengalahkan beberapa tim jawara di papan klasemen. RRQ Hoshi yang dikenal sebagai juara bertahan dan tim paling tersohor di kancah Mobile Legends Indonesia kini tengah mengalami penurunan perform dalam beberapa pekan terakhir. "),
            DataBerita("Patahkan Kutukan Losestreak, Saatnya BTR Bangkit di MPL?", "13 September 2022", "Dandesignlab",R.drawable.btr,"Pada hari kedua pekan kelima MPL ID S10, Bigetron Alpha berhasil untuk mendapatkan kembali kemenangan mereka yang sempat hilang berturut-turut di regular season. Struggle yang mereka hadapi musim ini tampaknya semakin besar mengetahui performa mereka yang tersaingi oleh tim lain seperti GEEK, Rebellion, dan Alter Ego Esports. "),
        )




        binding.rvBerita.adapter = BeritaAdapter(list,this)
        binding.rvBerita.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)



//        adapterBerita.onClick = {
//            val pindah = Intent(this,DetailBeritaActivity::class.java)
//            pindah.putExtra("detailberita",it)
//            startActivity(pindah)
//        }


    }
    override fun onItemClicked(detail: DataBerita){
        var pindah = Intent(this, DetailBeritaActivity::class.java)
        pindah.putExtra("detail",detail)
        startActivity(pindah)

    }
}