package defpackage;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public final class o50 {
    public final int a;
    public final int b;
    public final Notification c;

    public o50(int i, Notification notification, int i2) {
        this.a = i;
        this.c = notification;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o50.class != obj.getClass()) {
            return false;
        }
        o50 o50Var = (o50) obj;
        if (this.a == o50Var.a && this.b == o50Var.b) {
            return this.c.equals(o50Var.c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() + (((this.a * 31) + this.b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}
