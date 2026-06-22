package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public final class ux0 {
    public final Bundle a;
    public IconCompat b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final CharSequence f;
    public final PendingIntent g;

    public ux0(int i, String str, PendingIntent pendingIntent) {
        IconCompat iconCompatB = i == 0 ? null : IconCompat.b(i);
        Bundle bundle = new Bundle();
        this.d = true;
        this.b = iconCompatB;
        if (iconCompatB != null && iconCompatB.e() == 2) {
            this.e = iconCompatB.d();
        }
        this.f = zx0.b(str);
        this.g = pendingIntent;
        this.a = bundle;
        this.c = true;
        this.d = true;
    }
}
