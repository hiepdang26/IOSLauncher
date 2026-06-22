package defpackage;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public final class z60 extends y60 implements xk1 {
    public final SQLiteStatement h;

    public z60(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.h = sQLiteStatement;
    }

    public final int a() {
        return this.h.executeUpdateDelete();
    }
}
