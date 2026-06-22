package defpackage;

import android.app.AppOpsManager;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
public abstract class d7 {
    public static String a(Context context) {
        return context.getOpPackageName();
    }

    public static AppOpsManager b(Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }

    public static Insets c(int i, int i2, int i3, int i4) {
        return Insets.of(i, i2, i3, i4);
    }

    public static void d(Resources.Theme theme) {
        theme.rebase();
    }

    public static void e(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void f(Notification.Builder builder) {
        builder.setBubbleMetadata(null);
    }

    public static void g(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
