package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzffk;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f22 implements Callable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    public /* synthetic */ f22(Object obj, Object obj2, Object obj3, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
        this.j = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        zzffk zzffkVar;
        switch (this.g) {
            case 0:
                y22 y22Var = (y22) this.h;
                Context context = y22Var.h;
                zzbyq zzbyqVar = (zzbyq) this.i;
                return y22Var.f(context, zzbyqVar.zza, zzbyqVar.zzb, zzbyqVar.zzc, zzbyqVar.zzd, (Bundle) this.j);
            case 1:
                y22 y22Var2 = (y22) this.h;
                zzauo zzauoVar = y22Var2.i;
                String strZzh = zzauoVar.zzc() != null ? zzauoVar.zzc().zzh(y22Var2.h, (View) gy0.r((he0) this.j), null) : "";
                if (TextUtils.isEmpty(strZzh)) {
                    throw new Exception("Failed to get view signals.");
                }
                ArrayList arrayList = new ArrayList();
                for (Uri uri : (List) this.i) {
                    if (y22.u(uri, y22Var2.E, y22Var2.F)) {
                        arrayList.add(y22.v(uri, "ms", strZzh));
                    } else {
                        k92.h("Not a Google URL: ".concat(String.valueOf(uri)));
                        arrayList.add(uri);
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new Exception("Empty impression URLs result.");
                }
                return arrayList;
            case 2:
                e41.a(((m92) this.h).c, (s2) this.i, (la2) this.j);
                return Boolean.TRUE;
            default:
                Uri uriZza = (Uri) this.i;
                y22 y22Var3 = (y22) this.h;
                y22Var3.getClass();
                try {
                    boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzla)).booleanValue();
                    he0 he0Var = (he0) this.j;
                    uriZza = (!zBooleanValue || (zzffkVar = y22Var3.j) == null) ? y22Var3.i.zza(uriZza, y22Var3.h, (View) gy0.r(he0Var), null) : zzffkVar.zza(uriZza, y22Var3.h, (View) gy0.r(he0Var), null);
                    break;
                } catch (zzaup unused) {
                    k92.j(5);
                }
                if (uriZza.getQueryParameter("ms") != null) {
                    return uriZza;
                }
                throw new Exception("Failed to append spam signals to click url.");
        }
    }
}
