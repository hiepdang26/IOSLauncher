package defpackage;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public final class xx0 extends fb {
    public IconCompat h;
    public IconCompat i;
    public boolean j;

    @Override // defpackage.fb
    public final void a(qm0 qm0Var) {
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle((Notification.Builder) qm0Var.b).setBigContentTitle(null);
        IconCompat iconCompat = this.h;
        Context context = (Context) qm0Var.a;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                wx0.a(bigContentTitle, iconCompat.g(context));
            } else if (iconCompat.e() == 1) {
                bigContentTitle = bigContentTitle.bigPicture(this.h.c());
            }
        }
        if (this.j) {
            IconCompat iconCompat2 = this.i;
            if (iconCompat2 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else if (Build.VERSION.SDK_INT >= 23) {
                vx0.a(bigContentTitle, iconCompat2.g(context));
            } else if (iconCompat2.e() == 1) {
                bigContentTitle.bigLargeIcon(this.i.c());
            } else {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            wx0.c(bigContentTitle, false);
            wx0.b(bigContentTitle, null);
        }
    }

    @Override // defpackage.fb
    public final String b() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }
}
