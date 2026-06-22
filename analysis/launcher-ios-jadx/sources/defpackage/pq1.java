package defpackage;

import android.content.Context;
import android.os.UserManager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class pq1 extends iy {
    public wp0 n;
    public HashMap o;
    public final UserManager p;

    public pq1(Context context) {
        this.p = (UserManager) context.getSystemService("user");
    }

    @Override // defpackage.iy
    public void i() {
        synchronized (this) {
            this.n = new wp0();
            this.o = new HashMap();
            jq1 jq1VarB = jq1.b();
            long serialNumberForUser = this.p.getSerialNumberForUser(jq1VarB.a);
            this.n.put(serialNumberForUser, jq1VarB);
            this.o.put(jq1VarB, Long.valueOf(serialNumberForUser));
        }
    }

    @Override // defpackage.iy
    public final long o(jq1 jq1Var) {
        synchronized (this) {
            try {
                HashMap map = this.o;
                if (map == null) {
                    return this.p.getSerialNumberForUser(jq1Var.a);
                }
                Long l = (Long) map.get(jq1Var);
                return l == null ? 0L : l.longValue();
            } finally {
            }
        }
    }

    @Override // defpackage.iy
    public final jq1 r(long j) {
        synchronized (this) {
            try {
                wp0 wp0Var = this.n;
                if (wp0Var == null) {
                    return jq1.a(this.p.getUserForSerialNumber(j));
                }
                return (jq1) wp0Var.get(j);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
