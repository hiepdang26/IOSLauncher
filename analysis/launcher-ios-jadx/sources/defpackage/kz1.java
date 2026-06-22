package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class kz1 {
    public String a;
    public int b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kz1)) {
            return false;
        }
        kz1 kz1Var = (kz1) obj;
        return qg0.d(this.a, kz1Var.a) && this.b == kz1Var.b;
    }

    public final int hashCode() {
        return uo.v(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("IdAndState(id=");
        sb.append(this.a);
        sb.append(", state=");
        switch (this.b) {
            case 1:
                str = "ENQUEUED";
                break;
            case 2:
                str = "RUNNING";
                break;
            case 3:
                str = "SUCCEEDED";
                break;
            case 4:
                str = "FAILED";
                break;
            case 5:
                str = "BLOCKED";
                break;
            case 6:
                str = "CANCELLED";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append(')');
        return sb.toString();
    }
}
