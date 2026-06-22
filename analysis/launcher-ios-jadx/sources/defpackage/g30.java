package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class g30 extends h30 {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ g30(int i, int i2) {
        this.b = i2;
        this.c = i;
    }

    @Override // defpackage.h30
    public final int a(int i) {
        switch (this.b) {
            case 0:
                return i | this.c;
            default:
                return i & (~this.c);
        }
    }
}
