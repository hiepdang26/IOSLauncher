package com.luutinhit.launcher6.leftpage.widgets;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.t;
import defpackage.br;
import defpackage.e51;

/* JADX INFO: loaded from: classes.dex */
public class ClockWidget_2x2 extends AppCompatImageView {
    public final Context g;
    public int h;
    public int i;
    public br j;

    public ClockWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        new Rect();
        new Path();
        new RectF();
        this.h = -1;
        this.i = -1;
        this.g = context;
        getResources().getDimensionPixelSize(e51.widget_round_corner);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        br brVar = new br(this.g, this.h, this.i);
        this.j = brVar;
        setBackground(brVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        br brVar = this.j;
        if (brVar != null) {
            Context context = this.g;
            if (context instanceof t) {
                ((t) context).removeOnTinyDBChangeListener(brVar);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.h = getWidth();
        this.i = getHeight();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }
}
