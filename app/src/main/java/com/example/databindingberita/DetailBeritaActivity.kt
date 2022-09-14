package com.example.databindingberita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail_berita.*

class DetailBeritaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        var getDetail = intent.getSerializableExtra("detail") as DataBerita
        imgDetail.setImageResource(getDetail.gambar)
        txtJudulDetail.text = getDetail.judul
        txtJurnalisDetail.text = getDetail.nama
        txtTglDetail.text = getDetail.tanggal
        txtIsi.text = getDetail.isi

    }
}