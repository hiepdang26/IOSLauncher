package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import defpackage.g71;
import defpackage.gf0;
import defpackage.nt1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class IndicatorView extends View implements nt1 {
    public final Paint g;
    public int h;
    public int i;
    public float j;
    public float k;
    public final float l;
    public int m;
    public int n;
    public final ArrayList o;
    public ViewPager p;

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.o = new ArrayList();
        this.p = null;
        float f = context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.IndicatorView);
        this.h = typedArrayObtainStyledAttributes.getColor(g71.IndicatorView_indicatorNormalColor, -7829368);
        this.i = typedArrayObtainStyledAttributes.getColor(g71.IndicatorView_indicatorSelectedColor, -1);
        this.j = typedArrayObtainStyledAttributes.getDimension(g71.IndicatorView_indicatorRadius, 4.0f * f);
        this.k = typedArrayObtainStyledAttributes.getDimension(g71.IndicatorView_indicatorStrokeWidth, 2.0f * f);
        this.l = typedArrayObtainStyledAttributes.getDimension(g71.IndicatorView_indicatorSpace, f * 5.0f);
        this.m = typedArrayObtainStyledAttributes.getInt(g71.IndicatorView_indicatorSelectPos, 0);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(this.h);
        paint.setStyle(Paint.Style.FILL);
    }

    private void setCount(int i) {
        this.n = i;
        requestLayout();
    }

    private void setSelectPosition(int i) {
        this.m = i;
        invalidate();
    }

    @Override // defpackage.nt1
    public final void a(int i) {
    }

    @Override // defpackage.nt1
    public final void b(int i) {
        setSelectPosition(i);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.o;
            if (i >= arrayList.size()) {
                return;
            }
            gf0 gf0Var = (gf0) arrayList.get(i);
            float f = gf0Var.a;
            float f2 = gf0Var.b;
            Paint paint = this.g;
            paint.setColor(i == this.m ? this.i : this.h);
            canvas.drawCircle(f, f2, this.j, paint);
            i++;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = (this.j + this.k) * 2.0f;
        int i3 = this.n;
        float f2 = this.l;
        setMeasuredDimension((int) (((i3 - 1) * f2) + (i3 * f)), (int) f);
        ArrayList arrayList = this.o;
        arrayList.clear();
        float f3 = 0.0f;
        int i4 = 0;
        while (i4 < this.n) {
            gf0 gf0Var = new gf0();
            f3 = i4 == 0 ? this.j + this.k : ((this.j + this.k) * 2.0f) + f2 + f3;
            gf0Var.a = f3;
            gf0Var.b = getMeasuredHeight() / 2.0f;
            arrayList.add(gf0Var);
            i4++;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = 0;
            while (true) {
                ArrayList arrayList = this.o;
                if (i >= arrayList.size()) {
                    break;
                }
                if (x > (((gf0) arrayList.get(i)).a - this.j) - this.k && x < ((gf0) arrayList.get(i)).a + this.j + this.k && y > (((gf0) arrayList.get(i)).b - this.j) - this.k && y < ((gf0) arrayList.get(i)).b + this.j + this.k) {
                    this.p.setCurrentItem(i);
                }
                i++;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIndicatorColor(int i) {
        this.h = i;
        invalidate();
    }

    public void setRadius(float f) {
        this.j = f;
        invalidate();
    }

    public void setSelectColor(int i) {
        this.i = i;
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.k = f;
        invalidate();
    }

    public void setUpWithViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.p;
        if (viewPager2 != null) {
            ArrayList arrayList = viewPager2.W;
            if (arrayList != null) {
                arrayList.remove(this);
            }
            this.p = null;
        }
        this.p = viewPager;
        if (viewPager.W == null) {
            viewPager.W = new ArrayList();
        }
        viewPager.W.add(this);
        setCount(this.p.getAdapter().c());
    }

    @Override // defpackage.nt1
    public final void c(float f, int i) {
    }
}
