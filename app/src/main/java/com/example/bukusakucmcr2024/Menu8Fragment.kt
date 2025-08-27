package com.example.bapekom6surabaya

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DasarHukumFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Menu8Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.menu8_option1, container, false)

        val imageViewGif1 = view.findViewById<ImageView>(R.id.imageViewGif7_1)
        val imageViewGif2 = view.findViewById<ImageView>(R.id.imageViewGif7_2)
        val imageViewGif3 = view.findViewById<ImageView>(R.id.imageViewGif7_3)
        val imageViewGif4 = view.findViewById<ImageView>(R.id.imageViewGif7_4)
        val imageViewGif5 = view.findViewById<ImageView>(R.id.imageViewGif7_5)

        Glide.with(this)
            .asGif()
            .load(R.drawable.kereta) // Ganti dengan GIF pertama
            .into(imageViewGif1)

// Memuat GIF kedua
        Glide.with(this)
            .asGif()
            .load(R.drawable.kereta) // Ganti dengan GIF kedua
            .into(imageViewGif2)

        Glide.with(this)
            .asGif()
            .load(R.drawable.kereta) // Ganti dengan GIF kedua
            .into(imageViewGif3)

        Glide.with(this)
            .asGif()
            .load(R.drawable.kereta) // Ganti dengan GIF kedua
            .into(imageViewGif4)

        Glide.with(this)
            .asGif()
            .load(R.drawable.kereta) // Ganti dengan GIF kedua
            .into(imageViewGif5)

        val buttons = listOf(
            view.findViewById<Button>(R.id.button1),
            view.findViewById<Button>(R.id.button2),
            view.findViewById<Button>(R.id.button3),
            view.findViewById<Button>(R.id.button4)
        )

        val colorAnimator = ValueAnimator.ofObject(
            ArgbEvaluator(),
            Color.parseColor("#20326A"), // Warna Biru (#20326A)
            Color.parseColor("#F9A01B"), // Warna Kuning (#F9A01B)

        )

        colorAnimator.duration = 2000 // Durasi animasi (2 detik)
        colorAnimator.repeatCount = ValueAnimator.INFINITE // Animasi berulang
        colorAnimator.repeatMode = ValueAnimator.REVERSE

        // Update warna background untuk semua tombol
        colorAnimator.addUpdateListener { animator ->
            val animatedValue = animator.animatedValue as Int
            buttons.forEach { button ->
                button.setBackgroundColor(animatedValue)

                val isOrange = animatedValue == Color.parseColor("#F9A01B")
                if (isOrange) {
                    button.setTextColor(Color.parseColor("#000000")) // Hitam
                } else {
                    button.setTextColor(Color.parseColor("#FFFFFF")) // Putih
                }
            }
        }
        colorAnimator.start() // Mulai animasi

        // Menambahkan listener klik untuk membuka URL
        buttons[0].setOnClickListener {
            val uri = Uri.parse("https://bit.ly/3ZnZHTv")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        buttons[1].setOnClickListener {
            val uri = Uri.parse("https://bit.ly/3DedlRq")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        buttons[2].setOnClickListener {
            val uri = Uri.parse("https://bit.ly/465sQrD")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        buttons[3].setOnClickListener {
            val uri = Uri.parse("https://bit.ly/49s4eZJ")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Menu1Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Menu7Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}