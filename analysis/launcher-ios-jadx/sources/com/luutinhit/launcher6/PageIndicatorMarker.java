package com.luutinhit.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import defpackage.v51;
import defpackage.w01;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicatorMarker extends FrameLayout {
    public ImageView g;
    public boolean h;
    public w01 i;

    public PageIndicatorMarker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.h = false;
    }

    public final void a(boolean z) {
        if (z) {
            this.g.animate().cancel();
            this.g.setAlpha(1.0f);
            this.g.setScaleX(1.0f);
            this.g.setScaleY(1.0f);
        } else {
            this.g.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(175L).start();
        }
        this.h = true;
    }

    public final void b(boolean z) {
        if (z) {
            this.g.animate().cancel();
            this.g.setAlpha(0.5f);
            this.g.setScaleX(1.0f);
            this.g.setScaleY(1.0f);
        } else {
            this.g.animate().alpha(0.5f).scaleX(1.0f).scaleY(1.0f).setDuration(175L).start();
        }
        this.h = false;
    }

    public final void c(w01 w01Var, boolean z) {
        this.i = w01Var;
        this.h = w01Var == w01.i;
        int iOrdinal = w01Var.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                b(z);
                return;
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                a(z);
                return;
            }
        }
        if (z) {
            this.g.animate().cancel();
            this.g.setAlpha(0.5f);
            this.g.setScaleX(0.6f);
            this.g.setScaleY(0.6f);
        } else {
            this.g.animate().withLayer().alpha(0.5f).scaleX(0.6f).scaleY(0.6f).setDuration(175L).start();
        }
        this.h = false;
    }

    public w01 getState() {
        return this.i;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.g = (ImageView) findViewById(v51.marker);
    }

    public void setMarkerDrawables(int i) {
        this.g.setImageDrawable(getContext().getDrawable(i));
    }
}
