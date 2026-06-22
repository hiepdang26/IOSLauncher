package defpackage;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Configuration;
import android.icu.text.DecimalFormatSymbols;
import android.os.LocaleList;
import android.os.UserManager;
import android.view.PointerIcon;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class sl {
    public static boolean a(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static LocaleList b(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    public static DecimalFormatSymbols c(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }

    public static LocaleList d(Configuration configuration) {
        return configuration.getLocales();
    }

    public static PointerIcon e(Context context) {
        return PointerIcon.getSystemIcon(context, 1002);
    }

    public static boolean f(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }

    public static void g(Notification.Action.Builder builder, boolean z) {
        builder.setAllowGeneratedReplies(z);
    }

    public static void h(Notification.Builder builder) {
        builder.setRemoteInputHistory(null);
    }
}
