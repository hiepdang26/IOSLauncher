package defpackage;

import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kj0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ t h;

    public /* synthetic */ kj0(t tVar, int i) {
        this.g = i;
        this.h = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                t.d(this.h);
                break;
            case 1:
                t tVar = this.h;
                if (tVar.autoRearrange) {
                    tVar.rearrangeApps(false);
                }
                break;
            default:
                t.a(this.h);
                break;
        }
    }
}
