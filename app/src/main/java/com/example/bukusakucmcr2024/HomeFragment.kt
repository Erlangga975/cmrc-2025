package com.example.bapekom6surabaya

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.app.AlertDialog
import android.view.ScaleGestureDetector
import android.widget.ImageView
import android.widget.LinearLayout



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var imageView: ImageView
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1f

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
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        imageView = view.findViewById(R.id.fotodiklat)
        scaleGestureDetector = ScaleGestureDetector(requireContext(), ScaleListener())

        val imageContainer: LinearLayout = view.findViewById(R.id.imageContainer)

        // Menambahkan onClickListener untuk memperbesar gambar
        imageContainer.setOnClickListener {
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_zoom_image, null)

            // Set gambar ke ImageView dalam dialog
            val dialogImage = dialogView.findViewById<ImageView>(R.id.dialog_image)
            dialogImage.setImageResource(R.drawable.foto_kantor_bapekomvi)

            // Tampilkan dialog
            val dialog = AlertDialog.Builder(requireContext())
                .setView(dialogView)
                .setCancelable(true)
                .create()
            dialog.show()
        }

        imageView.setOnTouchListener { _, event ->
            scaleGestureDetector.onTouchEvent(event)
            true
        }

        // Referensi tombol dari layout
        val myButton: Button = view.findViewById(R.id.home_button)

        val colorAnimator = ValueAnimator.ofObject(
            ArgbEvaluator(),
            Color.parseColor("#20326A"), //Biru
            Color.parseColor("#F9A01B")  //Kuning
        )

        colorAnimator.duration = 2000 // Durasi animasi (2 detik)
        colorAnimator.repeatCount = ValueAnimator.INFINITE // Animasi berulang
        colorAnimator.repeatMode = ValueAnimator.REVERSE

        colorAnimator.addUpdateListener { animator ->
            val animatedValue = animator.animatedValue as Int
            myButton.setBackgroundColor(animatedValue)
        }
        colorAnimator.start()

        myButton.setOnClickListener {
            val uri = Uri.parse("https://maps.app.goo.gl/8ezofuDKPSLiVysU7")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        return view
    }

    private inner class ScaleListener : ScaleGestureDetector.OnScaleGestureListener {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scaleFactor *= detector.scaleFactor
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f))

            // Mengubah ukuran gambar berdasarkan zoom
            imageView.scaleX = scaleFactor
            imageView.scaleY = scaleFactor
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector) {}
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}