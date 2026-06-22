package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class is0 implements cs {
    public static final String[] j = {"_data"};
    public final /* synthetic */ int g;
    public final Object h;
    public final Object i;

    public /* synthetic */ is0(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    @Override // defpackage.cs
    public final Class a() {
        switch (this.g) {
            case 0:
                return File.class;
            default:
                return ((qe) this.i).a();
        }
    }

    @Override // defpackage.cs
    public final void b() {
        int i = this.g;
    }

    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) {
        switch (this.g) {
            case 0:
                Cursor cursorQuery = ((Context) this.h).getContentResolver().query((Uri) this.i, j, null, null, null);
                if (cursorQuery != null) {
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                        cursorQuery.close();
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                    break;
                }
                if (!TextUtils.isEmpty(string)) {
                    bsVar.g(new File(string));
                    return;
                }
                bsVar.e(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.i)));
                return;
            default:
                bsVar.g(((qe) this.i).m((byte[]) this.h));
                return;
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

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
