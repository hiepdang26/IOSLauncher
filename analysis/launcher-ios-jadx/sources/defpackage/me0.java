package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class me0 extends pa0 {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ me0(Context context, String str, int i, String str2, int i2) {
        super(context, str, i, str2);
        this.d = i2;
    }

    @Override // defpackage.pa0
    public final void g(SQLiteDatabase sQLiteDatabase) {
        switch (this.d) {
            case 0:
                Objects.toString(sQLiteDatabase);
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS icons (_id INTEGER PRIMARY KEY AUTOINCREMENT, componentName TEXT NOT NULL, profileId INTEGER NOT NULL, lastUpdated INTEGER NOT NULL DEFAULT 0, version INTEGER NOT NULL DEFAULT 0, icon BLOB, icon_low_res BLOB, label TEXT, system_state TEXT, history INTEGER NOT NULL DEFAULT 0,customIcon INTEGER NOT NULL DEFAULT 0,iconName TEXT, data1 INTEGER NOT NULL DEFAULT 0,data2 INTEGER NOT NULL DEFAULT 0,data3 INTEGER NOT NULL DEFAULT 0,data4 TEXT, data5 TEXT, data6 TEXT, UNIQUE (_id, componentName, profileId) );");
                break;
            default:
                Objects.toString(sQLiteDatabase);
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shortcut_and_widget_previews (componentName TEXT NOT NULL, profileId INTEGER NOT NULL, size TEXT NOT NULL, packageName TEXT NOT NULL, lastUpdated INTEGER NOT NULL DEFAULT 0, version INTEGER NOT NULL DEFAULT 0, preview_bitmap BLOB, PRIMARY KEY (componentName, profileId, size) );");
                break;
        }
    }
}
