package defpackage;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class zq1 extends BitmapDrawable {
    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return getBitmap().getWidth();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return getBitmap().getWidth();
    }
}
