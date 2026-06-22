package com.luutinhit.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import defpackage.ar1;
import defpackage.az1;
import defpackage.ek0;
import defpackage.fk0;
import defpackage.gg0;
import defpackage.iy;
import defpackage.jk0;
import defpackage.jq1;
import defpackage.qg0;
import defpackage.rl0;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class InstallShortcutReceiver extends BroadcastReceiver {
    public static final Object a = new Object();
    public static boolean b = false;

    public static gg0 a(Context context, Intent intent) {
        Parcelable parcelableExtra;
        gg0 gg0Var;
        Intent intent2;
        ResolveInfo resolveInfoResolveActivity;
        Parcelable parcelableExtra2 = intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (!(parcelableExtra2 == null || Intent.class.isInstance(parcelableExtra2)) || ((parcelableExtra = intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")) != null && !Intent.ShortcutIconResource.class.isInstance(parcelableExtra))) {
            return null;
        }
        Parcelable parcelableExtra3 = intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
        if ((parcelableExtra3 == null || Bitmap.class.isInstance(parcelableExtra3)) && (intent2 = (gg0Var = new gg0(context, intent)).d) != null && gg0Var.e != null) {
            if (ar1.u(intent2)) {
                if (gg0Var.f.equals(jq1.b()) && (resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent2, 0)) != null) {
                    return new gg0(new fk0(context, resolveInfoResolveActivity), context);
                }
            }
            return gg0Var;
        }
        return null;
    }

    public static gg0 b(Context context, String str) {
        ek0 ek0VarF;
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            Intent uri = Intent.parseUri(jSONObject.getString("intent.launch"), 0);
            if (jSONObject.optBoolean("isAppShortcut")) {
                jq1 jq1VarR = iy.n(context).r(jSONObject.getLong("userHandle"));
                if (jq1VarR != null && (ek0VarF = qg0.t(context).F(uri, jq1VarR)) != null) {
                    return new gg0(ek0VarF, context);
                }
                return null;
            }
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.shortcut.INTENT", uri);
            intent.putExtra("android.intent.extra.shortcut.NAME", jSONObject.getString("name"));
            String strOptString = jSONObject.optString("icon");
            String strOptString2 = jSONObject.optString("iconResource");
            String strOptString3 = jSONObject.optString("iconResourcePackage");
            if (strOptString != null && !strOptString.isEmpty()) {
                byte[] bArrDecode = Base64.decode(strOptString, 0);
                intent.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            } else if (strOptString2 != null && !strOptString2.isEmpty()) {
                Intent.ShortcutIconResource shortcutIconResource = new Intent.ShortcutIconResource();
                shortcutIconResource.resourceName = strOptString2;
                shortcutIconResource.packageName = strOptString3;
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", shortcutIconResource);
            }
            return new gg0(context, intent);
        } catch (URISyntaxException e) {
            e = e;
            e.toString();
            return null;
        } catch (JSONException e2) {
            e = e2;
            e.toString();
            return null;
        }
    }

    public static void c(Context context) {
        ArrayList<gg0> arrayList;
        SharedPreferences sharedPreferencesQ = ar1.q(context);
        synchronized (a) {
            try {
                Set<String> stringSet = sharedPreferencesQ.getStringSet("apps_to_install", null);
                if (stringSet == null) {
                    arrayList = new ArrayList();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<String> it = stringSet.iterator();
                    while (it.hasNext()) {
                        gg0 gg0VarB = b(context, it.next());
                        if (gg0VarB != null) {
                            arrayList2.add(gg0VarB);
                        }
                    }
                    sharedPreferencesQ.edit().putStringSet("apps_to_install", new HashSet()).apply();
                    arrayList = arrayList2;
                }
            } finally {
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (gg0 gg0Var : arrayList) {
            Intent intent = gg0Var.d;
            String packageName = intent.getPackage();
            if (packageName == null) {
                packageName = intent.getComponent() == null ? null : intent.getComponent().getPackageName();
            }
            if (!TextUtils.isEmpty(packageName)) {
                jq1 jq1VarB = jq1.b();
                HandlerThread handlerThread = rl0.w;
                Objects.toString(context);
                Objects.toString(jq1VarB);
                if (!(packageName == null ? false : qg0.t(context).A(packageName, jq1VarB))) {
                }
            }
            arrayList3.add(gg0Var.b());
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        jk0.a().a.a(context, arrayList3);
    }

    public static void d(Context context, HashSet hashSet, jq1 jq1Var) {
        if (hashSet.isEmpty()) {
            return;
        }
        SharedPreferences sharedPreferencesQ = ar1.q(context);
        synchronized (a) {
            try {
                Set<String> stringSet = sharedPreferencesQ.getStringSet("apps_to_install", null);
                if (stringSet != null) {
                    HashSet hashSet2 = new HashSet(stringSet);
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        gg0 gg0VarB = b(context, (String) it.next());
                        if (gg0VarB != null) {
                            Intent intent = gg0VarB.d;
                            String packageName = intent.getPackage();
                            if (packageName == null) {
                                packageName = intent.getComponent() == null ? null : intent.getComponent().getPackageName();
                            }
                            if (!hashSet.contains(packageName) || !jq1Var.equals(gg0VarB.f)) {
                            }
                        }
                        it.remove();
                    }
                    sharedPreferencesQ.edit().putStringSet("apps_to_install", hashSet2).apply();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        gg0 gg0VarA;
        if ("com.android.launcher.action.INSTALL_SHORTCUT".equals(intent.getAction()) && (gg0VarA = a(context, intent)) != null) {
            if (!(gg0VarA.a != null) && !az1.u(context, gg0VarA.d, null)) {
                gg0VarA.d.toUri(0);
                return;
            }
            boolean z = jk0.a().a.l() == null;
            SharedPreferences sharedPreferencesQ = ar1.q(context);
            synchronized (a) {
                try {
                    String strA = gg0VarA.a();
                    if (strA != null) {
                        Set<String> stringSet = sharedPreferencesQ.getStringSet("apps_to_install", null);
                        HashSet hashSet = stringSet == null ? new HashSet(1) : new HashSet(stringSet);
                        hashSet.add(strA);
                        sharedPreferencesQ.edit().putStringSet("apps_to_install", hashSet).apply();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (b || z) {
                return;
            }
            c(context);
        }
    }
}
