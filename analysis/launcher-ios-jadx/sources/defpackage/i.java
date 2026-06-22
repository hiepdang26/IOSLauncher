package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class i extends Throwable {
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, int i) {
        super(str);
        this.g = i;
    }

    private final synchronized Throwable a() {
        return this;
    }

    private final synchronized Throwable b() {
        return this;
    }

    private final synchronized Throwable c() {
        return this;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        switch (this.g) {
            case 0:
                a();
                break;
            case 1:
                b();
                break;
            default:
                c();
                break;
        }
        return this;
    }
}
