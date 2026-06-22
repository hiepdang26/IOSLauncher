package defpackage;

import android.util.Pair;
import android.view.View;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mj0 implements View.OnClickListener {
    public final /* synthetic */ t g;
    public final /* synthetic */ qh0 h;
    public final /* synthetic */ Pair i;

    public /* synthetic */ mj0(t tVar, qh0 qh0Var, Pair pair) {
        this.g = tVar;
        this.h = qh0Var;
        this.i = pair;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        t.b(this.g, this.h, this.i);
    }
}
