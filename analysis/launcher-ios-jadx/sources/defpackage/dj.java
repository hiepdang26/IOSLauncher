package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class dj {
    public final jl1 a;

    public dj(jl1 jl1Var) {
        qg0.l(jl1Var, "clock");
        this.a = jl1Var;
    }

    public final void a(s60 s60Var) {
        s60Var.a();
        try {
            StringBuilder sb = new StringBuilder("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < ");
            this.a.getClass();
            sb.append(System.currentTimeMillis() - vy1.a);
            sb.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            s60Var.n(sb.toString());
            s60Var.D();
        } finally {
            s60Var.k();
        }
    }
}
