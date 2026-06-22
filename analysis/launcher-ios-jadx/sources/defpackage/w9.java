package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public interface w9 {
    long generateNewItemId();

    long insertAndCheck(SQLiteDatabase sQLiteDatabase, ContentValues contentValues);
}
