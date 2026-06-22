package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class t5 {
    public static final t5 a = new t5();

    public final File a(Context context) {
        qg0.l(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        qg0.k(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
