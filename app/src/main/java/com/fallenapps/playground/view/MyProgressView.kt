package com.fallenapps.playground.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin


class MyProgressView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private  val primaryProgressPaint:Paint
    private  val secondaryProgressPaint:Paint
    private  val indicatorPaint:Paint

    private val startAngle = 200F
    private val maxSweepAngle = 140F
    private val secondaryProgress = 0.5F
    private val indicatorAt = 0.7F
    private val sweepAngle = 0

    init {
        primaryProgressPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply{

            this.color=Color.GRAY
            this.strokeWidth = 20F
            this.strokeCap=Paint.Cap.ROUND
            this.style = Paint.Style.STROKE
            this.isAntiAlias = true

        }
        secondaryProgressPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply{
            this.color=Color.RED
            this.strokeWidth = 20F
            this.style = Paint.Style.STROKE
            this.isAntiAlias = true



        }
        indicatorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply{
            this.color=Color.BLUE
            this.strokeWidth = 20F
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


//        val myPath = Path()
//        myPath.addArc(rect.left,rect.top,rect.right,rect.bottom,startAngle, 140F)
//        canvas?.drawPath(myPath,primaryProgressPaint)
//        //canvas?.translate(0F, -(canvas.bottom / 2))
//
//        //canvas?.drawOval(rect,primaryProgressPaint)
//
//       // canvas?.drawArc(rect, startAngle, 180f, true, secondaryProgressPaint)
//
//        //canvas?.drawArc(rect, 200F, 200F, true, indicatorPaint)



    }


}