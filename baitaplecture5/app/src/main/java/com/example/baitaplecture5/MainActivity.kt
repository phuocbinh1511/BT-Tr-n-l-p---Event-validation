package com.example.baitaplecture5

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.baitaplecture5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDangKy.setOnClickListener {
            val hoTen = binding.edtHoTen.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val sdt = binding.edtSdt.text.toString().trim()
            val msv = binding.edtMsv.text.toString().trim()
            val lop = binding.edtLop.text.toString().trim()

            // Validation các trường
            if (hoTen.isEmpty()) {
                binding.edtHoTen.error = "Không được để trống"
                return@setOnClickListener
            }
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmail.error = "Email không hợp lệ"
                return@setOnClickListener
            }
            if (sdt.isEmpty() || sdt.length < 10) {
                binding.edtSdt.error = "SĐT phải từ 10 số"
                return@setOnClickListener
            }
            if (msv.isEmpty()) {
                binding.edtMsv.error = "Không được để trống MSV"
                return@setOnClickListener
            }
            if (lop.isEmpty()) {
                binding.edtLop.error = "Không được để trống Lớp"
                return@setOnClickListener
            }

            // Pass hết thì chuyển trang và truyền dữ liệu
            val intent = Intent(this, ChiTietActivity::class.java).apply {
                putExtra("HO_TEN", hoTen)
                putExtra("EMAIL", email)
                putExtra("SDT", sdt)
                putExtra("MSV", msv)
                putExtra("LOP", lop)
            }
            startActivity(intent)
        }

        // Nút chuyển trang đơn thuần
        binding.btnChuyenTrang.setOnClickListener {
            startActivity(Intent(this, ChiTietActivity::class.java))
        }
    }
}