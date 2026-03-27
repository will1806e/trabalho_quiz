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

        // Declarando as Variáveis dos botoes aq

        val Btn1 = findViewById<ImageButton>(R.id.Btn1)
        val Btn2 = findViewById<ImageButton>(R.id.Btn2)
        val Btn3 = findViewById<ImageButton>(R.id.Btn3)
        val Btn4 = findViewById<ImageButton>(R.id.Btn4)

        // Função pra proxima pagina, tive que criar aqui, quando tava la em baixo não tava puxando ;-;
        fun IrParaProximaPergunta() {

            val ir = Intent(this, SegundaPergunta::class.java)
            startActivity(ir)

        }

        // Respota certa, vai aumentar 1 ponto e passar para proxima pergunta
        Btn1.setOnClickListener {


            Score += 1

            // O somzinho de Xp para acertar
            val mp = MediaPlayer.create(this, R.raw.acertouuu)
            mp.start()

            mp.setOnCompletionListener {
                it.release()
            }
            IrParaProximaPergunta()

        }
        // Resposta errada só vai puxar para proxima pergunta e tocar o som de erro
        Btn2.setOnClickListener {
            val mp2 = MediaPlayer.create(this, R.raw.risos)
            mp2.start()

            mp2.setOnCompletionListener {
                it.release()
            }
            IrParaProximaPergunta()


        }
        Btn3.setOnClickListener {
            val mp2 = MediaPlayer.create(this, R.raw.risos)
            mp2.start()

            mp2.setOnCompletionListener {
                it.release()
            }

            IrParaProximaPergunta()


        }
        Btn4.setOnClickListener {
            val mp2 = MediaPlayer.create(this, R.raw.risos)
            mp2.start()

            mp2.setOnCompletionListener {
                it.release()
            }

            IrParaProximaPergunta()


        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}