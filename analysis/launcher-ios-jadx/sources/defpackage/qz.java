package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class qz implements cf0 {
    public final boolean g;

    public qz(boolean z) {
        this.g = z;
    }

    @Override // defpackage.cf0
    public final boolean a() {
        return this.g;
    }

    @Override // defpackage.cf0
    public final px0 f() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.g ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
