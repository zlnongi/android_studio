package com.example.randomnickname

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.ClipboardManager
import android.content.ClipData
import android.content.Context
import android.widget.Toast
import com.example.nickname.R

class MainActivity : AppCompatActivity() {

    private lateinit var nicknameTextView: TextView
    private lateinit var generateButton: Button
    private lateinit var copyButton: Button

    // 닉네임 구성요소
    private val adjectives = listOf(
        "귀여운", "멋진", "용감한", "즐거운", "행복한", "신비한", "똑똑한",
        "친절한", "재미있는", "활발한", "상냥한", "당당한", "엉뚱한", "소심한"
    )

    private val nouns = listOf(
        "고양이", "강아지", "토끼", "판다", "여우", "늑대", "호랑이",
        "사자", "기린", "코끼리", "펭귄", "돌고래", "햄스터", "곰"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 초기화
        nicknameTextView = findViewById(R.id.nicknameTextView)
        generateButton = findViewById(R.id.generateButton)
        copyButton = findViewById(R.id.copyButton)

        // 닉네임 생성 버튼 클릭 리스너
        generateButton.setOnClickListener {
            val nickname = generateNickname()
            nicknameTextView.text = nickname
        }

        // 복사하기 버튼 클릭 리스너
        copyButton.setOnClickListener {
            copyToClipboard(nicknameTextView.text.toString())
        }
    }

    // 랜덤 닉네임 생성 함수
    private fun generateNickname(): String {
        val randomAdjective = adjectives.random()
        val randomNoun = nouns.random()
        val randomNumber = (100..999).random()
        return "$randomAdjective $randomNoun $randomNumber"
    }

    // 클립보드에 복사하는 함수
    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("nickname", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, "클립보드에 복사되었습니다!", Toast.LENGTH_SHORT).show()
    }
}