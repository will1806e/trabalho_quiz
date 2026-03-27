package com.example.trabalho_quiz

import android.os.Bundle
import android.content.Intent
import android.media.MediaPlayer
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalho_quiz.databinding.ActivityPrimeiraPerguntaBinding

class PrimeiraPergunta : AppCompatActivity() {


    lateinit var binding: ActivityPrimeiraPerguntaBinding

    // Pontuação pro fim do jogo

    var Score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primeira_pergunta)


        binding = ActivityPrimeiraPerguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun RespostaCorreta(view: View) {
        val mp = MediaPlayer.create(this, R.raw.acertouuu)
        mp.start()

        mp.setOnCompletionListener {
            it.release()
        }

        Score += 1

        val ir = Intent(this, SegundaPergunta::class.java)

        ir.putExtra("SCORE", Score)

        startActivity(ir)

    }

    fun RespostaErrada(view: View) {
        val mp2 = MediaPlayer.create(this, R.raw.risos)
        mp2.start()

        mp2.setOnCompletionListener {
            it.release()
        }

        val ir = Intent(this, SegundaPergunta::class.java)

        ir.putExtra("SCORE", Score)

        startActivity(ir)
    }
}