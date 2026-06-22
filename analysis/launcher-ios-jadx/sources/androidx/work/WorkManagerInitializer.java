package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import defpackage.az1;
import defpackage.cz1;
import defpackage.jl1;
import defpackage.ka0;
import defpackage.rl;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements Initializer<az1> {
    static {
        ka0.r("WrkMgrInitializer");
    }

    @Override // androidx.startup.Initializer
    public final az1 create(Context context) {
        ka0.j().getClass();
        cz1.P(context, new rl(new jl1(12)));
        return cz1.O(context);
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
