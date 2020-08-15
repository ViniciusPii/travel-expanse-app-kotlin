package com.viniciuspiih.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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
      val distance = distance.text.toString().toFloat()
      val price = price.text.toString().toFloat()
      val autonomy = autonomy.text.toString().toFloat()

      val totalValue = distance * price / autonomy

      textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
    }
  }

  private fun validationOk(): Boolean =
    (distance.text.toString() != "" && price.text.toString() != "" && autonomy.text.toString() != "")
}