package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class im extends jj0 implements d70 {
    public final /* synthetic */ lm g;
    public final /* synthetic */ jm h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im(lm lmVar, jm jmVar) {
        super(0);
        this.g = lmVar;
        this.h = jmVar;
    }

    @Override // defpackage.d70
    public final Object c() {
        fn fnVar = this.g.a;
        jm jmVar = this.h;
        fnVar.getClass();
        synchronized (fnVar.c) {
            if (fnVar.d.remove(jmVar) && fnVar.d.isEmpty()) {
                fnVar.d();
            }
        }
        return zp1.a;
    }
}
