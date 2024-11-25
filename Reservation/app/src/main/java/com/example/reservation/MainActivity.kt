package com.example.reservation

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    var gender: String = ""
    var date: String = ""
    var name: String = ""
    var memo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 초기화
        val editTextName = findViewById<EditText>(R.id.editTextMemo)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val buttonDate = findViewById<Button>(R.id.buttonDate)
        val editTextMemo = findViewById<EditText>(R.id.editTextMemo)
        val buttonBook = findViewById<Button>(R.id.buttonBook)

        // 스피너에 나타낼 지점 목록
        val genderlist = listOf(
            "여자", "남자"
        )

        // 스피너 어댑터 설정
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderlist)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        // 선택 이벤트 처리
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                gender = p0!!.getItemAtPosition(p2).toString()
                Toast.makeText(applicationContext, gender, Toast.LENGTH_LONG).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        // 날짜 선택
        buttonDate.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)

            // DatePickerDialog 설정
            val datePickerDialog =
                DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                    // 선택한 날짜를 버튼에 표시
                    date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    buttonDate.text = date
                }, year, month, day)

            // 다이얼로그 표시
            datePickerDialog.show()
        }

        buttonBook.setOnClickListener{
            name = editTextName.text.toString()
            memo = editTextMemo.text.toString()
            AlertDialog.Builder(this)
                .setTitle("alert입니다")
                .setMessage("이름은 $name, 성별은 $gender, 날짜는 $date 입니다. 각오는 $memo 입니다.")
                .setPositiveButton("확인"){dialog, _ -> dialog.dismiss()}
                .create()
                .show()
        }


    }

}
