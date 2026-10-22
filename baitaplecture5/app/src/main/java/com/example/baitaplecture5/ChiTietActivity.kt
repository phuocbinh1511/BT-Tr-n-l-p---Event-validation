package com.example.baitaplecture5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baitaplecture5.databinding.ActivityChiTietBinding

class ChiTietActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận dữ liệu
        val hoTen = intent.getStringExtra("HO_TEN") ?: "Chưa có dữ liệu"
        val email = intent.getStringExtra("EMAIL") ?: ""
        val sdt = intent.getStringExtra("SDT") ?: ""
        val msv = intent.getStringExtra("MSV") ?: ""
        val lop = intent.getStringExtra("LOP") ?: ""

        val thongTin = """
            Họ tên: $hoTen
            Email: $email
            SĐT: $sdt
            MSV: $msv
            Lớp: $lop
        """.trimIndent()

        binding.tvThongTin.text = thongTin

        // Nút chuyển lại trang Đăng ký
        binding.btnQuayLai.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Tránh tạo nhiều activity xếp chồng
            startActivity(intent)
        }
    }
}