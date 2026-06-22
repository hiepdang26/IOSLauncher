package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class kx0 extends td1 {
    public static final ad1 b = new ad1(false, "RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    public final ad1 a = b;

    @Override // defpackage.td1
    public final sd1 a() {
        return new lx0(this.a);
    }
}
