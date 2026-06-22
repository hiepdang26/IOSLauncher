package defpackage;

import com.luutinhit.launcher6.u;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class nl0 implements Runnable {
    public final /* synthetic */ hl0 g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ u k;

    public nl0(u uVar, hl0 hl0Var, ArrayList arrayList, int i, int i2) {
        this.k = uVar;
        this.g = hl0Var;
        this.h = arrayList;
        this.i = i;
        this.j = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        hl0 hl0VarL = this.k.l(this.g);
        if (hl0VarL != null) {
            int i = this.j;
            int i2 = this.i;
            hl0VarL.bindItems(this.h, i2, i + i2, false);
        }
    }
}
