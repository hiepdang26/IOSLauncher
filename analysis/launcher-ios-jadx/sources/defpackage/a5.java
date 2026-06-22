package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class a5 implements eb1 {
    public final /* synthetic */ int g;
    public final Object h;

    public /* synthetic */ a5(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.eb1
    public final int c() {
        switch (this.g) {
            case 0:
                return vq1.d(Bitmap.Config.ARGB_8888) * ((AnimatedImageDrawable) this.h).getIntrinsicHeight() * ((AnimatedImageDrawable) this.h).getIntrinsicWidth() * 2;
            case 1:
                return ((byte[]) this.h).length;
            case 2:
                return 1;
            default:
                return vq1.c((Bitmap) this.h);
        }
    }

    @Override // defpackage.eb1
    public final Class d() {
        switch (this.g) {
            case 0:
                return Drawable.class;
            case 1:
                return byte[].class;
            case 2:
                return ((File) this.h).getClass();
            default:
                return Bitmap.class;
        }
    }

    @Override // defpackage.eb1
    public final Object get() {
        switch (this.g) {
            case 0:
                return (AnimatedImageDrawable) this.h;
            case 1:
                return (byte[]) this.h;
            case 2:
                return (File) this.h;
            default:
                return (Bitmap) this.h;
        }
    }

    @Override // defpackage.eb1
    public final void recycle() {
        switch (this.g) {
            case 0:
                ((AnimatedImageDrawable) this.h).stop();
                ((AnimatedImageDrawable) this.h).clearAnimationCallbacks();
                break;
        }
    }

    public a5(byte[] bArr) {
        this.g = 1;
        n90.h(bArr, "Argument must not be null");
        this.h = bArr;
    }

    public a5(File file) {
        this.g = 2;
        n90.h(file, "Argument must not be null");
        this.h = file;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void e() {
    }
}
