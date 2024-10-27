package com.demo.statusglance.datasource

import com.demo.statusglance.R
import com.demo.statusglance.model.Names

class DataSource {
    fun loadNames(): List<Names> {
        return listOf<Names>(
            Names(R.drawable.status, R.string.name1, R.string.time1),
            Names(R.drawable.status, R.string.name2, R.string.time2),
            Names(R.drawable.status, R.string.name3, R.string.time3),
            Names(R.drawable.status, R.string.name4, R.string.time4),
            Names(R.drawable.status, R.string.name5, R.string.time5),
            Names(R.drawable.status, R.string.name6, R.string.time6),
            Names(R.drawable.status, R.string.name7, R.string.time7)
        )
    }
}

