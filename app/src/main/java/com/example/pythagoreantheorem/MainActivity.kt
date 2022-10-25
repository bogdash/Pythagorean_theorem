package com.example.pythagoreantheorem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.pythagoreantheorem.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showInfo() {
        val dialogTitle = getString(R.string.about_title,
            BuildConfig.VERSION_NAME)
        val dialogMessage = getString(R.string.about_message)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.about_item) {
            showInfo()
        }
        return true
    }

    fun onClickResult(view: View){
        if(!isFieldEmpty()) {
            val result = getString(R.string.result_info)+getResult()
            binding.tvResult.text = result
        }
    }

    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if(edA.text.isNullOrEmpty() || edA.text.toString().toDouble() == 0.0) edA.error = getString(R.string.error)
            if(edB.text.isNullOrEmpty() || edB.text.toString().toDouble() == 0.0) edB.error = getString(R.string.error)
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()

        }
    }
    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()

        }
        return sqrt( (a.pow(2) + b.pow(2)) ).toString()
    }

}