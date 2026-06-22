package defpackage;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class js implements cs {
    public final /* synthetic */ int g;
    public final Comparable h;
    public final Object i;
    public Object j;

    public /* synthetic */ js(int i, Comparable comparable, Object obj) {
        this.g = i;
        this.h = comparable;
        this.i = obj;
    }

    public static js e(Context context, Uri uri, tn1 tn1Var) {
        return new js(2, uri, new ol1(a.a(context).i.b().f(), tn1Var, a.a(context).j, context.getContentResolver()));
    }

    @Override // defpackage.cs
    public final Class a() {
        switch (this.g) {
            case 0:
                ((iy) this.i).getClass();
                return InputStream.class;
            case 1:
                return ((z20) this.i).a();
            default:
                return InputStream.class;
        }
    }

    @Override // defpackage.cs
    public final void b() {
        switch (this.g) {
            case 0:
                try {
                    ((ByteArrayInputStream) this.j).close();
                } catch (IOException unused) {
                    return;
                }
                break;
            case 1:
                Object obj = this.j;
                if (obj != null) {
                    try {
                        ((z20) this.i).b(obj);
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
            default:
                InputStream inputStream = (InputStream) this.j;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) throws Throwable {
        switch (this.g) {
            case 0:
                try {
                    ByteArrayInputStream byteArrayInputStreamH = iy.h((String) this.h);
                    this.j = byteArrayInputStreamH;
                    bsVar.g(byteArrayInputStreamH);
                } catch (IllegalArgumentException e) {
                    bsVar.e(e);
                }
                break;
            case 1:
                try {
                    Object objP = ((z20) this.i).p((File) this.h);
                    this.j = objP;
                    bsVar.g(objP);
                } catch (FileNotFoundException e2) {
                    Log.isLoggable("FileLoader", 3);
                    bsVar.e(e2);
                    return;
                }
                break;
            default:
                try {
                    InputStream inputStreamI = i();
                    this.j = inputStreamI;
                    bsVar.g(inputStreamI);
                } catch (FileNotFoundException e3) {
                    Log.isLoggable("MediaStoreThumbFetcher", 3);
                    bsVar.e(e3);
                    return;
                }
                break;
        }
    }

    @Override // defpackage.cs
    public final void cancel() {
        int i = this.g;
    }

    @Override // defpackage.cs
    public final int d() {
        switch (this.g) {
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream i() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.js.i():java.io.InputStream");
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
