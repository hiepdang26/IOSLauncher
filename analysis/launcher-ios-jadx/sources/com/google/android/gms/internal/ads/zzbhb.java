package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.he0;
import defpackage.k92;
import defpackage.ov0;
import defpackage.s72;
import defpackage.t72;
import defpackage.ur1;
import defpackage.v92;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhb {
    private final zzbha zza;
    private final zzbfe zzc;
    private final List zzb = new ArrayList();
    private final ur1 zzd = new ur1();
    private final List zze = new ArrayList();

    public zzbhb(zzbha zzbhaVar) {
        zzbfd zzbfbVar;
        IBinder iBinder;
        this.zza = zzbhaVar;
        zzbfe zzbfeVar = null;
        try {
            List listZzu = zzbhaVar.zzu();
            if (listZzu != null) {
                for (Object obj : listZzu) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzbfbVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzbfbVar = iInterfaceQueryLocalInterface instanceof zzbfd ? (zzbfd) iInterfaceQueryLocalInterface : new zzbfb(iBinder);
                    }
                    if (zzbfbVar != null) {
                        this.zzb.add(new zzbfe(zzbfbVar));
                    }
                }
            }
        } catch (RemoteException unused) {
            k92.f();
        }
        try {
            List listZzv = this.zza.zzv();
            if (listZzv != null) {
                for (Object obj2 : listZzv) {
                    s72 s72VarF = obj2 instanceof IBinder ? v92.f((IBinder) obj2) : null;
                    if (s72VarF != null) {
                        this.zze.add(new t72(s72VarF));
                    }
                }
            }
        } catch (RemoteException unused2) {
            k92.f();
        }
        try {
            zzbfd zzbfdVarZzk = this.zza.zzk();
            if (zzbfdVarZzk != null) {
                zzbfeVar = new zzbfe(zzbfdVarZzk);
            }
        } catch (RemoteException unused3) {
            k92.f();
        }
        this.zzc = zzbfeVar;
        try {
            if (this.zza.zzi() != null) {
                new zzbex(this.zza.zzi());
            }
        } catch (RemoteException unused4) {
            k92.f();
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzz(bundle);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzI(bundle);
        } catch (RemoteException unused) {
            k92.f();
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzB(bundle);
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final ur1 zza() {
        try {
            if (this.zza.zzh() != null) {
                this.zzd.a(this.zza.zzh());
            }
        } catch (RemoteException unused) {
            k92.f();
        }
        return this.zzd;
    }

    public final ov0 zzb() {
        return this.zzc;
    }

    public final Double zzc() {
        try {
            double dZze = this.zza.zze();
            if (dZze == -1.0d) {
                return null;
            }
            return Double.valueOf(dZze);
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final Object zzd() {
        try {
            he0 he0VarZzl = this.zza.zzl();
            if (he0VarZzl != null) {
                return gy0.r(he0VarZzl);
            }
            return null;
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String zze() {
        try {
            return this.zza.zzn();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String zzf() {
        try {
            return this.zza.zzo();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String zzg() {
        try {
            return this.zza.zzp();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String zzh() {
        try {
            return this.zza.zzq();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String zzi() {
        try {
            return this.zza.zzs();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String zzj() {
        try {
            return this.zza.zzt();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final List zzk() {
        return this.zzb;
    }
}
