package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ku implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ lu h;

    public /* synthetic */ ku(lu luVar, int i) {
        this.g = i;
        this.h = luVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                lu.a(this.h);
                break;
            default:
                lu.c(this.h);
                break;
        }
    }
}
