package com.demo.statusglance.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Names(
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResourceId: Int,
    @StringRes val timeResourceId: Int
)
