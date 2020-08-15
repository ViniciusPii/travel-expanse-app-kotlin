package com.viniciuspiih.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    buttonCalculate.setOnClickListener(this)
  }

  override fun onClick(v: View?) {
    val id = v?.id
    if (id == R.id.buttonCalculate) {
      calculate()
    }
  }

  private fun calculate() {

    if (validationOk()) {

      try {
        val distance = distance.text.toString().toFloat()
        val price = price.text.toString().toFloat()
        val autonomy = autonomy.text.toString().toFloat()

        val totalValue = distance * price / autonomy

        textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
      } catch (nfe: NumberFormatException) {
        Toast.makeText(this, getString(R.string.errorValue), Toast.LENGTH_SHORT).show()
      }

    } else {
      Toast.makeText(this, getString(R.string.notification), Toast.LENGTH_SHORT).show()
    }
  }

  private fun validationOk(): Boolean =
    (distance.text.toString() != "" && price.text.toString() != "" && autonomy.text.toString() != "0")
}