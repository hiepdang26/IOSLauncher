package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class e3 {
    public final String a;
    public final boolean b;

    public e3(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final String toString() {
        String str = this.a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
        sb.append("{");
        sb.append(str);
        sb.append("}");
        sb.append(this.b);
        return sb.toString();
    }
}
