package com.example.databindingberita


import java.io.Serializable


data class DataBerita(val judul : String, val tanggal : String, val nama : String, val gambar : Int, val isi : String) : Serializable
