package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import defpackage.c22;
import defpackage.cd2;
import defpackage.cy0;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.hr;
import defpackage.k61;
import defpackage.k92;
import defpackage.n42;
import defpackage.r52;
import defpackage.s61;
import defpackage.t51;
import defpackage.tc2;
import defpackage.yb2;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public final class zzeds extends zzbsf {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdsk zzc;
    private final tc2 zzd;
    private final zzedh zze;
    private String zzf;
    private String zzg;

    public zzeds(Context context, zzedh zzedhVar, tc2 tc2Var, zzdsk zzdskVar) {
        this.zzb = context;
        this.zzc = zzdskVar;
        this.zzd = tc2Var;
        this.zze = zzedhVar;
    }

    public static void zzc(Context context, zzdsk zzdskVar, zzedh zzedhVar, String str, String str2) {
        zzd(context, zzdskVar, zzedhVar, str, str2, new HashMap());
    }

    public static void zzd(Context context, zzdsk zzdskVar, zzedh zzedhVar, String str, String str2, Map map) {
        String strZze;
        hd2 hd2Var = hd2.B;
        String str3 = true != hd2Var.g.zzA(context) ? "offline" : hr.ONLINE_EXTRAS_KEY;
        if (zzdskVar != null) {
            zzdsj zzdsjVarZza = zzdskVar.zza();
            zzdsjVarZza.zzb("gqi", str);
            zzdsjVarZza.zzb("action", str2);
            zzdsjVarZza.zzb("device_connectivity", str3);
            hd2Var.j.getClass();
            zzdsjVarZza.zzb("event_timestamp", String.valueOf(System.currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzdsjVarZza.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            strZze = zzdsjVarZza.zze();
        } else {
            strZze = "";
        }
        String str4 = strZze;
        hd2.B.j.getClass();
        zzedhVar.zzd(new zzedj(System.currentTimeMillis(), str, str4, 2));
    }

    public static final PendingIntent zzr(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, "com.google.android.gms.ads.AdService");
            return zzfsg.zzb(context, 0, intent, zzfsg.zza | 1073741824, 0);
        }
        intent.setClassName(context, "com.google.android.gms.ads.NotificationHandlerActivity");
        return zzfsg.zza(context, 0, intent, 201326592);
    }

    private final String zzs() {
        zzecz zzeczVar = (zzecz) this.zza.get(this.zzf);
        return zzeczVar == null ? "" : zzeczVar.zzb();
    }

    private static String zzt(int i, String str) {
        Resources resourcesZze = hd2.B.g.zze();
        return resourcesZze == null ? str : resourcesZze.getString(i);
    }

    private final void zzu(String str, String str2, Map map) {
        zzd(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    private final void zzv() {
        boolean zZzg;
        try {
            cd2 cd2Var = hd2.B.c;
            r52 r52VarJ = cd2.J(this.zzb);
            gy0 gy0Var = new gy0(this.zzb);
            String str = this.zzg;
            String str2 = this.zzf;
            zzecz zzeczVar = (zzecz) this.zza.get(str2);
            zZzg = r52VarJ.zzg(gy0Var, new c22(str, str2, zzeczVar == null ? "" : zzeczVar.zzc()));
            if (!zZzg) {
                try {
                    zZzg = r52VarJ.zzf(new gy0(this.zzb), this.zzg, this.zzf);
                } catch (RemoteException unused) {
                    k92.f();
                }
            }
        } catch (RemoteException unused2) {
            zZzg = false;
        }
        if (zZzg) {
            return;
        }
        this.zze.zzc(this.zzf);
        zzu(this.zzf, "offline_notification_worker_not_scheduled", zzfxu.zzd());
    }

    private final void zzw(final Activity activity, final yb2 yb2Var) {
        cd2 cd2Var = hd2.B.c;
        if (new cy0(activity).a()) {
            zzv();
            zzx(activity, yb2Var);
        } else if (Build.VERSION.SDK_INT >= 33) {
            activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
            zzu(this.zzf, "asnpdi", zzfxu.zzd());
        } else {
            AlertDialog.Builder builderI = cd2.i(activity);
            builderI.setTitle(zzt(s61.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzt(s61.notifications_permission_confirm, "Allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedl
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zza.zzk(activity, yb2Var, dialogInterface, i);
                }
            }).setNegativeButton(zzt(s61.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedm
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zza.zzl(yb2Var, dialogInterface, i);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedn
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.zza.zzm(yb2Var, dialogInterface);
                }
            });
            builderI.create().show();
            zzu(this.zzf, "rtsdi", zzfxu.zzd());
        }
    }

    private final void zzx(Activity activity, final yb2 yb2Var) {
        AlertDialog alertDialogCreate;
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        AlertDialog.Builder onCancelListener = cd2.i(activity).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedk
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                yb2 yb2Var2 = yb2Var;
                if (yb2Var2 != null) {
                    yb2Var2.zzb();
                }
            }
        });
        int i = k61.offline_ads_dialog;
        Resources resourcesZze = hd2Var.g.zze();
        XmlResourceParser layout = resourcesZze == null ? null : resourcesZze.getLayout(i);
        if (layout == null) {
            onCancelListener.setMessage(zzt(s61.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            alertDialogCreate = onCancelListener.create();
        } else {
            View viewInflate = activity.getLayoutInflater().inflate(layout, (ViewGroup) null);
            onCancelListener.setView(viewInflate);
            String strZzs = zzs();
            if (!strZzs.isEmpty()) {
                TextView textView = (TextView) viewInflate.findViewById(t51.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(strZzs);
            }
            zzecz zzeczVar = (zzecz) this.zza.get(this.zzf);
            Drawable drawableZza = zzeczVar != null ? zzeczVar.zza() : null;
            if (drawableZza != null) {
                ((ImageView) viewInflate.findViewById(t51.offline_dialog_image)).setImageDrawable(drawableZza);
            }
            alertDialogCreate = onCancelListener.create();
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialogCreate.show();
        Timer timer = new Timer();
        timer.schedule(new zzedr(this, alertDialogCreate, timer, yb2Var), 3000L);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zZzA = hd2.B.g.zzA(this.zzb);
            HashMap map = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                map.put("offline_notification_action", "offline_notification_clicked");
                c = true == zZzA ? (char) 1 : (char) 2;
                map.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                map.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Intent launchIntentForPackage = this.zzb.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zzb.startActivity(launchIntentForPackage);
                    map.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    map.put("olaa", "olaf");
                }
            } else {
                map.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzu(stringExtra2, "offline_notification_action", map);
            try {
                SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                if (c == 1) {
                    this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                } else {
                    zzedh.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                k92.e("Failed to get writable offline buffering database: ".concat(e.toString()));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzf(String[] strArr, int[] iArr, he0 he0Var) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("android.permission.POST_NOTIFICATIONS")) {
                zzedu zzeduVar = (zzedu) gy0.r(he0Var);
                Activity activityZza = zzeduVar.zza();
                yb2 yb2VarZzb = zzeduVar.zzb();
                HashMap map = new HashMap();
                if (iArr[i] == 0) {
                    map.put("dialog_action", "confirm");
                    zzv();
                    zzx(activityZza, yb2VarZzb);
                } else {
                    map.put("dialog_action", "dismiss");
                    if (yb2VarZzb != null) {
                        yb2VarZzb.zzb();
                    }
                }
                zzu(this.zzf, "asnpdc", map);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzg(he0 he0Var) {
        zzedu zzeduVar = (zzedu) gy0.r(he0Var);
        final Activity activityZza = zzeduVar.zza();
        final yb2 yb2VarZzb = zzeduVar.zzb();
        this.zzf = zzeduVar.zzc();
        this.zzg = zzeduVar.zzd();
        if (((Boolean) n42.d.c.zza(zzbbw.zzhF)).booleanValue()) {
            zzw(activityZza, yb2VarZzb);
            return;
        }
        zzu(this.zzf, "dialog_impression", zzfxu.zzd());
        cd2 cd2Var = hd2.B.c;
        AlertDialog.Builder builderI = cd2.i(activityZza);
        builderI.setTitle(zzt(s61.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzt(s61.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzt(s61.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.zza.zzn(activityZza, yb2VarZzb, dialogInterface, i);
            }
        }).setNegativeButton(zzt(s61.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.zza.zzo(yb2VarZzb, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedq
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.zza.zzp(yb2VarZzb, dialogInterface);
            }
        });
        builderI.create().show();
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzh() {
        final tc2 tc2Var = this.zzd;
        this.zze.zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzeda
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) throws Throwable {
                zzedh.zzb(tc2Var, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzi(he0 he0Var, String str, String str2) {
        zzj(he0Var, new c22(str, str2, ""));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a7  */
    @Override // com.google.android.gms.internal.ads.zzbsg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(defpackage.he0 r11, defpackage.c22 r12) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzj(he0, c22):void");
    }

    public final void zzk(Activity activity, yb2 yb2Var, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzu(this.zzf, "rtsdc", map);
        activity.startActivity(hd2.B.e.b(activity));
        zzv();
        if (yb2Var != null) {
            yb2Var.zzb();
        }
    }

    public final /* synthetic */ void zzl(yb2 yb2Var, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "rtsdc", map);
        if (yb2Var != null) {
            yb2Var.zzb();
        }
    }

    public final /* synthetic */ void zzm(yb2 yb2Var, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "rtsdc", map);
        if (yb2Var != null) {
            yb2Var.zzb();
        }
    }

    public final /* synthetic */ void zzn(Activity activity, yb2 yb2Var, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzu(this.zzf, "dialog_click", map);
        zzw(activity, yb2Var);
    }

    public final /* synthetic */ void zzo(yb2 yb2Var, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "dialog_click", map);
        if (yb2Var != null) {
            yb2Var.zzb();
        }
    }

    public final /* synthetic */ void zzp(yb2 yb2Var, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzu(this.zzf, "dialog_click", map);
        if (yb2Var != null) {
            yb2Var.zzb();
        }
    }

    public final void zzq(String str, zzdjb zzdjbVar) {
        String string = "";
        String strZzx = !TextUtils.isEmpty(zzdjbVar.zzx()) ? zzdjbVar.zzx() : zzdjbVar.zzB() != null ? zzdjbVar.zzB() : "";
        zzbfd zzbfdVarZzm = zzdjbVar.zzm();
        if (zzbfdVarZzm != null) {
            try {
                string = zzbfdVarZzm.zze().toString();
            } catch (RemoteException unused) {
            }
        }
        zzbfd zzbfdVarZzn = zzdjbVar.zzn();
        Drawable drawable = null;
        if (zzbfdVarZzn != null) {
            try {
                he0 he0VarZzf = zzbfdVarZzn.zzf();
                if (he0VarZzf != null) {
                    drawable = (Drawable) gy0.r(he0VarZzf);
                }
            } catch (RemoteException unused2) {
            }
        }
        this.zza.put(str, new zzecv(strZzx, string, drawable));
    }
}
