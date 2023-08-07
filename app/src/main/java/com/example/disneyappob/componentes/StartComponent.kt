package com.example.disneyappob.componentes

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.compose.runtime.mutableStateOf
import com.example.disneyappob.R

class StartComponent@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    //Gestionar estados checked y no checked
    //Cambiar entre el border y el filled cuadno este checkeado

    private val imageView: ImageView
    var checked: Boolean = false
        set(value) {
            field = value
            selectImage()
        }
    init {
        imageView = inflate(context, R.layout.component_star, this)
            .findViewById(R.id.ivStar)


    }

    private fun selectImage() = imageView.setImageResource(if (checked) {
        R.drawable.star_filled
    } else {
        R.drawable.star_border
    })

}