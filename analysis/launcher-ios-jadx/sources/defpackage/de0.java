package defpackage;

import com.luutinhit.launcher6.ioslauncher.IOSLauncher;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class de0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ IOSLauncher h;

    public /* synthetic */ de0(IOSLauncher iOSLauncher, int i) {
        this.g = i;
        this.h = iOSLauncher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.lambda$startPlayOpenAnimation$7();
                break;
            default:
                this.h.lambda$resumeNormalHomeState$6();
                break;
        }
    }
}
