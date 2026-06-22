package defpackage;

import android.view.View;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class y3 implements View.OnClickListener {
    public final /* synthetic */ c4 g;

    public y3(c4 c4Var) {
        this.g = c4Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c4 c4Var = this.g;
        t tVar = c4Var.j;
        c4Var.getClass();
        tVar.startActivitySafely(view, null, null);
    }
}
