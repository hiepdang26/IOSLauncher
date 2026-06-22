package defpackage;

import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: loaded from: classes.dex */
public abstract class wl0 implements BaseColumns {
    public static final Uri a = Uri.parse("content://com.luutinhit.launcherios.settings/favorites");

    public static Uri a(long j) {
        return Uri.parse("content://com.luutinhit.launcherios.settings/favorites/" + j);
    }
}
