package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public final class cw1 extends SQLiteOpenHelper {
    public static cw1 i;
    public final /* synthetic */ int g = 0;
    public Object h;

    public /* synthetic */ cw1(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        switch (this.g) {
            case 0:
                sQLiteDatabase.execSQL((String) this.h);
                break;
            default:
                ((pa0) this.h).g(sQLiteDatabase);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        switch (this.g) {
            case 1:
                if (i2 != i3) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat((String) ((pa0) this.h).b));
                    onCreate(sQLiteDatabase);
                }
                break;
            default:
                super.onDowngrade(sQLiteDatabase, i2, i3);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        switch (this.g) {
            case 0:
                break;
            default:
                if (i2 != i3) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat((String) ((pa0) this.h).b));
                    onCreate(sQLiteDatabase);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw1(pa0 pa0Var, Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.h = pa0Var;
    }

    private final void a(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
