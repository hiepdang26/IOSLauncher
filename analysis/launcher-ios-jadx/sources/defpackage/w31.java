package defpackage;

import androidx.profileinstaller.ProfileInstaller;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w31 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback h;
    public final /* synthetic */ int i;
    public final /* synthetic */ Object j;

    public /* synthetic */ w31(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj, int i2) {
        this.g = i2;
        this.h = diagnosticsCallback;
        this.i = i;
        this.j = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.onResultReceived(this.i, this.j);
                break;
            default:
                this.h.onDiagnosticReceived(this.i, this.j);
                break;
        }
    }
}
