package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbwn;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class da2 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ da2(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                zzblc zzblcVar = ((ea2) this.h).g;
                if (zzblcVar != null) {
                    try {
                        zzblcVar.zzb(Collections.EMPTY_LIST);
                        return;
                    } catch (RemoteException unused) {
                        k92.j(5);
                        return;
                    }
                }
                return;
            case 1:
                zzbwn zzbwnVar = (zzbwn) this.h;
                if (zzbwnVar != null) {
                    try {
                        zzbwnVar.zze(1);
                        return;
                    } catch (RemoteException e) {
                        k92.i("#007 Could not call remote method.", e);
                        return;
                    }
                }
                return;
            case 2:
                synchronized (((b82) this.h).j) {
                    b82 b82Var = (b82) ((b82) this.h).h;
                    if (b82Var != null) {
                        ((od2) b82Var.h).i();
                    }
                    break;
                }
                return;
            case 3:
                ((ib2) this.h).w();
                return;
            default:
                wb2 wb2Var = (wb2) this.h;
                long j = wb2.F((Context) wb2Var.h).getLong("app_set_id_last_used_time", -1L);
                long j2 = j != -1 ? j + 33696000000L : -1L;
                if (j2 == -1 || System.currentTimeMillis() <= j2) {
                    return;
                }
                Context context = (Context) wb2Var.h;
                if (!wb2.F(context).edit().remove("app_set_id").commit()) {
                    String strValueOf = String.valueOf(context.getPackageName());
                    if (strValueOf.length() != 0) {
                        "Failed to clear app set ID generated for App ".concat(strValueOf);
                    }
                }
                if (context.getSharedPreferences("app_set_id_storage", 0).edit().remove("app_set_id_last_used_time").commit()) {
                    return;
                }
                String strValueOf2 = String.valueOf(context.getPackageName());
                if (strValueOf2.length() != 0) {
                    "Failed to clear app set ID last used time for App ".concat(strValueOf2);
                    return;
                }
                return;
        }
    }
}
