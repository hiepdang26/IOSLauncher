package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t8 implements Executor {
    public final /* synthetic */ int g;

    public /* synthetic */ t8(int i) {
        this.g = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.g) {
            case 0:
                u8.u().l.m.execute(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
