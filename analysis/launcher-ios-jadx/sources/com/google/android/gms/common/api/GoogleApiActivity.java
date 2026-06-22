package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import defpackage.da0;
import defpackage.ha0;
import defpackage.hg0;
import defpackage.t12;
import defpackage.vl;

/* JADX INFO: loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    public static final /* synthetic */ int h = 0;
    public int g = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.g = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                ha0 ha0VarF = ha0.f(this);
                if (i2 == -1) {
                    t12 t12Var = ha0VarF.t;
                    t12Var.sendMessage(t12Var.obtainMessage(3));
                } else if (i2 == 0) {
                    ha0VarF.g(new vl(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.g = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.g = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.g = bundle.getInt("resolution");
        }
        if (this.g == 1) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            finish();
            return;
        }
        if (pendingIntent == null) {
            hg0.i(num);
            da0.d.d(this, num.intValue(), this);
            this.g = 1;
            return;
        }
        try {
            googleApiActivity = this;
            try {
                googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                googleApiActivity.g = 1;
            } catch (ActivityNotFoundException unused) {
                if (extras.getBoolean("notify_manager", true)) {
                    ha0.f(this).g(new vl(22, null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String string = pendingIntent.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 36);
                    sb.append("Activity not found while launching ");
                    sb.append(string);
                    sb.append(".");
                    String string2 = sb.toString();
                    if (Build.FINGERPRINT.contains("generic")) {
                        string2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                }
                googleApiActivity.g = 1;
                finish();
            } catch (IntentSender.SendIntentException unused2) {
                finish();
            }
        } catch (ActivityNotFoundException unused3) {
            googleApiActivity = this;
        } catch (IntentSender.SendIntentException unused4) {
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.g);
        super.onSaveInstanceState(bundle);
    }
}
