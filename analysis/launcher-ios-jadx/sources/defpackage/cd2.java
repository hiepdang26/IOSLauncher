package defpackage;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import androidx.constraintlayout.motion.widget.MotionScene;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzbvl;
import com.google.android.gms.internal.ads.zzcea;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzdpo;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzfeo;
import com.google.android.gms.internal.ads.zzfui;
import com.google.android.gms.internal.ads.zzfvh;
import com.google.android.gms.internal.ads.zzhfv;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class cd2 {
    public static final ja2 l = new ja2(Looper.getMainLooper());
    public String g;
    public volatile String h;
    public final AtomicReference a = new AtomicReference(null);
    public final AtomicReference b = new AtomicReference(null);
    public final AtomicReference c = new AtomicReference(new Bundle());
    public final AtomicBoolean d = new AtomicBoolean();
    public boolean e = true;
    public final Object f = new Object();
    public boolean i = false;
    public boolean j = false;
    public final ExecutorService k = Executors.newSingleThreadExecutor();

    public static int B(Uri uri, Context context) {
        int i;
        if (context == null) {
            k92.a("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (context instanceof Activity) {
            i = 0;
        } else {
            k92.a("Chrome Custom Tabs can only work with Activity context.");
            i = 2;
        }
        zzbbn zzbbnVar = zzbbw.zzec;
        n42 n42Var = n42.d;
        Boolean bool = (Boolean) n42Var.c.zza(zzbbnVar);
        zzbbn zzbbnVar2 = zzbbw.zzed;
        zzbbu zzbbuVar = n42Var.c;
        if (true == bool.equals(zzbbuVar.zza(zzbbnVar2))) {
            i = 9;
        }
        if (i != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i;
        }
        if (((Boolean) zzbbuVar.zza(zzbbnVar)).booleanValue()) {
            zzbct zzbctVar = new zzbct();
            zzbctVar.zze(new wb2(zzbctVar, context, uri));
            zzbctVar.zzb((Activity) context);
        }
        if (!((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue()) {
            return 5;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        if (!intent2.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            intent2.putExtras(bundle);
        }
        intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
        intent2.putExtras(new Bundle());
        intent2.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
        intent2.setPackage(zzhfv.zza(context));
        intent2.setData(uri);
        context.startActivity(intent2, null);
        return 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean C(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L9
        L7:
            r2 = r0
            goto L13
        L9:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L7
            android.app.Activity r2 = (android.app.Activity) r2
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cd2.C(android.view.View):boolean");
    }

    public static final void D(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
        extras.putBinder("android.support.customtabs.extra.SESSION", null);
        extras.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(extras);
    }

    public static final String E(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return s(r(context));
    }

    public static final String F() {
        StringBuilder sb = new StringBuilder(MotionScene.Transition.TransitionOnClick.JUMP_TO_END);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String G() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : uo.i(str, " ", str2);
    }

    public static final HashMap H(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                HashSet hashSet = new HashSet();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        if (strOptString != null) {
                            hashSet.add(strOptString);
                        }
                    }
                    map.put(next, hashSet);
                }
            }
            return map;
        } catch (JSONException e) {
            hd2.B.g.zzw(e, "AdUtil.getMapOfFileNamesToKeysFromJsonString");
            return map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.ViewParent] */
    public static final long I(View view) {
        float fMin = Float.MAX_VALUE;
        do {
            if (!(view instanceof View)) {
                break;
            }
            View view2 = (View) view;
            fMin = Math.min(fMin, view2.getAlpha());
            view = view2.getParent();
        } while (fMin > 0.0f);
        return Math.round((fMin >= 0.0f ? fMin : 0.0f) * 100.0f);
    }

    public static final r52 J(Context context) {
        try {
            Object objNewInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(null).newInstance(null);
            if (!(objNewInstance instanceof IBinder)) {
                k92.e("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) objNewInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            return iInterfaceQueryLocalInterface instanceof r52 ? (r52) iInterfaceQueryLocalInterface : new o52(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
        } catch (Exception e) {
            hd2.B.g.zzw(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final boolean a(Context context, String str) {
        Context contextZza = zzbvl.zza(context);
        return j02.a(contextZza).h.getPackageManager().checkPermission(str, contextZza.getPackageName()) == 0;
    }

    public static final boolean b(Context context) {
        try {
            if (bf1.l == null) {
                bf1.l = Boolean.valueOf(os.k() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE"));
            }
            return bf1.l.booleanValue();
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public static final boolean c(String str) {
        if (!ub2.c()) {
            return false;
        }
        zzbbn zzbbnVar = zzbbw.zzev;
        n42 n42Var = n42.d;
        if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            return false;
        }
        String str2 = (String) n42Var.c.zza(zzbbw.zzex);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) n42.d.c.zza(zzbbw.zzew);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            k92.f();
            hd2.B.g.zzw(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
                        return !powerManager.isScreenOn();
                    }
                    return true;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean f(Context context) {
        try {
            Bundle bundleR = r(context);
            String string = bundleR.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
            if (TextUtils.isEmpty(s(bundleR))) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (RemoteException unused) {
        }
        return false;
    }

    public static final boolean g(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static final void h(int i, View view) {
        String strZza;
        int i2;
        int iHeight;
        int iWidth;
        String str;
        zzfel zzfelVarZzD;
        zzfeo zzfeoVarZzR;
        View childAt = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = childAt.getContext().getPackageName();
            if (childAt instanceof zzdpo) {
                childAt = ((zzdpo) childAt).getChildAt(0);
            }
            if (childAt instanceof xv0) {
                strZza = "NATIVE";
                i2 = 1;
            } else {
                strZza = "UNKNOWN";
                i2 = 0;
            }
            if (childAt.getLocalVisibleRect(rect)) {
                iWidth = rect.width();
                iHeight = rect.height();
            } else {
                iHeight = 0;
                iWidth = 0;
            }
            cd2 cd2Var = hd2.B.c;
            long jI = I(childAt);
            childAt.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            String str2 = "none";
            if (!(childAt instanceof zzcfm) || (zzfeoVarZzR = ((zzcfm) childAt).zzR()) == null) {
                str = "none";
            } else {
                str = zzfeoVarZzR.zzb;
                childAt.setContentDescription(str + ":" + childAt.hashCode());
            }
            if ((childAt instanceof zzcea) && (zzfelVarZzD = ((zzcea) childAt).zzD()) != null) {
                strZza = zzfel.zza(zzfelVarZzD.zzb);
                i2 = zzfelVarZzD.zze;
                str2 = zzfelVarZzD.zzE;
            }
            Locale locale = Locale.US;
            k92.g("<Ad hashCode=" + childAt.hashCode() + ", package=" + packageName + ", adNetCls=" + str2 + ", gwsQueryId=" + str + ", format=" + strZza + ", impType=" + i2 + ", class=" + childAt.getClass().getName() + ", x=" + i3 + ", y=" + i4 + ", width=" + childAt.getWidth() + ", height=" + childAt.getHeight() + ", vWidth=" + iWidth + ", vHeight=" + iHeight + ", alpha=" + jI + ", state=" + Integer.toString(i, 2) + ">");
        } catch (Exception unused) {
            k92.f();
        }
    }

    public static final AlertDialog.Builder i(Context context) {
        fd2 fd2Var = hd2.B.e;
        return new AlertDialog.Builder(context, R.style.Theme.Material.Dialog.Alert);
    }

    public static final void j(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            new x52(context, str, (String) obj).zzb();
        }
    }

    public static final int k(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            k92.h("Could not parse value:".concat(e.toString()));
            return 0;
        }
    }

    public static final HashMap l(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(str)) {
                map.put(str, uri.getQueryParameter(str));
            }
        }
        return map;
    }

    public static final int[] m(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? new int[]{0, 0} : new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
    }

    public static final int[] n(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        int[] iArr = (window == null || (viewFindViewById = window.findViewById(R.id.content)) == null) ? new int[]{0, 0} : new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
        x32 x32Var = x32.f;
        return new int[]{x32Var.a.e(activity, iArr[0]), x32Var.a.e(activity, iArr[1])};
    }

    public static final boolean o(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z = hd2.B.c.e || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || C(view);
        long jI = I(view);
        if (view.getVisibility() == 0 && view.isShown() && ((powerManager == null || powerManager.isScreenOn()) && z)) {
            zzbbn zzbbnVar = zzbbw.zzbc;
            n42 n42Var = n42.d;
            if (!((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                zzbbn zzbbnVar2 = zzbbw.zzjI;
                if (!((Boolean) n42Var.c.zza(zzbbnVar2)).booleanValue() || jI >= ((Integer) r6.zza(zzbbw.zzjK)).intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void p(Context context, Intent intent) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkc)).booleanValue()) {
            try {
                context.startActivity(intent);
                return;
            } catch (Throwable unused) {
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            }
        }
        try {
            try {
                context.startActivity(intent);
            } catch (Throwable unused2) {
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } catch (SecurityException e) {
            k92.j(5);
            hd2.B.g.zzw(e, "AdUtil.startActivityWithUnknownContext");
        }
    }

    public static final void q(Uri uri, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            D(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            k92.d("Opening " + uri.toString() + " in a new browser.");
        } catch (ActivityNotFoundException unused) {
            k92.f();
        }
    }

    public static Bundle r(Context context) {
        try {
            return j02.a(context).e(128, context.getPackageName()).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            k92.b();
            return null;
        }
    }

    public static String s(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return !TextUtils.isEmpty(string) ? (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "" : "";
    }

    public static int t(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        k92.h("HTTP timeout too low: " + i + " milliseconds. Reverting to default timeout: 60000 milliseconds.");
        return 60000;
    }

    public static boolean u(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern patternCompile = (Pattern) atomicReference.get();
            if (patternCompile == null || !str2.equals(patternCompile.pattern())) {
                patternCompile = Pattern.compile(str2);
                atomicReference.set(patternCompile);
            }
            return patternCompile.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static final String v(Context context, String str) {
        Context contextCreatePackageContext;
        if (str == null) {
            return F();
        }
        String strF = null;
        try {
            if (ew1.i == null) {
                ew1.i = new ew1();
            }
            ew1 ew1Var = ew1.i;
            if (TextUtils.isEmpty((String) ew1Var.h)) {
                int i = ja0.c;
                try {
                    contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
                } catch (PackageManager.NameNotFoundException unused) {
                    contextCreatePackageContext = null;
                }
                ew1Var.h = (String) bf1.C(context, new p42(contextCreatePackageContext, context, 1));
            }
            strF = (String) ew1Var.h;
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(strF)) {
            strF = WebSettings.getDefaultUserAgent(context);
        }
        if (TextUtils.isEmpty(strF)) {
            strF = F();
        }
        String strI = uo.i(strF, " (Mobile; ", str);
        try {
            if (j02.a(context).i()) {
                strI = strI + ";aia";
            }
        } catch (Exception e) {
            hd2.B.g.zzw(e, "AdUtil.getUserAgent");
        }
        return strI.concat(")");
    }

    public static ArrayList x() {
        zzbbn zzbbnVar = zzbbw.zza;
        List listZzb = n42.d.a.zzb();
        ArrayList arrayList = new ArrayList();
        Iterator it = listZzb.iterator();
        while (it.hasNext()) {
            Iterator it2 = zzfvh.zzb(zzfui.zzc(',')).zzc((String) it.next()).iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(Long.valueOf((String) it2.next()));
                } catch (NumberFormatException unused) {
                    k92.a("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public final void A(Context context) {
        if (this.i) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbbw.zza(context);
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new m6(this, 8), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new m6(this, 8), intentFilter, 4);
        }
        this.i = true;
    }

    public final String w(Context context, String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzkp)).booleanValue()) {
            if (this.h != null) {
                return this.h;
            }
            this.h = v(context, str);
            return this.h;
        }
        synchronized (this.f) {
            try {
                String str2 = this.g;
                if (str2 != null) {
                    return str2;
                }
                String strV = v(context, str);
                this.g = strV;
                return strV;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(Context context, String str, HttpURLConnection httpURLConnection, int i) {
        int iT = t(i);
        k92.g("HTTP timeout: " + iT + " milliseconds.");
        httpURLConnection.setConnectTimeout(iT);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(iT);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("User-Agent"))) {
            httpURLConnection.setRequestProperty("User-Agent", w(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    public final void z(Context context) {
        if (this.j) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbbw.zza(context);
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new rv1(1), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new rv1(1), intentFilter, 4);
        }
        this.j = true;
    }
}
