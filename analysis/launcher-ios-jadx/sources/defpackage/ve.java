package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ve implements cs {
    public final /* synthetic */ int g;
    public final Object h;

    public /* synthetic */ ve(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.cs
    public final Class a() {
        switch (this.g) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.h.getClass();
        }
    }

    @Override // defpackage.cs
    public final void b() {
        int i = this.g;
    }

    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) {
        switch (this.g) {
            case 0:
                try {
                    bsVar.g(cf.a((File) this.h));
                } catch (IOException e) {
                    Log.isLoggable("ByteBufferFileLoader", 3);
                    bsVar.e(e);
                    return;
                }
                break;
            default:
                bsVar.g(this.h);
                break;
        }
    }

    @Override // defpackage.cs
    public final void cancel() {
        int i = this.g;
    }

    @Override // defpackage.cs
    public final int d() {
        switch (this.g) {
        }
        return 1;
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
