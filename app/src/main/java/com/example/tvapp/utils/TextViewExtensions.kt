package com.example.tvapp.utils

import android.widget.TextView
import com.example.tvapp.presentation.search.SPACER

fun TextView.showIfNotEmpty(text: String?) {
    if (text.isNullOrEmpty().not()) {
        this.text = text
    }
}

fun TextView.showIfAtLeastOneNotEmpty(text: String, textTwo: String) {
    if ((text == "null") or (textTwo == "null")) return
    else {
        this.text = text + SPACER + textTwo
    }
}
