package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class kc2 {
    public static final Uri d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    public final String a;
    public final String b;
    public final boolean c;

    public kc2(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.a = str;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        this.b = str2;
        this.c = z;
    }

    public final Intent a(Context context) {
        Bundle bundleCall;
        String str = this.a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(d, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e) {
                "Dynamic intent resolution failed: ".concat(e.toString());
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.b) : intent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kc2)) {
            return false;
        }
        kc2 kc2Var = (kc2) obj;
        return bf1.c(this.a, kc2Var.a) && bf1.c(this.b, kc2Var.b) && bf1.c(null, null) && this.c == kc2Var.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, null, 4225, Boolean.valueOf(this.c)});
    }

    public final String toString() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        hg0.i(null);
        throw null;
    }
}
