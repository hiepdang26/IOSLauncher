package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class hc implements ib1 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ hc(Object obj, Object obj2, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // defpackage.ib1
    public final eb1 a(Object obj, int i, int i2, g01 g01Var) {
        k81 k81Var;
        boolean z;
        b10 b10Var;
        switch (this.a) {
            case 0:
                eb1 eb1VarA = ((ib1) this.b).a(obj, i, i2, g01Var);
                if (eb1VarA == null) {
                    return null;
                }
                return new pc((Resources) this.c, eb1VarA);
            case 1:
                eb1 eb1VarC = ((kb1) this.b).c((Uri) obj, g01Var);
                if (eb1VarC == null) {
                    return null;
                }
                return az1.e((oc) this.c, (Drawable) ((m80) eb1VarC).get(), i, i2);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof k81) {
                    k81Var = (k81) inputStream;
                    z = false;
                } else {
                    k81Var = new k81(inputStream, (cq0) this.c);
                    z = true;
                }
                ArrayDeque arrayDeque = b10.i;
                synchronized (arrayDeque) {
                    b10Var = (b10) arrayDeque.poll();
                    break;
                }
                if (b10Var == null) {
                    b10Var = new b10();
                }
                b10 b10Var2 = b10Var;
                b10Var2.g = k81Var;
                vq0 vq0Var = new vq0(b10Var2);
                oz1 oz1Var = new oz1(k81Var, b10Var2, 7);
                try {
                    jw jwVar = (jw) this.b;
                    pc pcVarA = jwVar.a(new wb2(vq0Var, jwVar.d, jwVar.c), i, i2, g01Var, oz1Var);
                    b10Var2.a();
                    if (z) {
                        k81Var.b();
                    }
                    return pcVarA;
                } finally {
                }
        }
    }

    @Override // defpackage.ib1
    public final boolean b(Object obj, g01 g01Var) {
        switch (this.a) {
            case 0:
                return ((ib1) this.b).b(obj, g01Var);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                ((jw) this.b).getClass();
                return true;
        }
    }

    public hc(Resources resources, ib1 ib1Var) {
        this.a = 0;
        this.c = resources;
        this.b = ib1Var;
    }
}
