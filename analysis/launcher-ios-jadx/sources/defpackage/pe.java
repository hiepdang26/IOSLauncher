package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class pe {
    public final /* synthetic */ int a;

    public final int a(Object obj) {
        switch (this.a) {
            case 0:
                return ((byte[]) obj).length;
            default:
                return ((int[]) obj).length;
        }
    }

    public final int b() {
        switch (this.a) {
            case 0:
                return 1;
            default:
                return 4;
        }
    }

    public final String c() {
        switch (this.a) {
            case 0:
                return "ByteArrayPool";
            default:
                return "IntegerArrayPool";
        }
    }
}
