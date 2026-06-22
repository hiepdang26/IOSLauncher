package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class le {
    public static final vh a = new vh(-1, null, null, 0);
    public static final int b = e42.t(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");
    public static final int c = e42.t(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");
    public static final wg1 d = new wg1("BUFFERED", 1);
    public static final wg1 e = new wg1("SHOULD_BUFFER", 1);
    public static final wg1 f = new wg1("S_RESUMING_BY_RCV", 1);
    public static final wg1 g = new wg1("RESUMING_BY_EB", 1);
    public static final wg1 h = new wg1("POISONED", 1);
    public static final wg1 i = new wg1("DONE_RCV", 1);
    public static final wg1 j = new wg1("INTERRUPTED_SEND", 1);
    public static final wg1 k = new wg1("INTERRUPTED_RCV", 1);
    public static final wg1 l = new wg1("CHANNEL_CLOSED", 1);
    public static final wg1 m = new wg1("SUSPEND", 1);
    public static final wg1 n = new wg1("SUSPEND_NO_WAITER", 1);
    public static final wg1 o = new wg1("FAILED", 1);
    public static final wg1 p = new wg1("NO_RECEIVE_RESULT", 1);
    public static final wg1 q = new wg1("CLOSE_HANDLER_CLOSED", 1);
    public static final wg1 r = new wg1("CLOSE_HANDLER_INVOKED", 1);
    public static final wg1 s = new wg1("NO_CLOSE_CAUSE", 1);

    public static final boolean a(fg fgVar, Object obj, jz0 jz0Var) {
        wg1 wg1Var;
        gg ggVar = (gg) fgVar;
        ggVar.getClass();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = gg.m;
            Object obj2 = atomicReferenceFieldUpdater.get(ggVar);
            boolean z = obj2 instanceof sx0;
            wg1Var = hg0.c;
            if (!z) {
                boolean z2 = obj2 instanceof sk;
                wg1Var = null;
                break;
            }
            Object objW = gg.w((sx0) obj2, obj, ggVar.i, jz0Var);
            while (!atomicReferenceFieldUpdater.compareAndSet(ggVar, obj2, objW)) {
                if (atomicReferenceFieldUpdater.get(ggVar) != obj2) {
                    break;
                }
            }
            if (!ggVar.s()) {
                ggVar.l();
            }
        }
        if (wg1Var == null) {
            return false;
        }
        ggVar.m(ggVar.i);
        return true;
    }
}
