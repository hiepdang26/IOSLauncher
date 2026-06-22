package defpackage;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class dq0 implements oc {
    public static final Bitmap.Config l = Bitmap.Config.ARGB_8888;
    public final lh1 g;
    public final Set h;
    public final iy i;
    public final long j;
    public long k;

    public dq0(long j) {
        lh1 lh1Var = new lh1();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.j = j;
        this.g = lh1Var;
        this.h = setUnmodifiableSet;
        this.i = new iy();
    }

    public final synchronized Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapB;
        try {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            bitmapB = this.g.b(i, i2, config != null ? config : l);
            if (bitmapB != null) {
                long j = this.k;
                this.g.getClass();
                this.k = j - ((long) vq1.c(bitmapB));
                this.i.getClass();
                bitmapB.setHasAlpha(true);
                bitmapB.setPremultiplied(true);
            } else if (Log.isLoggable("LruBitmapPool", 3)) {
                this.g.getClass();
                lh1.c(vq1.d(config) * i * i2, config);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.g.getClass();
                lh1.c(vq1.d(config) * i * i2, config);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Objects.toString(this.g);
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapB;
    }

    public final synchronized void b(long j) {
        while (this.k > j) {
            lh1 lh1Var = this.g;
            Bitmap bitmap = (Bitmap) lh1Var.b.j();
            if (bitmap != null) {
                lh1Var.a(Integer.valueOf(vq1.c(bitmap)), bitmap);
            }
            if (bitmap == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Objects.toString(this.g);
                }
                this.k = 0L;
                return;
            }
            this.i.getClass();
            long j2 = this.k;
            this.g.getClass();
            this.k = j2 - ((long) vq1.c(bitmap));
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.g.getClass();
                lh1.c(vq1.c(bitmap), bitmap.getConfig());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Objects.toString(this.g);
            }
            bitmap.recycle();
        }
    }

    @Override // defpackage.oc
    public final Bitmap e(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapA = a(i, i2, config);
        if (bitmapA != null) {
            return bitmapA;
        }
        if (config == null) {
            config = l;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.oc
    public final Bitmap i(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapA = a(i, i2, config);
        if (bitmapA != null) {
            bitmapA.eraseColor(0);
            return bitmapA;
        }
        if (config == null) {
            config = l;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.oc
    public final synchronized void j(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.g.getClass();
                if (vq1.c(bitmap) <= this.j && this.h.contains(bitmap.getConfig())) {
                    this.g.getClass();
                    int iC = vq1.c(bitmap);
                    this.g.e(bitmap);
                    this.i.getClass();
                    this.k += (long) iC;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        this.g.getClass();
                        lh1.c(vq1.c(bitmap), bitmap.getConfig());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Objects.toString(this.g);
                    }
                    b(this.j);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.g.getClass();
                lh1.c(vq1.c(bitmap), bitmap.getConfig());
                bitmap.isMutable();
                this.h.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.oc
    public final void o(int i) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            r();
        } else if (i >= 20 || i == 15) {
            b(this.j / 2);
        }
    }

    @Override // defpackage.oc
    public final void r() {
        Log.isLoggable("LruBitmapPool", 3);
        b(0L);
    }
}
