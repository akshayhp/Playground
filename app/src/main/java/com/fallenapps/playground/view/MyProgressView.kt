package com.fallenapps.playground.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.fallenapps.playground.R
import kotlin.math.cos
import kotlin.math.sin


class MyProgressView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private  val primaryProgressPaint:Paint
    private  val secondaryProgressPaint:Paint
    private  val indicatorPaint:Paint

    private val startAngle = 200F
    private val maxSweepAngle = 140F

    private  var primaryProgressColor=0
    private  var secondaryProgressColor=0
    private  var indicatorColor=0

    private var secondaryProgress = 0F
    private var indicatorAt = 0F
    private var progressWidth = 0F
    private var indicatorWidth = 0F



    init {
        context?.theme?.obtainStyledAttributes(
            attrs,
            R.styleable.MyProgressView,
            0, 0)?.apply {
            try {
                secondaryProgress =
                    getInteger(R.styleable.MyProgressView_secondary_progress, 0) / 100F
                indicatorAt = getInteger(R.styleable.MyProgressView_indicator_position, 0) / 100F

                primaryProgressColor = getColor(R.styleable.MyProgressView_primary_progress_color,Color.LTGRAY)
                secondaryProgressColor = getColor(R.styleable.MyProgressView_secondary_progress_color,Color.GREEN)
                indicatorColor = getColor(R.styleable.MyProgressView_indicator_color,Color.BLUE)

                progressWidth = getDimension(R.styleable.MyProgressView_progress_width, 10F)
                indicatorWidth = getDimension(R.styleable.MyProgressView_indicator_width, 10F)

            } finally {
                recycle()
            }
        }

        primaryProgressPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply{

            this.color=primaryProgressColor
            this.strokeWidth = progressWidth
            this.strokeCap=Paint.Cap.ROUND
            this.style = Paint.Style.STROKE
            this.isAntiAlias = true

        }
        secondaryProgressPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply{
            this.color=secondaryProgressColor
            this.strokeWidth = progressWidth
            this.style = Paint.Style.STROKE
            this.strokeCap=Paint.Cap.ROUND
            this.isAntiAlias = true



        }
        indicatorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply{
            this.color=indicatorColor
            this.strokeWidth = indicatorWidth
            this.style = Paint.Style.STROKE
            this.isAntiAlias = true

        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val rect = RectF(canvas?.clipBounds)


        val mX=rect.width()/2
        val mY=rect.height()

        val radius = (rect.width()-20F)/2
        val offsetY = (rect.width())*0.125F
        val oval = RectF(mX - radius, mY - (radius-offsetY), mX + radius, mY + radius+offsetY)
        canvas!!.drawArc(oval, startAngle, maxSweepAngle, false, primaryProgressPaint)
        canvas!!.drawArc(oval, startAngle, maxSweepAngle*secondaryProgress, false, secondaryProgressPaint)


        val startX: Float =
            (cos(Math.toRadians((200F+(140F*indicatorAt)).toDouble())) * radius + mX).toFloat()

        val startY: Float =
            (sin(Math.toRadians((200+(140F*indicatorAt)).toDouble())) * radius + mY+offsetY).toFloat()
        canvas.drawCircle(startX, startY, 10F, indicatorPaint);
    }


}