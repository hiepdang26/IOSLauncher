package com.luutinhit.launcher6.leftpage.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.luutinhit.launcher6.t;
import defpackage.ar1;
import defpackage.cw;
import defpackage.e51;
import defpackage.g7;
import defpackage.g71;
import defpackage.m61;
import defpackage.nm;
import defpackage.v51;
import defpackage.vm;

/* JADX INFO: loaded from: classes.dex */
public class PhotoWidget_2x2 extends vm {
    public static final /* synthetic */ int q = 0;
    public final Context k;
    public AppCompatImageView l;
    public LinearLayoutCompat m;
    public cw n;
    public final int o;
    public final boolean p;

    public PhotoWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = context;
        LayoutInflater.from(context).inflate(m61.picture_app_widget_2x2, (ViewGroup) this, true);
        this.o = (int) (((double) ((t) context).getDeviceProfile().C) * 0.68d);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.PhotoWidget_2x2);
            this.p = typedArrayObtainStyledAttributes.getBoolean(g71.PhotoWidget_2x2_isOnHomeWidgetPage, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // defpackage.dm0
    public final void l() {
        w(this.k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.k).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.k).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
        w(this.k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.l = (AppCompatImageView) findViewById(v51.picture_widget_content);
        this.m = (LinearLayoutCompat) findViewById(v51.picture_widget_permission);
        findViewById(v51.button_request_storage_permission).setOnClickListener(new g7(this, 9));
        nm nmVar = (nm) this.l.getLayoutParams();
        nm nmVar2 = (nm) this.m.getLayoutParams();
        if (!this.p) {
            int i = this.o;
            nmVar.setMargins(i, i, i, i);
            int i2 = this.o;
            nmVar2.setMargins(i2, i2, i2, i2);
            return;
        }
        int dimensionPixelSize = this.k.getResources().getDimensionPixelSize(e51.widget_margin_top_bottom);
        int dimensionPixelSize2 = this.k.getResources().getDimensionPixelSize(e51.widget_elevation_shadow);
        int dimensionPixelSize3 = this.k.getResources().getDimensionPixelSize(e51.widget_margin_start_end);
        this.l.setElevation(dimensionPixelSize2);
        if (ar1.v(getResources())) {
            nmVar.setMargins(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
            nmVar2.setMargins(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            nmVar.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            nmVar2.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (defpackage.e42.h(r6) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(android.content.Context r6) {
        /*
            r5 = this;
            boolean r0 = defpackage.ar1.j     // Catch: java.lang.Throwable -> Le
            r1 = 8
            r2 = 0
            if (r0 == 0) goto L10
            boolean r0 = defpackage.e42.g(r6)     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L58
            goto L16
        Le:
            r6 = move-exception
            goto L63
        L10:
            boolean r0 = defpackage.e42.h(r6)     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L58
        L16:
            androidx.appcompat.widget.AppCompatImageView r0 = r5.l     // Catch: java.lang.Throwable -> Le
            r0.setVisibility(r2)     // Catch: java.lang.Throwable -> Le
            androidx.appcompat.widget.LinearLayoutCompat r0 = r5.m     // Catch: java.lang.Throwable -> Le
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> Le
            f8 r0 = new f8     // Catch: java.lang.Throwable -> Le
            r1 = 2
            r0.<init>(r5, r6, r1)     // Catch: java.lang.Throwable -> Le
            ur0 r1 = new ur0     // Catch: java.lang.Throwable -> Le
            r1.<init>(r0)     // Catch: java.lang.Throwable -> Le
            td1 r0 = defpackage.ee1.a     // Catch: java.lang.Throwable -> Le
            yr0 r0 = r1.B(r0)     // Catch: java.lang.Throwable -> Le
            eb0 r1 = defpackage.x4.a()     // Catch: java.lang.Throwable -> Le
            q11 r2 = new q11     // Catch: java.lang.Throwable -> Le
            r3 = 17
            r4 = 0
            r2.<init>(r5, r6, r3, r4)     // Catch: java.lang.Throwable -> Le
            vr0 r6 = new vr0     // Catch: java.lang.Throwable -> L47 java.lang.NullPointerException -> L56
            r3 = 0
            r6.<init>(r2, r1, r3)     // Catch: java.lang.Throwable -> L47 java.lang.NullPointerException -> L56
            r0.z(r6)     // Catch: java.lang.Throwable -> L47 java.lang.NullPointerException -> L56
            return
        L47:
            r6 = move-exception
            defpackage.hg0.C(r6)     // Catch: java.lang.Throwable -> Le
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> Le
            java.lang.String r1 = "subscribeActual failed"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Le
            r0.initCause(r6)     // Catch: java.lang.Throwable -> Le
            throw r0     // Catch: java.lang.Throwable -> Le
        L56:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> Le
        L58:
            androidx.appcompat.widget.AppCompatImageView r6 = r5.l     // Catch: java.lang.Throwable -> Le
            r6.setVisibility(r1)     // Catch: java.lang.Throwable -> Le
            androidx.appcompat.widget.LinearLayoutCompat r6 = r5.m     // Catch: java.lang.Throwable -> Le
            r6.setVisibility(r2)     // Catch: java.lang.Throwable -> Le
            return
        L63:
            r6.getMessage()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.leftpage.widgets.PhotoWidget_2x2.w(android.content.Context):void");
    }

    @Override // defpackage.dm0
    public final void n() {
    }
}
