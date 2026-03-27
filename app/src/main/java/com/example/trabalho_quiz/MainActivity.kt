package com.example.trabalho_quiz

import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaActionSound
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalho_quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var cliqueSom: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.botaoComecar.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate()
                        .scaleX(0.9f)
                        .scaleY(0.9f)
                        .setDuration(100)
                    false
                }

                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                    false
                }  else -> false
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun proximaPag(view: View){
        //código para animar o botão ao ser clicado
        view.animate()
            .scaleX(0.9f)
            .scaleY(0.9f)
            .setDuration(100)
            .withEndAction {
                view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(100)
            }
        /*Aqui eu usei a classe MediaPlayer para disparar o som do arquivo botaominecraftsom
        Verifiquei com if se ja estava tocando, para caso de clique duplo ele pausar e resetar o som*/
        cliqueSom = MediaPlayer.create(this, R.raw.botaominecraftsom)
        if (cliqueSom.isPlaying){
            cliqueSom.pause()
            cliqueSom.seekTo(0)
        }
        cliqueSom.start()
        //Aqui criei o Objeto i que vai ser o que vai levar para a próxima página
        val i = Intent(this, PrimeiraPergunta::class.java)
        startActivity(i)
    }
}