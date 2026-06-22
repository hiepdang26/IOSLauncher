package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public abstract class pa0 {
    public boolean a;
    public final Object b;
    public final Object c;

    public pa0(Context context, String str, int i, String str2) {
        this.b = str2;
        this.c = new cw1(this, context, str, i);
        this.a = false;
    }

    public void a(String str, String[] strArr) {
        if (this.a) {
            return;
        }
        try {
            ((cw1) this.c).getWritableDatabase().delete((String) this.b, str, strArr);
        } catch (SQLiteFullException unused) {
            this.a = true;
        } catch (SQLiteException unused2) {
        }
    }

    public int b(int i, int i2) {
        int iD = d(i);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int iD2 = d(i5);
            i3 += iD2;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = iD2;
            }
        }
        return i3 + iD > i2 ? i4 + 1 : i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0051 -> B:28:0x0056). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0053 -> B:28:0x0056). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0055 -> B:28:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c(int r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.d(r8)
            r1 = 0
            if (r0 != r9) goto L8
            goto L5d
        L8:
            boolean r2 = r7.a
            if (r2 == 0) goto L46
            java.lang.Object r2 = r7.b
            android.util.SparseIntArray r2 = (android.util.SparseIntArray) r2
            int r3 = r2.size()
            int r3 = r3 + (-1)
            r4 = 0
        L17:
            if (r4 > r3) goto L2a
            int r5 = r4 + r3
            int r5 = r5 >>> 1
            int r6 = r2.keyAt(r5)
            if (r6 >= r8) goto L26
            int r4 = r5 + 1
            goto L17
        L26:
            int r5 = r5 + (-1)
            r3 = r5
            goto L17
        L2a:
            int r4 = r4 + (-1)
            if (r4 < 0) goto L39
            int r3 = r2.size()
            if (r4 >= r3) goto L39
            int r3 = r2.keyAt(r4)
            goto L3a
        L39:
            r3 = -1
        L3a:
            if (r3 < 0) goto L46
            int r2 = r2.get(r3)
            int r4 = r7.d(r3)
            int r4 = r4 + r2
            goto L56
        L46:
            r3 = 0
            r4 = 0
        L48:
            if (r3 >= r8) goto L59
            int r2 = r7.d(r3)
            int r4 = r4 + r2
            if (r4 != r9) goto L53
            r4 = 0
            goto L56
        L53:
            if (r4 <= r9) goto L56
            r4 = r2
        L56:
            int r3 = r3 + 1
            goto L48
        L59:
            int r0 = r0 + r4
            if (r0 > r9) goto L5d
            return r4
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pa0.c(int, int):int");
    }

    public abstract int d(int i);

    public void e(ContentValues contentValues) {
        if (this.a) {
            return;
        }
        try {
            ((cw1) this.c).getWritableDatabase().insertWithOnConflict((String) this.b, null, contentValues, 5);
        } catch (SQLiteFullException unused) {
            this.a = true;
        } catch (SQLiteException unused2) {
        }
    }

    public void f() {
        ((SparseIntArray) this.b).clear();
    }

    public abstract void g(SQLiteDatabase sQLiteDatabase);

    public Cursor h(String str, String[] strArr, String[] strArr2) {
        return ((cw1) this.c).getReadableDatabase().query((String) this.b, strArr, str, strArr2, null, null, null);
    }

    public void i(ContentValues contentValues, String[] strArr) {
        if (this.a) {
            return;
        }
        try {
            ((cw1) this.c).getWritableDatabase().update((String) this.b, contentValues, "componentName = ? AND profileId = ?", strArr);
        } catch (SQLiteFullException unused) {
            this.a = true;
        } catch (SQLiteException unused2) {
        }
    }

    public pa0() {
        this.b = new SparseIntArray();
        this.c = new SparseIntArray();
        this.a = false;
    }
}
