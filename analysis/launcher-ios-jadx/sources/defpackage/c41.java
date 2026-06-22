package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class c41 implements cs {
    public static final String[] q = {"_data"};
    public final Context g;
    public final lu0 h;
    public final lu0 i;
    public final Uri j;
    public final int k;
    public final int l;
    public final g01 m;
    public final Class n;
    public volatile boolean o;
    public volatile cs p;

    public c41(Context context, lu0 lu0Var, lu0 lu0Var2, Uri uri, int i, int i2, g01 g01Var, Class cls) {
        this.g = context.getApplicationContext();
        this.h = lu0Var;
        this.i = lu0Var2;
        this.j = uri;
        this.k = i;
        this.l = i2;
        this.m = g01Var;
        this.n = cls;
    }

    @Override // defpackage.cs
    public final Class a() {
        return this.n;
    }

    @Override // defpackage.cs
    public final void b() {
        cs csVar = this.p;
        if (csVar != null) {
            csVar.b();
        }
    }

    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) throws Throwable {
        try {
            cs csVarE = e();
            if (csVarE == null) {
                bsVar.e(new IllegalArgumentException("Failed to build fetcher for: " + this.j));
            } else {
                this.p = csVarE;
                if (this.o) {
                    cancel();
                } else {
                    csVarE.c(j31Var, bsVar);
                }
            }
        } catch (FileNotFoundException e) {
            bsVar.e(e);
        }
    }

    @Override // defpackage.cs
    public final void cancel() {
        this.o = true;
        cs csVar = this.p;
        if (csVar != null) {
            csVar.cancel();
        }
    }

    @Override // defpackage.cs
    public final int d() {
        return 1;
    }

    public final cs e() throws Throwable {
        ku0 ku0VarB;
        boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.g;
        g01 g01Var = this.m;
        int i = this.l;
        int i2 = this.k;
        if (zIsExternalStorageLegacy) {
            Uri uri = this.j;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, q, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            cursorQuery.close();
                            ku0VarB = this.h.b(file, i2, i, g01Var);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Uri requireOriginal = this.j;
            boolean zI = e42.i(requireOriginal);
            lu0 lu0Var = this.i;
            if (zI && requireOriginal.getPathSegments().contains("picker")) {
                ku0VarB = lu0Var.b(requireOriginal, i2, i, g01Var);
            } else {
                if (context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                    requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
                }
                ku0VarB = lu0Var.b(requireOriginal, i2, i, g01Var);
            }
        }
        if (ku0VarB != null) {
            return ku0VarB.c;
        }
        return null;
    }
}
