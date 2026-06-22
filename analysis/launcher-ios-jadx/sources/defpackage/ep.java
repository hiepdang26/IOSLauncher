package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class ep extends Thread {
    public static final AtomicIntegerFieldUpdater o = AtomicIntegerFieldUpdater.newUpdater(ep.class, "workerCtl");
    public final jz1 g;
    public final t91 h;
    public int i;
    private volatile int indexInArray;
    public long j;
    public long k;
    public int l;
    public boolean m;
    public final /* synthetic */ fp n;
    private volatile Object nextParkedWorker;
    private volatile int workerCtl;

    public ep(fp fpVar, int i) {
        this.n = fpVar;
        setDaemon(true);
        this.g = new jz1();
        this.h = new t91();
        this.i = 4;
        this.nextParkedWorker = fp.q;
        s sVar = w71.g;
        this.l = w71.g.a().nextInt();
        f(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r12 = defpackage.jz1.d.get(r3);
        r0 = defpackage.jz1.c.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r12 == r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (defpackage.jz1.e.get(r3) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r0 = r0 - 1;
        r5 = r3.c(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        if (r5 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r2 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.om1 a(boolean r12) {
        /*
            r11 = this;
            int r0 = r11.i
            r1 = 1
            r2 = 0
            jz1 r3 = r11.g
            fp r4 = r11.n
            if (r0 != r1) goto Lc
            goto L86
        Lc:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.fp.o
        Le:
            fp r6 = r11.n
            long r7 = r0.get(r6)
            r9 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r7
            r5 = 42
            long r9 = r9 >> r5
            int r5 = (int) r9
            if (r5 != 0) goto L75
            r3.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = defpackage.jz1.b
            java.lang.Object r0 = r12.get(r3)
            om1 r0 = (defpackage.om1) r0
            if (r0 != 0) goto L2e
            goto L43
        L2e:
            cx r5 = r0.h
            int r5 = r5.g
            if (r5 != r1) goto L43
        L34:
            boolean r5 = r12.compareAndSet(r3, r0, r2)
            if (r5 == 0) goto L3c
            r2 = r0
            goto L63
        L3c:
            java.lang.Object r5 = r12.get(r3)
            if (r5 == r0) goto L34
            goto L23
        L43:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = defpackage.jz1.d
            int r12 = r12.get(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.jz1.c
            int r0 = r0.get(r3)
        L4f:
            if (r12 == r0) goto L63
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = defpackage.jz1.e
            int r5 = r5.get(r3)
            if (r5 != 0) goto L5a
            goto L63
        L5a:
            int r0 = r0 + (-1)
            om1 r5 = r3.c(r0, r1)
            if (r5 == 0) goto L4f
            r2 = r5
        L63:
            if (r2 != 0) goto L74
            y90 r12 = r4.l
            java.lang.Object r12 = r12.d()
            om1 r12 = (defpackage.om1) r12
            if (r12 != 0) goto L73
            om1 r12 = r11.i(r1)
        L73:
            return r12
        L74:
            return r2
        L75:
            r9 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r9 = r7 - r9
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = defpackage.fp.o
            boolean r5 = r5.compareAndSet(r6, r7, r9)
            if (r5 == 0) goto Le
            r11.i = r1
        L86:
            if (r12 == 0) goto Lba
            int r12 = r4.g
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L93
            goto L94
        L93:
            r1 = 0
        L94:
            if (r1 == 0) goto L9d
            om1 r12 = r11.e()
            if (r12 == 0) goto L9d
            return r12
        L9d:
            r3.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = defpackage.jz1.b
            java.lang.Object r12 = r12.getAndSet(r3, r2)
            om1 r12 = (defpackage.om1) r12
            if (r12 != 0) goto Lae
            om1 r12 = r3.b()
        Lae:
            if (r12 == 0) goto Lb1
            return r12
        Lb1:
            if (r1 != 0) goto Lc1
            om1 r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lba:
            om1 r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lc1:
            r12 = 3
            om1 r12 = r11.i(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ep.a(boolean):om1");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.l;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.l = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i5 & i6 : (i5 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % i;
    }

    public final om1 e() {
        int iD = d(2);
        fp fpVar = this.n;
        if (iD == 0) {
            om1 om1Var = (om1) fpVar.k.d();
            return om1Var != null ? om1Var : (om1) fpVar.l.d();
        }
        om1 om1Var2 = (om1) fpVar.l.d();
        return om1Var2 != null ? om1Var2 : (om1) fpVar.k.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.n.j);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i) {
        int i2 = this.i;
        boolean z = i2 == 1;
        if (z) {
            fp.o.addAndGet(this.n, 4398046511104L);
        }
        if (i2 != i) {
            this.i = i;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
    
        r7 = -2;
        r23 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.om1 i(int r26) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ep.i(int):om1");
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ep.run():void");
    }
}
