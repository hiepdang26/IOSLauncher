package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.util.Base64;
import com.luutinhit.launcher6.InstallShortcutReceiver;
import org.json.JSONException;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes.dex */
public final class gg0 {
    public final ek0 a;
    public final Intent b;
    public final Context c;
    public final Intent d;
    public final String e;
    public final jq1 f;

    public gg0(Context context, Intent intent) {
        this.b = intent;
        this.c = context;
        this.d = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        this.e = intent.getStringExtra("android.intent.extra.shortcut.NAME");
        this.f = jq1.b();
        this.a = null;
    }

    public final String a() {
        ek0 ek0Var = this.a;
        Context context = this.c;
        Intent intent = this.d;
        if (ek0Var != null) {
            try {
                return new JSONStringer().object().key("intent.launch").value(intent.toUri(0)).key("isAppShortcut").value(true).key("userHandle").value(iy.n(context).o(this.f)).endObject().toString();
            } catch (JSONException e) {
                e.toString();
                return null;
            }
        }
        if (intent.getAction() == null) {
            intent.setAction("android.intent.action.VIEW");
        } else if (intent.getAction().equals("android.intent.action.MAIN") && intent.getCategories() != null && intent.getCategories().contains("android.intent.category.LAUNCHER")) {
            intent.addFlags(270532608);
        }
        Object obj = InstallShortcutReceiver.a;
        CharSequence charSequenceLoadLabel = this.e;
        if (charSequenceLoadLabel == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                charSequenceLoadLabel = packageManager.getActivityInfo(intent.getComponent(), 0).loadLabel(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
                charSequenceLoadLabel = "";
            }
        }
        String string = charSequenceLoadLabel.toString();
        Intent intent2 = this.b;
        Bitmap bitmap = (Bitmap) intent2.getParcelableExtra("android.intent.extra.shortcut.ICON");
        Intent.ShortcutIconResource shortcutIconResource = (Intent.ShortcutIconResource) intent2.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
        try {
            JSONStringer jSONStringerValue = new JSONStringer().object().key("intent.launch").value(intent.toUri(0)).key("name").value(string);
            if (bitmap != null) {
                byte[] bArrN = ar1.n(bitmap);
                jSONStringerValue = jSONStringerValue.key("icon").value(Base64.encodeToString(bArrN, 0, bArrN.length, 0));
            }
            if (shortcutIconResource != null) {
                jSONStringerValue = jSONStringerValue.key("iconResource").value(shortcutIconResource.resourceName).key("iconResourcePackage").value(shortcutIconResource.packageName);
            }
            return jSONStringerValue.endObject().toString();
        } catch (JSONException e2) {
            e2.toString();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.og1 b() {
        /*
            r10 = this;
            android.content.Context r0 = r10.c
            ek0 r1 = r10.a
            if (r1 == 0) goto Lb
            og1 r0 = defpackage.og1.f(r1, r0)
            return r0
        Lb:
            jk0 r1 = defpackage.jk0.a()
            rl0 r1 = r1.a
            r1.getClass()
            java.util.Objects.toString(r0)
            android.content.Intent r2 = r10.b
            java.util.Objects.toString(r2)
            java.lang.String r3 = "android.intent.extra.shortcut.INTENT"
            android.os.Parcelable r3 = r2.getParcelableExtra(r3)
            android.content.Intent r3 = (android.content.Intent) r3
            java.lang.String r4 = "android.intent.extra.shortcut.NAME"
            java.lang.String r4 = r2.getStringExtra(r4)
            java.lang.String r5 = "android.intent.extra.shortcut.ICON"
            android.os.Parcelable r5 = r2.getParcelableExtra(r5)
            r6 = 0
            if (r3 != 0) goto L34
            return r6
        L34:
            boolean r7 = r5 instanceof android.graphics.Bitmap
            if (r7 == 0) goto L42
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            android.graphics.Bitmap r2 = defpackage.ar1.f(r0, r5)
        L3e:
            r9 = r6
            r6 = r2
            r2 = r9
            goto L59
        L42:
            java.lang.String r5 = "android.intent.extra.shortcut.ICON_RESOURCE"
            android.os.Parcelable r2 = r2.getParcelableExtra(r5)
            boolean r5 = r2 instanceof android.content.Intent.ShortcutIconResource
            if (r5 == 0) goto L58
            r6 = r2
            android.content.Intent$ShortcutIconResource r6 = (android.content.Intent.ShortcutIconResource) r6
            java.lang.String r2 = r6.packageName
            java.lang.String r5 = r6.resourceName
            android.graphics.Bitmap r2 = defpackage.ar1.g(r0, r2, r5)
            goto L3e
        L58:
            r2 = r6
        L59:
            og1 r5 = new og1
            r5.<init>()
            jq1 r7 = defpackage.jq1.b()
            r5.w = r7
            r8 = 1
            if (r6 != 0) goto L6f
            oe0 r6 = r1.t
            android.graphics.Bitmap r6 = r6.j(r7)
            r5.z = r8
        L6f:
            android.graphics.Bitmap r0 = defpackage.ar1.p(r0, r6)
            r5.C = r0
            java.lang.String r0 = defpackage.ar1.B(r4)
            r5.u = r0
            iy r1 = r1.v
            jq1 r4 = r5.w
            java.lang.CharSequence r0 = r1.j(r0, r4)
            r5.v = r0
            r5.x = r3
            r5.y = r8
            r5.B = r2
            r5.toString()
            android.content.Intent$ShortcutIconResource r0 = r5.B
            java.util.Objects.toString(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gg0.b():og1");
    }

    public gg0(ek0 ek0Var, Context context) {
        this.b = null;
        this.c = context;
        this.a = ek0Var;
        jq1 jq1VarF = ek0Var.f();
        this.f = jq1VarF;
        this.d = v6.h(context, ek0Var, jq1VarF);
        this.e = ek0Var.e().toString();
    }
}
