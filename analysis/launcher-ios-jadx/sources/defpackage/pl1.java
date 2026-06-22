package defpackage;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;

/* JADX INFO: loaded from: classes.dex */
public final class pl1 {
    public final ComponentName a;
    public final jl1 b;

    static {
        ka0.r("SystemJobInfoConverter");
    }

    public pl1(Context context, jl1 jl1Var) {
        this.b = jl1Var;
        this.a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
