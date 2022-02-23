package com.example.shudu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import javax.security.auth.callback.Callback;

import static com.example.shudu.Functions.str;


public  class DrawBackGround extends View {
    Paint bgPaint = new Paint();
    Paint orangePaint = new Paint();
    Paint greyPaint = new Paint();
    Paint blackPaint = new Paint();
    Paint errorPaint=new Paint();
    Paint getPaint = new Paint();
    Paint numPaint = new Paint();
    Paint fillPaint=new Paint();
    Paint kbPaint=new Paint();
    private float squarew, squareh;
    private static  int X, Y,get;
    private static float kX, kY;
    private static int choice;
    static int errorX,errorY;
    static boolean findError=false;
    static Functions game = new Functions();

    public DrawBackGround (Context context, AttributeSet attrs)
    {
        super(context, attrs);
        if(MainActivity.isNew==1) {
            str = Level.string;
            str=Functions.randomStr(str);
            game.sudoEmpty = Functions.fillPuzzle(str);//原始棋盘
            game.sudoAll = Functions.fillPuzzle(str);//全部内容
            game.sudoFill=Functions.fillPuzzle("");
            get=0;
            invalidate();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.squarew = w / 9.0f;
        this.squareh = h / 14.0f;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void init()
    {
        //the color of the background,white is useless
        bgPaint.setColor(getResources().getColor(R.color.background_white));

        kbPaint.setColor(getResources().getColor(R.color.black_thread1));
        kbPaint.setStrokeWidth(7);

        errorPaint.setStrokeWidth(7);
        errorPaint.setColor(getResources().getColor(R.color.error));

        getPaint.setColor(getResources().getColor(R.color.shudu_blue));
        getPaint.setStrokeWidth(6);

        //paint the threads of the canvas
        greyPaint.setColor(getResources().getColor(R.color.grey_thread3));
        greyPaint.setStrokeWidth(5);
        orangePaint.setColor(getResources().getColor(R.color.orange_thread2));
        orangePaint.setStrokeWidth(5);
        blackPaint.setColor(getResources().getColor(R.color.black_thread1));
        blackPaint.setStrokeWidth(5);

        //paint the num
        numPaint.setColor(Color.BLACK);
        numPaint.setStyle(Paint.Style.FILL);
        numPaint.setTextSize(squareh * 0.6f);
        numPaint.setTextAlign(Paint.Align.CENTER);

        fillPaint.setColor(getResources().getColor(R.color.fill_num));
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setTextSize(squareh * 0.6f);
        fillPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        canvas.drawRect(0, 0, getWidth(), getHeight(), bgPaint);//draw the background
        canvas.drawRect(0, 9 * squareh, 6 * squarew, getHeight(), greyPaint);

        for (int i = 1; i < 8; i += 3) {
            canvas.drawLine(0, i * squareh, getWidth(), i * squareh, greyPaint);
            canvas.drawLine(0, (i + 1) * squareh, getWidth(), (i + 1) * squareh, greyPaint);
        }//横灰线
        for (int i = 1; i < 8; i += 3) {
            canvas.drawLine(i * squarew, 0, i * squarew, 9 * squareh, greyPaint);
            canvas.drawLine((i + 1) * squarew, 0, (i + 1) * squarew, 9 * squareh, greyPaint);
        }//竖灰线
        canvas.drawLine(0, 0, getWidth(), 0, blackPaint);
        canvas.drawLine(0, 9 * squareh, getWidth(), 9 * squareh, blackPaint);
        canvas.drawLine(0, 0, 0, getHeight(), blackPaint);
        canvas.drawLine(getWidth(), 0, getWidth(), getHeight(), blackPaint);
        //边框
        canvas.drawLine(0, 3 * squareh, getWidth(), 3 * squareh, blackPaint);
        canvas.drawLine(0, 6 * squareh, getWidth(), 6 * squareh, blackPaint);
        canvas.drawLine(3 * squarew, 0, 3 * squarew, 9 * squareh, orangePaint);
        canvas.drawLine(6 * squarew, 0, 6 * squarew, 9 * squareh, orangePaint);

        //draw the keyboard
        canvas.drawLine(2 * squarew, 9 * squareh, 2 * squarew, getHeight(), kbPaint);
        canvas.drawLine(4 * squarew, 9 * squareh, 4 * squarew, getHeight(), kbPaint);
        canvas.drawLine(0, (18* squareh+getHeight())/3, 6*squarew, (18* squareh+getHeight())/3, kbPaint);
        canvas.drawLine(0, (2*getHeight()+9* squareh)/3, 6*squarew, (2*getHeight()+9* squareh)/3, kbPaint);

        Paint.FontMetrics fontMetrics = numPaint.getFontMetrics();
        float x = squarew / 2;
        float y = squareh / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果初始数独库数据不为空，则绘制
                if (!game.drawNum(i, j, game.sudoEmpty).equals(""))
                    canvas.drawText(game.drawNum(i, j, game.sudoEmpty), i * squarew + x, j * squareh + y, numPaint);
            }
            canvas.drawText(String.valueOf(i + 1), i % 3 * 2 * squarew +squarew, (i/3+0.65f)*(getHeight()-9*squareh)/3+9* squareh, numPaint);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果玩家所选数独库数据不为空，则绘制
                if (!game.drawNum(i, j, game.sudoFill).equals(""))
                    canvas.drawText(game.drawNum(i, j, game.sudoAll), i * squarew + x, j * squareh + y, fillPaint);
            }
        }

        //draw the selected square
        if(get==1)
        {
            canvas.drawLine(X * squarew, Y * squareh, X * squarew, (Y + 1) * squareh, getPaint);
            canvas.drawLine((X + 1) * squarew, Y * squareh, (X + 1) * squarew, (Y + 1) * squareh, getPaint);
            canvas.drawLine(X * squarew, Y * squareh, (X + 1) * squarew, Y * squareh, getPaint);
            canvas.drawLine(X * squarew, (Y + 1) * squareh, (X + 1) * squarew, (Y + 1) * squareh, getPaint);
        }

        //draw the error square
        if(findError)
        {
            switch (game.errorkind) {
                case 0:
                    canvas.drawLine(errorX * squarew, errorY * squareh, errorX * squarew, (errorY + 1) * squareh, errorPaint);
                    canvas.drawLine((errorX + 1) * squarew, errorY * squareh, (errorX + 1) * squarew, (errorY + 1) * squareh, errorPaint);
                    canvas.drawLine(errorX * squarew, errorY * squareh, (errorX + 1) * squarew, errorY * squareh, errorPaint);
                    canvas.drawLine(errorX * squarew, (errorY + 1) * squareh, (errorX + 1) * squarew, (errorY + 1) * squareh, errorPaint);
                    break;
                case 1:
                    canvas.drawLine(0, errorY * squareh, 0, (errorY + 1) * squareh, errorPaint);
                    canvas.drawLine(getWidth(), errorY * squareh, getWidth(), (errorY + 1) * squareh, errorPaint);
                    canvas.drawLine(0, errorY * squareh, getWidth() * squarew, errorY * squareh, errorPaint);
                    canvas.drawLine(0 * squarew, (errorY + 1) * squareh, getWidth(), (errorY + 1) * squareh, errorPaint);
                    break;
                case 2:
                    canvas.drawLine(errorX * squarew, 0, errorX * squarew, 9*squareh, errorPaint);
                    canvas.drawLine((errorX + 1) * squarew, 0, (errorX + 1) * squarew, 9 * squareh, errorPaint);
                    canvas.drawLine(errorX * squarew, 0, (errorX + 1) * squarew, 0, errorPaint);
                    canvas.drawLine(errorX * squarew, 9* squareh, (errorX + 1) * squarew, 9* squareh, errorPaint);
                    break;
                case 3:
                    errorX=errorX/3*3;
                    errorY=errorY/3*3;
                    canvas.drawLine(errorX * squarew, errorY * squareh, errorX * squarew, (errorY + 3) * squareh, errorPaint);
                    canvas.drawLine((errorX + 3) * squarew, errorY * squareh, (errorX + 3) * squarew, (errorY + 3) * squareh, errorPaint);
                    canvas.drawLine(errorX * squarew, errorY * squareh, (errorX + 3) * squarew, errorY * squareh, errorPaint);
                    canvas.drawLine(errorX * squarew, (errorY + 3) * squareh, (errorX + 3) * squarew, (errorY + 3) * squareh, errorPaint);
                    break;

            }
            findError=false;
        }
        //  super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //如果点击不是按下则重置方法
        if (event.getAction() != MotionEvent.ACTION_DOWN) {
            return super.onTouchEvent(event);
        }
        //获取点击格子的X和Y值
        kX = (event.getX() / squarew);
        kY = (event.getY() / squareh);
        if(kY<9) {
            X=(int)kX;
            Y=(int)kY;
            if (game.sudoEmpty[Y * 9 + X] == 0) {
                get = 1;
                invalidate();
            }
            return true;
        }
        else if(get==1)
        {
            final PlayMusic music=new PlayMusic();
            music.Play(Game.gameContext,1);
            choice = (int) ((kY - 9) / 1.67) * 3 + (int) (kX / 2 + 1);
            if(game.setNum(X,Y,choice))
            {
                invalidate();
            }
            get=0;
        }
        return true;
    }
}
