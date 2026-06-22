package defpackage;

import android.app.Activity;
import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
public final class cb1 extends v5 {
    public final void a(Activity activity) {
        PendingIntent pendingIntent = this.g.i;
        if (pendingIntent != null) {
            hg0.i(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 33, null, 0, 0, 0);
        }
    }
}
