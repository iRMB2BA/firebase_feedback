package com.example.firebasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firestore = Firebase.firestore

        findViewById<Button>(R.id.button).setOnClickListener {
            val comment = findViewById<EditText>(R.id.appCompatEditText).text?.toString()
            if (comment.isNullOrBlank()) {
                Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            firestore.collection("feedback")
                .add(hashMapOf(
                    "comment" to comment
                ))
                .addOnSuccessListener {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
        }
    }
}