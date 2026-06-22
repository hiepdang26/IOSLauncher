package defpackage;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzgcf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class u22 implements zzgcf {
    public final /* synthetic */ int g;
    public final /* synthetic */ zzbtc h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ y22 j;

    public /* synthetic */ u22(y22 y22Var, zzbtc zzbtcVar, boolean z, int i) {
        this.g = i;
        this.h = zzbtcVar;
        this.i = z;
        this.j = y22Var;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        switch (this.g) {
            case 0:
                try {
                    this.h.zze("Internal error: " + th.getMessage());
                } catch (RemoteException unused) {
                    k92.f();
                    return;
                }
                break;
            default:
                try {
                    this.h.zze("Internal error: " + th.getMessage());
                } catch (RemoteException unused2) {
                    k92.f();
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        y22 y22Var;
        switch (this.g) {
            case 0:
                y22 y22Var2 = this.j;
                ArrayList arrayList = (ArrayList) obj;
                try {
                    this.h.zzf(arrayList);
                    if (y22Var2.s || this.i) {
                        int size = arrayList.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayList.get(i);
                            i++;
                            Uri uri = (Uri) obj2;
                            boolean zU = y22.u(uri, y22Var2.E, y22Var2.F);
                            zzfll zzfllVar = y22Var2.r;
                            if (zU) {
                                zzfllVar.zzc(y22.v(uri, y22Var2.B, "1").toString(), null);
                            } else {
                                if (((Boolean) n42.d.c.zza(zzbbw.zzgJ)).booleanValue()) {
                                    zzfllVar.zzc(uri.toString(), null);
                                }
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    k92.f();
                    return;
                }
                break;
            default:
                List<Uri> list = (List) obj;
                try {
                    Iterator it = list.iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        y22Var = this.j;
                        if (zHasNext) {
                            if (y22.u((Uri) it.next(), y22Var.C, y22Var.D)) {
                                y22Var.y.getAndIncrement();
                            }
                        }
                    }
                    this.h.zzf(list);
                    if (y22Var.t || this.i) {
                        for (Uri uri2 : list) {
                            boolean zU2 = y22.u(uri2, y22Var.C, y22Var.D);
                            zzfll zzfllVar2 = y22Var.r;
                            if (zU2) {
                                zzfllVar2.zzc(y22.v(uri2, y22Var.B, "1").toString(), null);
                            } else {
                                if (((Boolean) n42.d.c.zza(zzbbw.zzgJ)).booleanValue()) {
                                    zzfllVar2.zzc(uri2.toString(), null);
                                }
                            }
                            break;
                        }
                    }
                } catch (RemoteException unused2) {
                    k92.f();
                }
                break;
        }
    }
}
