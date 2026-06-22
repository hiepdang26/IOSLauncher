package com.luutinhit.launcher6.util;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatButton;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.CustomZoomButton;
import defpackage.e51;
import defpackage.fd;
import defpackage.vc;
import defpackage.xu;

/* JADX INFO: loaded from: classes.dex */
public class CustomZoomButton extends AppCompatButton {
    public final vc g;
    public final RectF h;
    public final int[] i;

    public CustomZoomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = null;
        this.h = new RectF();
        this.i = new int[2];
        setScaleX(0.0f);
        setScaleY(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e51.icon_round_corner);
        t tVar = (t) context;
        fd blurWallpaperProvider = tVar.getBlurWallpaperProvider();
        blurWallpaperProvider.getClass();
        vc vcVar = new vc(blurWallpaperProvider, dimensionPixelSize, 4);
        this.g = vcVar;
        setBackground(vcVar);
        setTextColor(tVar.isDarkMode ? -1 : -16777216);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        xu xuVar;
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        Context context = getContext();
        if (!(context instanceof t) || (xuVar = ((t) context).mDeviceProfile) == null) {
            return;
        }
        int i = xuVar.D;
        int i2 = xuVar.B;
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        vc vcVar;
        super.onLayout(z, i, i2, i3, i4);
        if (!z || (vcVar = this.g) == null) {
            return;
        }
        RectF rectF = this.h;
        rectF.set(0.0f, 0.0f, i3 - i, i4 - i2);
        vcVar.i = true;
        vcVar.j.set(rectF);
        int[] iArr = this.i;
        getLocationInWindow(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        vcVar.c(i5);
        vcVar.d(iArr[1]);
        setBackground(vcVar);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            if (i == 0) {
                setEnabled(true);
                final int i2 = 1;
                animate().withLayer().scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withStartAction(new Runnable(this) { // from class: qr
                    public final /* synthetic */ CustomZoomButton h;

                    {
                        this.h = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                super/*android.widget.Button*/.setVisibility(8);
                                break;
                            default:
                                super/*android.widget.Button*/.setVisibility(0);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            } else if (i == 4 || i == 8) {
                final int i3 = 0;
                animate().withLayer().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withEndAction(new Runnable(this) { // from class: qr
                    public final /* synthetic */ CustomZoomButton h;

                    {
                        this.h = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                super/*android.widget.Button*/.setVisibility(8);
                                break;
                            default:
                                super/*android.widget.Button*/.setVisibility(0);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            }
        }
    }
}
