package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class j80 {
    public final boolean a;

    public j80(boolean z) {
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j80)) {
            return false;
        }
        j80 j80Var = (j80) obj;
        j80Var.getClass();
        return this.a == j80Var.a;
    }

    public final int hashCode() {
        return 1169068184 + (this.a ? 1231 : 1237);
    }

    public final String toString() {
        return "GetTopicsRequest: adsSdkName=com.google.android.gms.ads, shouldRecordObservation=" + this.a;
    }
}
