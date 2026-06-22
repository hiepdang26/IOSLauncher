package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class vv {
    public final String a;
    public final long[] b;
    public final File[] c;
    public final File[] d;
    public boolean e;
    public uv f;
    public final /* synthetic */ wv g;

    public vv(wv wvVar, String str) {
        this.g = wvVar;
        this.a = str;
        int i = wvVar.m;
        this.b = new long[i];
        this.c = new File[i];
        this.d = new File[i];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i2 = 0; i2 < wvVar.m; i2++) {
            sb.append(i2);
            File[] fileArr = this.c;
            String string = sb.toString();
            File file = wvVar.g;
            fileArr[i2] = new File(file, string);
            sb.append(".tmp");
            this.d[i2] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (long j : this.b) {
            sb.append(' ');
            sb.append(j);
        }
        return sb.toString();
    }
}
