package com.ianpedraza.feedbacks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.ianpedraza.feedbacks.R
import com.ianpedraza.feedbacks.databinding.ActivityMainBinding
import com.ianpedraza.feedbacks.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val alertDialog by lazy {
        AlertDialog.Builder(this)
            .setTitle("My Title")
            .setMessage("This is my message")
            .setPositiveButton("Accept") { _, _ ->
                // DO SOMETHING
            }.setNegativeButton("Cancel") { _, _ ->
                // DO SOMETHING
            }
            .setOnCancelListener {
                // DO SOMETHING
            }
            .setNeutralButton("I don't Know") { _, _ ->
                // DO SOMETHING
            }
            .setIcon(R.drawable.ic_alert)
            .setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnToast.setOnClickListener { showToast() }
            btnSnack.setOnClickListener { showSnackBar(it) }
            btnDialog.setOnClickListener { showDialog() }
        }
    }

    private fun showToast() {
        Toast.makeText(this, "My message", Toast.LENGTH_SHORT).show()
    }

    private fun showSnackBar(view: View) {
        Snackbar.make(view, "My message", Snackbar.LENGTH_SHORT)
            .setAction("Action") {
                // DO SOMETHING
            }
            .show()
    }

    private fun showDialog() {
        alertDialog.show()
    }

}