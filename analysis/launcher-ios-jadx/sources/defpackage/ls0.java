package defpackage;

import android.os.RemoteException;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfx;

/* JADX INFO: loaded from: classes.dex */
public final class ls0 extends FrameLayout {
    public gs0 g;
    public boolean h;
    public ImageView.ScaleType i;
    public boolean j;
    public pw1 k;
    public xz1 l;

    public final synchronized void a(xz1 xz1Var) {
        this.l = xz1Var;
        if (this.j) {
            ImageView.ScaleType scaleType = this.i;
            zzbfh zzbfhVar = ((xv0) xz1Var.g).h;
            if (zzbfhVar != null && scaleType != null) {
                try {
                    zzbfhVar.zzdy(new gy0(scaleType));
                } catch (RemoteException unused) {
                    k92.f();
                }
            }
        }
    }

    public gs0 getMediaContent() {
        return this.g;
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        zzbfh zzbfhVar;
        this.j = true;
        this.i = scaleType;
        xz1 xz1Var = this.l;
        if (xz1Var == null || (zzbfhVar = ((xv0) xz1Var.g).h) == null || scaleType == null) {
            return;
        }
        try {
            zzbfhVar.zzdy(new gy0(scaleType));
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public void setMediaContent(gs0 gs0Var) {
        boolean zZzl;
        boolean zZzr;
        this.h = true;
        this.g = gs0Var;
        pw1 pw1Var = this.k;
        if (pw1Var != null) {
            ((xv0) pw1Var.g).b(gs0Var);
        }
        if (gs0Var == null) {
            return;
        }
        try {
            zzbfx zzbfxVar = ((x92) gs0Var).b;
            if (zzbfxVar != null) {
                boolean zZzk = false;
                try {
                    zZzl = ((x92) gs0Var).a.zzl();
                } catch (RemoteException unused) {
                    k92.f();
                    zZzl = false;
                }
                if (!zZzl) {
                    try {
                        zZzk = ((x92) gs0Var).a.zzk();
                    } catch (RemoteException unused2) {
                        k92.f();
                    }
                    if (zZzk) {
                        zZzr = zzbfxVar.zzr(new gy0(this));
                    }
                    removeAllViews();
                }
                zZzr = zzbfxVar.zzs(new gy0(this));
                if (zZzr) {
                    return;
                }
                removeAllViews();
            }
        } catch (RemoteException unused3) {
            removeAllViews();
            k92.f();
        }
    }
}
