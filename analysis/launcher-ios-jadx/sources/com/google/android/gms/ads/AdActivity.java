package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbsn;
import defpackage.gy0;
import defpackage.h22;
import defpackage.k92;
import defpackage.s32;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public final class AdActivity extends Activity {
    public zzbsn g;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            k92.i("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                if (!zzbsnVar.zzH()) {
                    return;
                }
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbsn zzbsnVar2 = this.g;
            if (zzbsnVar2 != null) {
                zzbsnVar2.zzi();
            }
        } catch (RemoteException e2) {
            k92.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzk(new gy0(configuration));
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s32 s32Var = x32.f.b;
        s32Var.getClass();
        h22 h22Var = new h22(s32Var, this);
        Intent intent = getIntent();
        boolean booleanExtra = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            k92.e("useClientJar flag not found in activity intent extras.");
        }
        zzbsn zzbsnVar = (zzbsn) h22Var.d(this, booleanExtra);
        this.g = zzbsnVar;
        if (zzbsnVar == null) {
            k92.i("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzbsnVar.zzl(bundle);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzm();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzo();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzq();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzr();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzs(bundle);
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzt();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzu();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbsn zzbsnVar = this.g;
            if (zzbsnVar != null) {
                zzbsnVar.zzv();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zzbsn zzbsnVar = this.g;
        if (zzbsnVar != null) {
            try {
                zzbsnVar.zzx();
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zzbsn zzbsnVar = this.g;
        if (zzbsnVar != null) {
            try {
                zzbsnVar.zzx();
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzbsn zzbsnVar = this.g;
        if (zzbsnVar != null) {
            try {
                zzbsnVar.zzx();
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
    }
}
