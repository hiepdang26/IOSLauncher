package defpackage;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
public final class da0 extends ea0 {
    public static final Object c = new Object();
    public static final da0 d = new da0();

    public static AlertDialog e(Activity activity, int i, i12 i12Var, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(z02.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(t61.common_google_play_services_enable_button) : resources.getString(t61.common_google_play_services_update_button) : resources.getString(t61.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, i12Var);
        }
        String strC = z02.c(activity, i);
        if (strC != null) {
            builder.setTitle(strC);
        }
        new IllegalArgumentException();
        return builder.create();
    }

    public static void f(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof e6) {
                h60 h60VarO = ((e6) activity).o();
                qk1 qk1Var = new qk1();
                hg0.j(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                qk1Var.n0 = alertDialog;
                if (onCancelListener != null) {
                    qk1Var.o0 = onCancelListener;
                }
                qk1Var.k0 = false;
                qk1Var.l0 = true;
                h60VarO.getClass();
                ca caVar = new ca(h60VarO);
                caVar.e(0, qk1Var, str, 1);
                caVar.d(false);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        m00 m00Var = new m00();
        hg0.j(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        m00Var.g = alertDialog;
        if (onCancelListener != null) {
            m00Var.h = onCancelListener;
        }
        m00Var.show(fragmentManager, str);
    }

    public final void d(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogE = e(googleApiActivity, i, new i12(super.b(googleApiActivity, "d", i), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogE == null) {
            return;
        }
        f(googleApiActivity, alertDialogE, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void g(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        new IllegalArgumentException();
        if (i == 18) {
            new c12(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String strE = i == 6 ? z02.e(context, "common_google_play_services_resolution_required_title") : z02.c(context, i);
        if (strE == null) {
            strE = context.getResources().getString(t61.common_google_play_services_notification_ticker);
        }
        String strD = (i == 6 || i == 19) ? z02.d(context, "common_google_play_services_resolution_required_text", z02.a(context)) : z02.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        hg0.i(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        zx0 zx0Var = new zx0(context, null);
        zx0Var.l = true;
        zx0Var.p.flags |= 16;
        zx0Var.e = zx0.b(strE);
        yx0 yx0Var = new yx0();
        yx0Var.h = zx0.b(strD);
        zx0Var.d(yx0Var);
        PackageManager packageManager = context.getPackageManager();
        if (bf1.g == null) {
            bf1.g = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (bf1.g.booleanValue()) {
            zx0Var.p.icon = context.getApplicationInfo().icon;
            zx0Var.i = 2;
            if (bf1.o(context)) {
                zx0Var.b.add(new ux0(j51.common_full_open_on_phone, resources.getString(t61.common_open_on_phone), pendingIntent));
            } else {
                zx0Var.g = pendingIntent;
            }
        } else {
            zx0Var.p.icon = R.drawable.stat_sys_warning;
            zx0Var.p.tickerText = zx0.b(resources.getString(t61.common_google_play_services_notification_ticker));
            zx0Var.p.when = System.currentTimeMillis();
            zx0Var.g = pendingIntent;
            zx0Var.f = zx0.b(strD);
        }
        if (os.j()) {
            if (!os.j()) {
                throw new IllegalStateException();
            }
            synchronized (c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(t61.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(tt.b(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            zx0Var.n = "com.google.android.gms.availability";
        }
        Notification notificationA = zx0Var.a();
        if (i == 1 || i == 2 || i == 3) {
            ja0.a.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationA);
    }

    public final void h(Activity activity, bn0 bn0Var, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogE = e(activity, i, new i12(super.b(activity, "d", i), bn0Var, 1), onCancelListener);
        if (alertDialogE == null) {
            return;
        }
        f(activity, alertDialogE, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
