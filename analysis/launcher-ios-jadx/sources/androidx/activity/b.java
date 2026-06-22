package androidx.activity;

import defpackage.b60;
import defpackage.en0;
import defpackage.h60;
import defpackage.o1;
import defpackage.vm0;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final o1 a;
    public final ArrayDeque b = new ArrayDeque();

    public b(o1 o1Var) {
        this.a = o1Var;
    }

    public final void a(en0 en0Var, b60 b60Var) {
        androidx.lifecycle.a aVarL = en0Var.l();
        if (aVarL.c == vm0.g) {
            return;
        }
        b60Var.b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, aVarL, b60Var));
    }

    public final void b() {
        Iterator itDescendingIterator = this.b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            b60 b60Var = (b60) itDescendingIterator.next();
            if (b60Var.a) {
                h60 h60Var = b60Var.c;
                h60Var.x(true);
                if (h60Var.h.a) {
                    h60Var.K();
                    return;
                } else {
                    h60Var.g.b();
                    return;
                }
            }
        }
        o1 o1Var = this.a;
        if (o1Var != null) {
            o1Var.run();
        }
    }
}
