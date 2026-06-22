package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ap extends jj0 implements o70 {
    public static final ap h = new ap(1, 0);
    public static final ap i = new ap(1, 1);
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ap(int i2, int i3) {
        super(i2);
        this.g = i3;
    }

    @Override // defpackage.o70
    public final Object invoke(Object obj) {
        switch (this.g) {
            case 0:
                wo woVar = (wo) obj;
                if (woVar instanceof cp) {
                    return (cp) woVar;
                }
                return null;
            default:
                lm lmVar = (lm) obj;
                qg0.l(lmVar, "it");
                return lmVar.getClass().getSimpleName();
        }
    }
}
