package com.luutinhit.wallpaper.livewallpaper;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import defpackage.jl1;

/* JADX INFO: loaded from: classes.dex */
public class MyViewPager extends ViewPager {
    public final ArgbEvaluator m0;

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m0 = new ArgbEvaluator();
        jl1 jl1Var = new jl1(28);
        boolean z = this.c0 == null;
        this.c0 = jl1Var;
        setChildrenDrawingOrderEnabled(true);
        this.e0 = 2;
        this.d0 = 2;
        if (z) {
            p();
        }
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void k(int i, float f, int i2) {
        if (i < 1) {
            getRootView().setBackgroundColor(((Integer) this.m0.evaluate(f, Integer.valueOf(Color.argb(153, 35, 35, 35)), Integer.valueOf(Color.argb(200, 0, 0, 0)))).intValue());
        } else {
            getRootView().setBackgroundColor(Color.argb(200, 0, 0, 0));
        }
        super.k(i, f, i2);
    }
}
