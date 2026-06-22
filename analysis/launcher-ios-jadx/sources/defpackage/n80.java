package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class n80 implements ro1 {
    public final ro1 b;

    public n80(ro1 ro1Var) {
        n90.h(ro1Var, "Argument must not be null");
        this.b = ro1Var;
    }

    @Override // defpackage.ro1
    public final eb1 a(Context context, eb1 eb1Var, int i, int i2) {
        l80 l80Var = (l80) eb1Var.get();
        eb1 pcVar = new pc(a.a(context).g, ((r80) l80Var.g.b).l);
        ro1 ro1Var = this.b;
        eb1 eb1VarA = ro1Var.a(context, pcVar, i, i2);
        if (!pcVar.equals(eb1VarA)) {
            pcVar.recycle();
        }
        ((r80) l80Var.g.b).c(ro1Var, (Bitmap) eb1VarA.get());
        return eb1Var;
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof n80) {
            return this.b.equals(((n80) obj).b);
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return this.b.hashCode();
    }
}
