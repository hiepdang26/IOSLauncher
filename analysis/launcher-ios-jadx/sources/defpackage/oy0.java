package defpackage;

import androidx.activity.b;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class oy0 implements eg {
    public final b60 g;
    public final /* synthetic */ b h;

    public oy0(b bVar, b60 b60Var) {
        this.h = bVar;
        this.g = b60Var;
    }

    @Override // defpackage.eg
    public final void cancel() {
        ArrayDeque arrayDeque = this.h.b;
        b60 b60Var = this.g;
        arrayDeque.remove(b60Var);
        b60Var.b.remove(this);
    }
}
