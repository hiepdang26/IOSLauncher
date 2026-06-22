package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class ya1 {
    public final AtomicInteger a;
    public final HashSet b;
    public final PriorityBlockingQueue c;
    public final PriorityBlockingQueue d;
    public final ov e;
    public final q11 f;
    public final mc1 g;
    public final cx0[] h;
    public hf i;
    public final ArrayList j;
    public final ArrayList k;

    public ya1(ov ovVar, q11 q11Var) {
        mc1 mc1Var = new mc1(new Handler(Looper.getMainLooper()));
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue();
        this.d = new PriorityBlockingQueue();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = ovVar;
        this.f = q11Var;
        this.h = new cx0[4];
        this.g = mc1Var;
    }

    public final void a() {
        synchronized (this.k) {
            try {
                Iterator it = this.k.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
