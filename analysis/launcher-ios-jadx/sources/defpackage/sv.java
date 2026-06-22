package defpackage;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzauo;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public final class sv implements Callable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ sv(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.g) {
            case 0:
                synchronized (((wv) this.h)) {
                    try {
                        wv wvVar = (wv) this.h;
                        if (wvVar.o == null) {
                            return null;
                        }
                        wvVar.G();
                        if (((wv) this.h).z()) {
                            ((wv) this.h).E();
                            ((wv) this.h).q = 0;
                        }
                        return null;
                    } finally {
                    }
                }
            case 1:
                bi0 bi0Var = new bi0();
                bi0Var.a = (JsReplyProxyBoundaryInterface) this.h;
                return bi0Var;
            case 2:
                return ((Drawable) this.h).mutate();
            case 3:
                return ((km1) this.h).getViewSignals();
            case 4:
                ja2 ja2Var = cd2.l;
                cd2 cd2Var = hd2.B.c;
                return cd2.l((Uri) this.h);
            default:
                dd2 dd2Var = (dd2) this.h;
                return new zzauo(zzaun.zzt(dd2Var.g.g, dd2Var.j, false));
        }
    }
}
