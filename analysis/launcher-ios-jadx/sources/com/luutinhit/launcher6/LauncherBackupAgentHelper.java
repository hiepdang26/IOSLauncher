package com.luutinhit.launcher6;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import defpackage.ar1;
import defpackage.ha;
import defpackage.jk0;
import defpackage.sa0;
import defpackage.sl0;
import defpackage.wl0;
import defpackage.xk0;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class LauncherBackupAgentHelper extends BackupAgentHelper {
    public xk0 a;

    public static void a(Context context) {
        SharedPreferences sharedPreferencesQ = ar1.q(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferencesQ.getLong("backup_manager_last_notified", 0L);
        if (jCurrentTimeMillis < j || jCurrentTimeMillis >= j) {
            BackupManager.dataChanged(context.getPackageName());
            sharedPreferencesQ.edit().putLong("backup_manager_last_notified", jCurrentTimeMillis).apply();
        }
    }

    @Override // android.app.backup.BackupAgent
    public final void onCreate() {
        super.onCreate();
        xk0 xk0Var = new xk0(this);
        this.a = xk0Var;
        addHelper("L", xk0Var);
    }

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public final void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) throws Throwable {
        boolean zMoveToNext;
        if (ar1.m) {
            jk0.c().a();
            try {
                super.onRestore(backupDataInput, i, parcelFileDescriptor);
                Cursor cursorQuery = getContentResolver().query(wl0.a, null, null, null, null);
                zMoveToNext = cursorQuery.moveToNext();
                cursorQuery.close();
            } catch (Exception unused) {
                zMoveToNext = false;
            }
            if (!zMoveToNext || !this.a.o) {
                jk0.c().a();
                return;
            }
            ar1.q(jk0.c().getContext()).edit().remove("EMPTY_DATABASE_CREATED").apply();
            ar1.q(this).edit().putBoolean("cling_gel.workspace.dismissed", true).apply();
            if (this.a.p <= 3) {
                sl0.C(false, jk0.c().h.getWritableDatabase());
            }
            if (sa0.q) {
                if (this.a.m != null) {
                    Context applicationContext = getApplicationContext();
                    xk0 xk0Var = this.a;
                    HashSet hashSet = xk0Var.n;
                    ha haVar = xk0Var.m;
                    ar1.q(applicationContext).edit().putString("migration_src_workspace_size", sa0.e((int) haVar.c, (int) haVar.b)).putString("migration_src_hotseat_size", sa0.e((int) haVar.d, haVar.e)).putStringSet("migration_widget_min_size", hashSet).apply();
                }
            }
            sl0 sl0Var = jk0.c().h;
            sl0Var.n(sl0Var.getWritableDatabase());
        }
    }
}
