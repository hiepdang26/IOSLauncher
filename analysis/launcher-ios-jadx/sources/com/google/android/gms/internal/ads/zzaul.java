package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import defpackage.n42;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaul implements zzauk {
    protected static volatile zzavp zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzavh zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    public zzaul(Context context) {
        try {
            zzatd.zzd();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) n42.d.c.zza(zzbbw.zzct)).booleanValue()) {
                this.zzr = new zzavh();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzj() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        if (this.zzc.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String zzm(android.content.Context r19, java.lang.String r20, int r21, android.view.View r22, android.app.Activity r23, byte[] r24) {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaul.zzm(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    public abstract long zza(StackTraceElement[] stackTraceElementArr);

    public abstract zzaro zzb(Context context, View view, Activity activity);

    public abstract zzaro zzc(Context context, zzarh zzarhVar);

    public abstract zzaro zzd(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zze(Context context, String str, View view) {
        return zzm(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzf(Context context, String str, View view, Activity activity) {
        return zzm(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzg(Context context) {
        if (zzavs.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzm(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzh(Context context, View view, Activity activity) {
        return zzm(context, null, 2, view, activity, null);
    }

    public abstract zzavr zzi(MotionEvent motionEvent);

    @Override // com.google.android.gms.internal.ads.zzauk
    public final synchronized void zzk(MotionEvent motionEvent) {
        Long l;
        try {
            if (this.zzu) {
                zzj();
                this.zzu = false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.zzk = 0.0d;
                this.zzs = motionEvent.getRawX();
                this.zzt = motionEvent.getRawY();
            } else if (action == 1 || action == 2) {
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d = rawX - this.zzs;
                double d2 = rawY - this.zzt;
                this.zzk += Math.sqrt((d2 * d2) + (d * d));
                this.zzs = rawX;
                this.zzt = rawY;
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                try {
                    if (action2 == 1) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        this.zzb = motionEventObtain;
                        this.zzc.add(motionEventObtain);
                        if (this.zzc.size() > 6) {
                            ((MotionEvent) this.zzc.remove()).recycle();
                        }
                        this.zzf++;
                        this.zzh = zza(new Throwable().getStackTrace());
                    } else if (action2 == 2) {
                        this.zze += (long) (motionEvent.getHistorySize() + 1);
                        zzavr zzavrVarZzi = zzi(motionEvent);
                        Long l2 = zzavrVarZzi.zzd;
                        if (l2 != null && zzavrVarZzi.zzg != null) {
                            this.zzi = l2.longValue() + zzavrVarZzi.zzg.longValue() + this.zzi;
                        }
                        if (this.zzq != null && (l = zzavrVarZzi.zze) != null && zzavrVarZzi.zzh != null) {
                            this.zzj = l.longValue() + zzavrVarZzi.zzh.longValue() + this.zzj;
                        }
                    } else if (action2 == 3) {
                        this.zzg++;
                    }
                } catch (zzavf unused) {
                }
            } else {
                this.zzl = motionEvent.getX();
                this.zzm = motionEvent.getY();
                this.zzn = motionEvent.getRawX();
                this.zzo = motionEvent.getRawY();
                this.zzd++;
            }
            this.zzp = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final synchronized void zzl(int i, int i2, int i3) {
        try {
            if (this.zzb != null) {
                if (((Boolean) n42.d.c.zza(zzbbw.zzck)).booleanValue()) {
                    zzj();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                float f = displayMetrics.density;
                this.zzb = MotionEvent.obtain(0L, i3, 1, i * f, i2 * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavh zzavhVar;
        if (!((Boolean) n42.d.c.zza(zzbbw.zzct)).booleanValue() || (zzavhVar = this.zzr) == null) {
            return;
        }
        zzavhVar.zzb(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public void zzo(View view) {
    }
}
