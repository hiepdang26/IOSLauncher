package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class go1 {
    public final long a;
    public final long b;
    public final int c;

    public go1(long j, long j2, int i) {
        this.a = j;
        this.b = j2;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof go1)) {
            return false;
        }
        go1 go1Var = (go1) obj;
        return this.a == go1Var.a && this.b == go1Var.b && this.c == go1Var.c;
    }

    public final int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.b;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TaxonomyVersion=");
        sb.append(this.a);
        sb.append(", ModelVersion=");
        sb.append(this.b);
        sb.append(", TopicCode=");
        return "Topic { " + uo.j(sb, this.c, " }");
    }
}
