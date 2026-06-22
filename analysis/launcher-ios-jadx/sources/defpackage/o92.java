package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayk;
import com.google.android.gms.internal.ads.zzboi;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class o92 {
    public final zzboi a;
    public final lc2 b;
    public final ur1 c;
    public final f92 d;
    public b22 e;
    public j2 f;
    public u2[] g;
    public u6 h;
    public v52 i;
    public zr1 j;
    public String k;
    public final va l;
    public boolean m;

    public o92(va vaVar) {
        lc2 lc2Var = lc2.a;
        this.a = new zzboi();
        this.c = new ur1();
        this.d = new f92(this);
        this.l = vaVar;
        this.b = lc2Var;
        this.i = null;
        new AtomicBoolean(false);
    }

    public static rc2 a(Context context, u2[] u2VarArr) {
        for (u2 u2Var : u2VarArr) {
            if (u2Var.equals(u2.j)) {
                return new rc2("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
            }
        }
        rc2 rc2Var = new rc2(context, u2VarArr);
        rc2Var.p = false;
        return rc2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4 A[Catch: RemoteException -> 0x00d2, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x00d2, blocks: (B:28:0x009e, B:30:0x00a4, B:32:0x00b2, B:34:0x00c4, B:37:0x00d4), top: B:53:0x009e, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(defpackage.e92 r13) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o92.b(e92):void");
    }

    public final void c(b22 b22Var) {
        try {
            this.e = b22Var;
            v52 v52Var = this.i;
            if (v52Var != null) {
                v52Var.zzC(b22Var != null ? new i42(b22Var) : null);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void d(u2... u2VarArr) {
        va vaVar = this.l;
        this.g = u2VarArr;
        try {
            v52 v52Var = this.i;
            if (v52Var != null) {
                v52Var.zzF(a(vaVar.getContext(), this.g));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        vaVar.requestLayout();
    }

    public final void e(u6 u6Var) {
        try {
            this.h = u6Var;
            v52 v52Var = this.i;
            if (v52Var != null) {
                v52Var.zzG(u6Var != null ? new zzayk(u6Var) : null);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
