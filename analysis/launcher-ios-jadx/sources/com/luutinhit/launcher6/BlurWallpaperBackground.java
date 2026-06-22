package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.ed;
import defpackage.fd;
import defpackage.fg0;

/* JADX INFO: loaded from: classes.dex */
public class BlurWallpaperBackground extends AppCompatImageView implements ed, fg0 {
    public final fd g;

    public BlurWallpaperBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setLayerType(2, null);
        setAlpha(0.0f);
        setWillNotDraw(false);
        if (context instanceof t) {
            fd blurWallpaperProvider = ((t) context).getBlurWallpaperProvider();
            this.g = blurWallpaperProvider;
            blurWallpaperProvider.b(this);
        }
    }

    @Override // defpackage.ed
    public final void a() {
        setImageBitmap(this.g.e);
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
    }

    public void setUseTransparency(boolean z) {
    }

    @Override // defpackage.ed
    public final void g() {
    }
}
