package com.example.characterapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButton = findViewById<RadioButton>(R.id.radioButton)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val button = findViewById<Button>(R.id.button)

        // 첫 번째 라디오 초기값 설정
        radioButton.isChecked = true

        var character: String = ""

        // 라디오 버튼 클릭에 따라 이미지 변경
        radioGroup.setOnCheckedChangeListener{ _, checkedId ->
            when (checkedId) {
                R.id.radioButton -> {
                    imageView.setImageResource(R.drawable.chi) // 첫 번째 캐릭터로 변경
                    character = radioButton.text.toString()
                }
                R.id.radioButton2 -> {
                    imageView.setImageResource(R.drawable.ha) // 두 번째 캐릭터로 변경
                    character = radioButton.text.toString()
                }
            }

        }

        // 버튼 클릭됐을 때 동작
        button.setOnClickListener{
            if (checkBox.isChecked) {
                showBasicAlert(character)

            } else {
                Toast.makeText(applicationContext, "이용약관에 동의해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun showBasicAlert(character: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("캐릭터 생성 완료")
        builder.setMessage("${character}가 생성되었습니다.")
        // 확인 버튼
        builder.setPositiveButton("완료") {dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}