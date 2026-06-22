package defpackage;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.internal.ads.zzbbw;

/* JADX INFO: loaded from: classes.dex */
public class md2 extends id2 {
    @Override // defpackage.i22
    public final Intent b(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }

    @Override // defpackage.i22
    public final zzbbc.zzq c(Context context, TelephonyManager telephonyManager) {
        cd2 cd2Var = hd2.B.c;
        return cd2.a(context, "android.permission.ACCESS_NETWORK_STATE") ? telephonyManager.isDataEnabled() ? zzbbc.zzq.ENUM_TRUE : zzbbc.zzq.ENUM_FALSE : zzbbc.zzq.ENUM_FALSE;
    }

    @Override // defpackage.i22
    public final void d(Context context) {
        bd2.d();
        NotificationChannel notificationChannelB = bd2.b(((Integer) n42.d.c.zza(zzbbw.zzhH)).intValue());
        notificationChannelB.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannelB);
    }

    @Override // defpackage.i22
    public final boolean e(Context context) {
        NotificationChannel notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        return notificationChannel != null && notificationChannel.getImportance() == 0;
    }
}
