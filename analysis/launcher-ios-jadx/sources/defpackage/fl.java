package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class fl extends hg0 {
    public final /* synthetic */ int l;
    public final Object m;

    public /* synthetic */ fl(Object obj, int i) {
        this.l = i;
        this.m = obj;
    }

    @Override // defpackage.hg0
    public final void x(String str) {
        switch (this.l) {
            case 0:
                ((PrintStream) this.m).println((Object) str);
                break;
            default:
                ((PrintWriter) this.m).println((Object) str);
                break;
        }
    }
}
