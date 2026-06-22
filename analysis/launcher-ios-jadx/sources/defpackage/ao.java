package defpackage;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.view.MenuItem;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public abstract class ao {
    public static Notification.Builder a(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static Icon b(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }

    public static float c(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float d(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    public static void e(MenuItem menuItem, char c, int i) {
        menuItem.setAlphabeticShortcut(c, i);
    }

    public static void f(Notification.Builder builder) {
        builder.setBadgeIconType(0);
    }

    public static void g(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setContentDescription(charSequence);
    }

    public static void h(Notification.Builder builder) {
        builder.setGroupAlertBehavior(0);
    }

    public static void i(MenuItem menuItem, ColorStateList colorStateList) {
        menuItem.setIconTintList(colorStateList);
    }

    public static void j(MenuItem menuItem, PorterDuff.Mode mode) {
        menuItem.setIconTintMode(mode);
    }

    public static void k(MenuItem menuItem, char c, int i) {
        menuItem.setNumericShortcut(c, i);
    }

    public static void l(Notification.Builder builder) {
        builder.setSettingsText(null);
    }

    public static void m(Notification.Builder builder) {
        builder.setShortcutId(null);
    }

    public static void n(Notification.Builder builder) {
        builder.setTimeoutAfter(0L);
    }

    public static void o(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setTooltipText(charSequence);
    }

    public static void p(Context context, Intent intent) {
        context.startForegroundService(intent);
    }
}
