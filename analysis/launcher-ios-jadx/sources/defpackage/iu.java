package defpackage;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class iu extends Handler implements MessageQueue.IdleHandler {
    public final /* synthetic */ q11 g;

    public iu(q11 q11Var) {
        this.g = q11Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        synchronized (((LinkedList) this.g.h)) {
            try {
                if (((LinkedList) this.g.h).size() == 0) {
                    return;
                }
                ((Runnable) ((LinkedList) this.g.h).removeFirst()).run();
                synchronized (((LinkedList) this.g.h)) {
                    q11 q11Var = this.g;
                    LinkedList linkedList = (LinkedList) q11Var.h;
                    if (linkedList.size() > 0) {
                        ((iu) q11Var.i).sendEmptyMessage(1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        handleMessage(null);
        return false;
    }
}
