package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class q02 extends n90 {
    public final /* synthetic */ int m;

    @Override // defpackage.n90
    public s5 a(Context context, Looper looper, mj mjVar, Object obj, fa0 fa0Var, ga0 ga0Var) {
        switch (this.m) {
            case 0:
                mjVar.getClass();
                Integer num = (Integer) mjVar.g;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new rg1(context, looper, mjVar, bundle, fa0Var, ga0Var);
            case 1:
                obj.getClass();
                throw new ClassCastException();
            case 2:
            default:
                return super.a(context, looper, mjVar, obj, fa0Var, ga0Var);
            case 3:
                return new y32(context, looper, (v02) fa0Var, (v02) ga0Var, mjVar);
        }
    }

    @Override // defpackage.n90
    public s5 b(Context context, Looper looper, mj mjVar, Object obj, v02 v02Var, v02 v02Var2) {
        switch (this.m) {
            case 2:
                return new s12(context, looper, mjVar, (wm1) obj, v02Var, v02Var2);
            case 3:
            default:
                return super.b(context, looper, mjVar, obj, v02Var, v02Var2);
            case 4:
                return new z72(context, looper, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, mjVar, v02Var, v02Var2);
        }
    }
}
