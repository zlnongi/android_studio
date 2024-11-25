package com.autoever.matchingapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.matchingapp.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener() {
            if (editText1.text.isEmpty()) || editText2.text.isEmpty()) {
                return@setOnClickListner

            } else {

                }
            // User1 이름 첫 글자 가져오기
            val char1: Char = editText1.text.toString()[0]
            val char2: Char = editText2.text.toString()[0]

            // 유니코드 번호로 변환
            val int1: Int = char1.code
            val int2: Int = char2.code

            val percentage = (int1 + int2) % 100

            Log.d("MainActivity","매칭 확률은 $percentage% 입니다")

            showDefaultDialog(editText1.text.toString(),
                editText2.text.toString(),   percentage)
        }
    }

    fun showDefaultDialog(user1: String, user2: String, percentage : Int){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("커플 매칭 확률")
        builder.setMessage("$user1%와 $user2% 님의 매칭확률은 $percentage% 입니다.")
        builder.setPositiveButton("OK") {
                dialog, _ -> dialog.dismiss()
        }
        var dialog = builder.create()
        dialog.show()

    }
}