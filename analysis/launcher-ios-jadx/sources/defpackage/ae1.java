package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class ae1 implements Callable {
    public final /* synthetic */ int g;

    public /* synthetic */ ae1(int i) {
        this.g = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.g) {
            case 0:
                return zd1.a;
            case 1:
                return be1.a;
            case 2:
                return ce1.a;
            default:
                return de1.a;
        }
    }
}
