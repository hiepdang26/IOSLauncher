package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class xl {
    public boolean a;
    public String[] b;
    public String[] c;
    public boolean d;

    public xl(boolean z) {
        this.a = z;
    }

    public final void a(qi... qiVarArr) {
        if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[qiVarArr.length];
        for (int i = 0; i < qiVarArr.length; i++) {
            strArr[i] = qiVarArr[i].a;
        }
        b(strArr);
    }

    public final void b(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        }
        this.b = (String[]) strArr.clone();
    }

    public final void c(do1... do1VarArr) {
        if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        String[] strArr = new String[do1VarArr.length];
        for (int i = 0; i < do1VarArr.length; i++) {
            strArr[i] = do1VarArr[i].g;
        }
        d(strArr);
    }

    public final void d(String... strArr) {
        if (!this.a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        }
        this.c = (String[]) strArr.clone();
    }
}
