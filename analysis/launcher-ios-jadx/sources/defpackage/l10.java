package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class l10 implements Executor {
    public final /* synthetic */ int g;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.g) {
            case 0:
                vq1.f().post(runnable);
                break;
            case 1:
                runnable.run();
                break;
            case 2:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
