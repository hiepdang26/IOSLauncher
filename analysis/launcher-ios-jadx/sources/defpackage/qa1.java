package defpackage;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class qa1 extends Thread {
    public final int g;

    public qa1(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.g = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.g);
        super.run();
    }
}
