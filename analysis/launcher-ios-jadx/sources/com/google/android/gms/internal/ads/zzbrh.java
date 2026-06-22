package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.s61;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrh extends zzbrq {
    private final Map zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbrh(zzcej zzcejVar, Map map) {
        super(zzcejVar, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcejVar.zzi();
        this.zzc = zze("description");
        this.zzf = zze("summary");
        this.zzd = zzd("start_ticks");
        this.zze = zzd("end_ticks");
        this.zzg = zze("location");
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private final String zze(String str) {
        return TextUtils.isEmpty((CharSequence) this.zza.get(str)) ? "" : (String) this.zza.get(str);
    }

    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        Context context = this.zzb;
        if (context == null) {
            zzh("Activity context is not available.");
            return;
        }
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        if (!new zzbbe(context).zzb()) {
            zzh("This feature is not available on the device.");
            return;
        }
        cd2 cd2Var2 = hd2Var.c;
        AlertDialog.Builder builderI = cd2.i(this.zzb);
        Resources resourcesZze = hd2Var.g.zze();
        builderI.setTitle(resourcesZze != null ? resourcesZze.getString(s61.s5) : "Create calendar event");
        builderI.setMessage(resourcesZze != null ? resourcesZze.getString(s61.s6) : "Allow Ad to create a calendar event?");
        builderI.setPositiveButton(resourcesZze != null ? resourcesZze.getString(s61.s3) : "Accept", new zzbrf(this));
        builderI.setNegativeButton(resourcesZze != null ? resourcesZze.getString(s61.s4) : "Decline", new zzbrg(this));
        builderI.create().show();
    }
}
