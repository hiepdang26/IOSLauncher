package com.luutinhit.launcher6.leftpage.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.t;
import defpackage.ar1;
import defpackage.e51;
import defpackage.g71;
import defpackage.l51;
import defpackage.m61;
import defpackage.nm;
import defpackage.o1;
import defpackage.v51;
import defpackage.vm;

/* JADX INFO: loaded from: classes.dex */
public class BatteryWidget2x2 extends vm {
    public final Context k;
    public final Handler l;
    public final o1 m;
    public ImageView n;
    public TextView o;
    public final Paint p;
    public final Paint q;
    public final RectF r;
    public final float s;
    public final int t;
    public final Drawable u;
    public final int v;
    public boolean w;
    public final boolean x;

    public BatteryWidget2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new Handler();
        this.m = new o1(this, 7);
        this.r = new RectF();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.BatteryWidget2x2);
            this.x = typedArrayObtainStyledAttributes.getBoolean(g71.BatteryWidget2x2_isOnHomeWidgetPage, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.k = context;
        this.w = o();
        this.v = (int) (((double) ((t) context).getDeviceProfile().C) * 0.68d);
        LayoutInflater.from(context).inflate(m61.battery_widget_2x2, (ViewGroup) this, true);
        setClipToOutline(true);
        Paint paint = new Paint(1);
        this.p = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.p.setStrokeWidth(5.0f);
        Paint paint2 = this.p;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        this.p.setColor(-16711936);
        Paint paint3 = new Paint(1);
        this.q = paint3;
        paint3.setStyle(style);
        this.q.setStrokeWidth(6.0f);
        this.q.setStrokeCap(cap);
        this.q.setColor(-2130706433);
        this.t = this.k.getResources().getDimensionPixelSize(e51.battery_widget_progress_size);
        this.s = this.k.getResources().getDimensionPixelSize(e51.battery_widget_progress_stroke) * 1.1f;
        this.u = this.k.getDrawable(l51.ic_phone);
    }

    @Override // defpackage.dm0
    public final void l() {
    }

    @Override // defpackage.dm0
    public final void n() {
        Handler handler = this.l;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.m, 2000L);
        if (this.w != o()) {
            this.w = o();
            w();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.k).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.k).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
        Handler handler = this.l;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.m, 2000L);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.n = (ImageView) findViewById(v51.widget_battery_progress);
        this.o = (TextView) findViewById(v51.widget_battery_text);
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    @Override // defpackage.vm
    public void setTextAndBackgroundColor(ViewGroup viewGroup) {
        super.setTextAndBackgroundColor(viewGroup);
    }

    public final void w() {
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(v51.battery_widget_content);
        nm nmVar = (nm) linearLayoutRound.getLayoutParams();
        if (this.x) {
            int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(e51.widget_margin_top_bottom);
            int dimensionPixelSize2 = this.k.getResources().getDimensionPixelSize(e51.widget_elevation_shadow);
            int dimensionPixelSize3 = this.k.getResources().getDimensionPixelSize(e51.widget_margin_start_end);
            linearLayoutRound.setElevation(dimensionPixelSize2);
            if (ar1.v(getResources())) {
                nmVar.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            } else {
                nmVar.setMargins(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
            }
        } else {
            int i = this.v;
            nmVar.setMargins(i, i, i, i);
        }
        linearLayoutRound.setBackgroundResource(l51.widget_shadow_rect);
    }
}
