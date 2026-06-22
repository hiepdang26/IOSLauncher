package defpackage;

import android.content.Context;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class fv0 implements ro1 {
    public final List b;

    public fv0(ro1... ro1VarArr) {
        if (ro1VarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.b = Arrays.asList(ro1VarArr);
    }

    @Override // defpackage.ro1
    public final eb1 a(Context context, eb1 eb1Var, int i, int i2) {
        Iterator it = this.b.iterator();
        eb1 eb1Var2 = eb1Var;
        while (it.hasNext()) {
            eb1 eb1VarA = ((ro1) it.next()).a(context, eb1Var2, i, i2);
            if (eb1Var2 != null && !eb1Var2.equals(eb1Var) && !eb1Var2.equals(eb1VarA)) {
                eb1Var2.recycle();
            }
            eb1Var2 = eb1VarA;
        }
        return eb1Var2;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((ro1) it.next()).b(messageDigest);
        }
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof fv0) {
            return this.b.equals(((fv0) obj).b);
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return this.b.hashCode();
    }
}
