package defpackage;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class il0 implements MessageQueue.IdleHandler {
    public final /* synthetic */ int g;
    public final /* synthetic */ r1 h;

    public /* synthetic */ il0(r1 r1Var, int i) {
        this.g = i;
        this.h = r1Var;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        switch (this.g) {
            case 0:
                this.h.run();
                break;
            default:
                this.h.run();
                break;
        }
        return false;
    }
}
