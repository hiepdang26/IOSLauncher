package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import defpackage.gs0;
import defpackage.k92;
import defpackage.kv0;
import defpackage.lv0;
import defpackage.mv0;
import defpackage.nv0;
import defpackage.q72;
import defpackage.qa2;
import defpackage.qv0;
import defpackage.rv0;
import defpackage.s72;
import defpackage.t72;
import defpackage.u82;
import defpackage.v92;
import defpackage.wb1;
import defpackage.x92;
import defpackage.zy0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrv extends rv0 {
    private final zzbha zza;
    private final zzbru zzc;
    private final mv0 zzd;
    private final List zzb = new ArrayList();
    private final List zze = new ArrayList();

    public zzbrv(zzbha zzbhaVar) {
        zzbfd zzbfdVarZzk;
        this.zza = zzbhaVar;
        zzbrs zzbrsVar = null;
        try {
            List listZzu = zzbhaVar.zzu();
            if (listZzu != null) {
                for (Object obj : listZzu) {
                    zzbfd zzbfdVarZzg = obj instanceof IBinder ? zzbfc.zzg((IBinder) obj) : null;
                    if (zzbfdVarZzg != null) {
                        this.zzb.add(new zzbru(zzbfdVarZzg));
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
            zzbfdVarZzk = this.zza.zzk();
        } catch (RemoteException unused3) {
            k92.f();
        }
        zzbru zzbruVar = zzbfdVarZzk != null ? new zzbru(zzbfdVarZzk) : null;
        this.zzc = zzbruVar;
        try {
            if (this.zza.zzi() != null) {
                zzbrsVar = new zzbrs(this.zza.zzi());
            }
        } catch (RemoteException unused4) {
            k92.f();
        }
        this.zzd = zzbrsVar;
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzw();
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void destroy() {
        try {
            this.zza.zzx();
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzC();
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final mv0 getAdChoicesInfo() {
        return this.zzd;
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzn();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    @Override // defpackage.rv0
    public final String getBody() {
        try {
            return this.zza.zzo();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zza.zzp();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle bundleZzf = this.zza.zzf();
            if (bundleZzf != null) {
                return bundleZzf;
            }
        } catch (RemoteException unused) {
            k92.f();
        }
        return new Bundle();
    }

    @Override // defpackage.rv0
    public final String getHeadline() {
        try {
            return this.zza.zzq();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final nv0 getIcon() {
        return this.zzc;
    }

    public final List<nv0> getImages() {
        return this.zzb;
    }

    public final gs0 getMediaContent() {
        try {
            if (this.zza.zzj() != null) {
                return new x92(this.zza.zzj(), null);
            }
        } catch (RemoteException unused) {
            k92.f();
        }
        return null;
    }

    public final List<lv0> getMuteThisAdReasons() {
        return this.zze;
    }

    public final String getPrice() {
        try {
            return this.zza.zzs();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    @Override // defpackage.rv0
    public final wb1 getResponseInfo() {
        u82 u82VarZzg;
        try {
            u82VarZzg = this.zza.zzg();
        } catch (RemoteException unused) {
            k92.f();
            u82VarZzg = null;
        }
        if (u82VarZzg != null) {
            return new wb1(u82VarZzg);
        }
        return null;
    }

    public final Double getStarRating() {
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

    public final String getStore() {
        try {
            return this.zza.zzt();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zza.zzG();
        } catch (RemoteException unused) {
            k92.f();
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zza.zzH();
        } catch (RemoteException unused) {
            k92.f();
            return false;
        }
    }

    public final void muteThisAd(lv0 lv0Var) {
        try {
            try {
                if (this.zza.zzH()) {
                    if (lv0Var == null) {
                        this.zza.zzy(null);
                        return;
                    } else if (lv0Var instanceof t72) {
                        this.zza.zzy(((t72) lv0Var).b);
                        return;
                    } else {
                        k92.e("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                        return;
                    }
                }
            } catch (RemoteException unused) {
                k92.f();
            }
            k92.e("Ad is not custom mute enabled");
        } catch (RemoteException unused2) {
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

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzA();
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

    public final void setMuteThisAdListener(kv0 kv0Var) {
        try {
            this.zza.zzD(new q72("com.google.android.gms.ads.internal.client.IMuteThisAdListener"));
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void setOnPaidEventListener(zy0 zy0Var) {
        try {
            this.zza.zzE(new qa2());
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void setUnconfirmedClickListener(qv0 qv0Var) {
        try {
            this.zza.zzF(new zzbsd(qv0Var));
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    @Override // defpackage.rv0
    public final /* bridge */ /* synthetic */ Object zza() {
        try {
            return this.zza.zzm();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }
}
