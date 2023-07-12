package com.example.core.utils

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.core.R
import org.jsoup.Jsoup

fun htmlParser(description: String): String {
    return Jsoup.parse(description).text()
}

fun setImageViewTint(
    applicationContext: Context,
    imageView: ImageView,
    condition: String?,
) {
    val colorGrey = ContextCompat.getColor(applicationContext, R.color.grey)
    val colorGreen = ContextCompat.getColor(applicationContext, R.color.green)

    val colorStateList = when (condition) {
        "true" -> ColorStateList.valueOf(colorGreen)
        else -> ColorStateList.valueOf(colorGrey)
    }

    imageView.imageTintList = colorStateList
}

fun setTextViewColor(applicationContext: Context, textView: TextView, condition: String) {
    val colorGrey = ContextCompat.getColor(applicationContext, R.color.grey)
    val colorGreen = ContextCompat.getColor(applicationContext, R.color.green)

    textView.setTextColor(if (condition == "true") colorGreen else colorGrey)
}