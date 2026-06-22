package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class z90 extends eb implements s5 {
    public final Set a;

    /* JADX WARN: Illegal instructions before constructor call */
    public z90(Context context, Looper looper, int i, mj mjVar, fa0 fa0Var, ga0 ga0Var) {
        ad2 ad2VarA = aa0.a(context);
        da0 da0Var = da0.d;
        hg0.i(fa0Var);
        hg0.i(ga0Var);
        super(context, looper, ad2VarA, da0Var, i, new ew1(fa0Var, 3), new iw1(ga0Var), (String) mjVar.e);
        Set set = (Set) mjVar.b;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.a = set;
    }

    @Override // defpackage.s5
    public final Set a() {
        return requiresSignIn() ? this.a : Collections.EMPTY_SET;
    }

    @Override // defpackage.eb
    public final Account getAccount() {
        return null;
    }

    @Override // defpackage.eb
    public final Executor getBindServiceExecutor() {
        return null;
    }

    @Override // defpackage.eb
    public final Set getScopes() {
        return this.a;
    }
}
