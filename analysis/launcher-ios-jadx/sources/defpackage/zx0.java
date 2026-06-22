package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zx0 {
    public final Context a;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public IconCompat h;
    public int i;
    public fb k;
    public Bundle m;
    public String n;
    public final boolean o;
    public final Notification p;
    public final ArrayList q;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final boolean j = true;
    public boolean l = false;

    public zx0(Context context, String str) {
        Notification notification = new Notification();
        this.p = notification;
        this.a = context;
        this.n = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.i = 0;
        this.q = new ArrayList();
        this.o = true;
    }

    public static CharSequence b(String str) {
        return (str != null && str.length() > 5120) ? str.subSequence(0, 5120) : str;
    }

    public final Notification a() {
        Notification notificationBuild;
        Bundle bundle;
        qm0 qm0Var = new qm0(this);
        zx0 zx0Var = (zx0) qm0Var.c;
        fb fbVar = zx0Var.k;
        if (fbVar != null) {
            fbVar.a(qm0Var);
        }
        int i = Build.VERSION.SDK_INT;
        Notification.Builder builder = (Notification.Builder) qm0Var.b;
        if (i < 26 && i < 24) {
            builder.setExtras((Bundle) qm0Var.d);
            notificationBuild = builder.build();
        } else {
            notificationBuild = builder.build();
        }
        if (fbVar != null) {
            zx0Var.k.getClass();
        }
        if (fbVar != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", fbVar.b());
        }
        return notificationBuild;
    }

    public final void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 27) {
            Resources resources = this.a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(a51.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(a51.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
            }
        }
        PorterDuff.Mode mode = IconCompat.k;
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.b = bitmap;
        this.h = iconCompat;
    }

    public final void d(fb fbVar) {
        if (this.k != fbVar) {
            this.k = fbVar;
            if (((zx0) fbVar.g) != this) {
                fbVar.g = this;
                d(fbVar);
            }
        }
    }
}
