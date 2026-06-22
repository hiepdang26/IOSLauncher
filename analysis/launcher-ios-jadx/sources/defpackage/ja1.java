package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class ja1 extends la1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ks0 b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ja1(ks0 ks0Var, Object obj, int i) {
        this.a = i;
        this.b = ks0Var;
        this.c = obj;
    }

    @Override // defpackage.la1
    public final long contentLength() {
        switch (this.a) {
            case 0:
                return ((df) this.c).i();
            default:
                return ((File) this.c).length();
        }
    }

    @Override // defpackage.la1
    public final ks0 contentType() {
        switch (this.a) {
        }
        return this.b;
    }

    @Override // defpackage.la1
    public final void writeTo(ne neVar) {
        Object obj = this.c;
        switch (this.a) {
            case 0:
                neVar.w((df) obj);
                return;
            default:
                Logger logger = jy0.a;
                n9 n9Var = new n9(new yn1(), new FileInputStream((File) obj));
                try {
                    neVar.o(n9Var);
                    n9Var.close();
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            n9Var.close();
                            break;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
        }
    }
}
