package com.fallenapps.playground

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fallenapps.playground.view.Adapter
import com.fallenapps.playground.view.ProgressViewData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(listOf(
            ProgressViewData(Color.LTGRAY,Color.RED,Color.BLUE,75F, 80F),
            ProgressViewData(Color.LTGRAY,Color.YELLOW,Color.BLUE,75F, 80F),
            ProgressViewData(Color.LTGRAY,Color.GREEN,Color.BLUE,75F, 80F),
            ProgressViewData(Color.LTGRAY,Color.RED,Color.BLUE,50F, 75F),
            ProgressViewData(Color.LTGRAY,Color.YELLOW,Color.BLUE,50F, 75F),
            ProgressViewData(Color.LTGRAY,Color.GREEN,Color.BLUE,50F, 75F),
            ProgressViewData(Color.LTGRAY,Color.RED,Color.BLUE,30F, 25F),
            ProgressViewData(Color.LTGRAY,Color.YELLOW,Color.BLUE,30F, 25F),
            ProgressViewData(Color.LTGRAY,Color.GREEN,Color.BLUE,30F, 25F),
            ProgressViewData(Color.LTGRAY,Color.RED,Color.BLUE,30F, 0F),
            ProgressViewData(Color.LTGRAY,Color.YELLOW,Color.BLUE,30F, 0F),
            ProgressViewData(Color.LTGRAY,Color.GREEN,Color.BLUE,30F, 0F),
            ProgressViewData(Color.LTGRAY,Color.DKGRAY,Color.TRANSPARENT,30F, 25F),
            ProgressViewData(Color.LTGRAY,Color.DKGRAY,Color.TRANSPARENT,30F, 25F),
            ProgressViewData(Color.LTGRAY,Color.DKGRAY,Color.TRANSPARENT,30F, 25F)

        ))
    }
}