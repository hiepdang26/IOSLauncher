package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.a;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class ex implements ro1 {
    public final ro1 b;
    public final boolean c;

    public ex(ro1 ro1Var, boolean z) {
        this.b = ro1Var;
        this.c = z;
    }

    @Override // defpackage.ro1
    public final eb1 a(Context context, eb1 eb1Var, int i, int i2) {
        oc ocVar = a.a(context).g;
        Drawable drawable = (Drawable) eb1Var.get();
        pc pcVarE = az1.e(ocVar, drawable, i, i2);
        if (pcVarE != null) {
            eb1 eb1VarA = this.b.a(context, pcVarE, i, i2);
            if (!eb1VarA.equals(pcVarE)) {
                return new pc(context.getResources(), eb1VarA);
            }
            eb1VarA.recycle();
            return eb1Var;
        }
        if (!this.c) {
            return eb1Var;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof ex) {
            return this.b.equals(((ex) obj).b);
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return this.b.hashCode();
    }
}
