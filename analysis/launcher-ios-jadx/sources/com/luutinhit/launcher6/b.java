package com.luutinhit.launcher6;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import defpackage.uo;
import defpackage.zw;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ zw g;
    public final /* synthetic */ Interpolator h;
    public final /* synthetic */ Interpolator i;
    public final /* synthetic */ float j;
    public final /* synthetic */ float k;
    public final /* synthetic */ float l;
    public final /* synthetic */ float m;
    public final /* synthetic */ float n;
    public final /* synthetic */ float o;
    public final /* synthetic */ float p;
    public final /* synthetic */ Rect q;
    public final /* synthetic */ Rect r;
    public final /* synthetic */ DragLayer s;

    public b(DragLayer dragLayer, zw zwVar, Interpolator interpolator, Interpolator interpolator2, float f, float f2, float f3, float f4, float f5, float f6, float f7, Rect rect, Rect rect2) {
        this.s = dragLayer;
        this.g = zwVar;
        this.h = interpolator;
        this.i = interpolator2;
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.n = f5;
        this.o = f6;
        this.p = f7;
        this.q = rect;
        this.r = rect2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        zw zwVar = this.g;
        int measuredWidth = zwVar.getMeasuredWidth();
        int measuredHeight = zwVar.getMeasuredHeight();
        Interpolator interpolator = this.h;
        float interpolation = interpolator == null ? fFloatValue : interpolator.getInterpolation(fFloatValue);
        Interpolator interpolator2 = this.i;
        float interpolation2 = interpolator2 == null ? fFloatValue : interpolator2.getInterpolation(fFloatValue);
        float f = this.j;
        float f2 = this.k;
        float f3 = f * f2;
        float f4 = this.l * f2;
        float f5 = 1.0f - fFloatValue;
        float f6 = (f3 * f5) + (this.m * fFloatValue);
        float f7 = (f5 * f4) + (this.n * fFloatValue);
        float fS = uo.s(1.0f, interpolation, this.p, this.o * interpolation);
        Rect rect = this.q;
        float f8 = (((f4 - 1.0f) * measuredHeight) / 2.0f) + rect.top;
        Rect rect2 = this.r;
        int iRound = (int) ((((f3 - 1.0f) * measuredWidth) / 2.0f) + rect.left + Math.round((rect2.left - r4) * interpolation2));
        int iRound2 = (int) (f8 + Math.round((rect2.top - f8) * interpolation2));
        DragLayer dragLayer = this.s;
        View view = dragLayer.mAnchorView;
        int scrollX = (iRound - dragLayer.mDropView.getScrollX()) + (view == null ? 0 : (int) (view.getScaleX() * (dragLayer.mAnchorViewInitialScrollX - dragLayer.mAnchorView.getScrollX())));
        int scrollY = iRound2 - dragLayer.mDropView.getScrollY();
        dragLayer.mDropView.setTranslationX(scrollX);
        dragLayer.mDropView.setTranslationY(scrollY);
        dragLayer.mDropView.setScaleX(f6);
        dragLayer.mDropView.setScaleY(f7);
        dragLayer.mDropView.setAlpha(fS);
    }
}
