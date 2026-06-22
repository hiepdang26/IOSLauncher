package defpackage;

import android.R;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import com.luutinhit.launcher6.BubbleTextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class oe0 {
    public static final Object t = new Object();
    public final iy b;
    public final me0 c;
    public final Handler d;
    public final Context g;
    public final PackageManager h;
    public final qg0 i;
    public final SharedPreferences j;
    public final int l;
    public final int m;
    public final int n;
    public final BitmapFactory.Options o;
    public String p;
    public Bitmap q;
    public Canvas r;
    public Paint s;
    public final zp0 a = new zp0();
    public final HashMap e = new HashMap();
    public final HashMap f = new HashMap();
    public final HashMap k = new HashMap(50);

    public oe0(Context context, xg0 xg0Var) {
        this.g = context;
        this.h = context.getPackageManager();
        this.b = iy.n(context);
        this.i = qg0.t(context);
        Rect rect = ar1.a;
        this.j = context.getSharedPreferences("com.luutinhit.launcher6.prefs", 0);
        this.l = xg0Var.i;
        this.c = new me0(context, "app_icons.db", 655360 + xg0Var.h, "icons", 0);
        this.d = new Handler(rl0.w.getLooper());
        this.m = context.getResources().getColor(x41.quantum_panel_bg_color);
        this.n = context.getResources().getColor(x41.quantum_panel_bg_color_dark);
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.o = options;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        this.p = Locale.getDefault().toString();
    }

    public static dl s(String str, jq1 jq1Var) {
        Objects.toString(jq1Var);
        return new dl(new ComponentName(str, uo.h(str, ".")), jq1Var);
    }

    public final ContentValues A(Bitmap bitmap, String str, int i, int i2, int i3, String str2, int i4) {
        Objects.toString(bitmap);
        ContentValues contentValues = new ContentValues();
        contentValues.put("icon", ar1.n(bitmap));
        contentValues.put("history", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("label", str);
        contentValues.put("system_state", this.p);
        contentValues.put("customIcon", Integer.valueOf(i2));
        if (i2 > 0) {
            try {
                if (i4 == 1 && i3 > 0) {
                    contentValues.put("data1", (Integer) 0);
                    contentValues.put("iconName", this.g.getResources().getResourceEntryName(i3));
                } else if (i4 == 2) {
                    if (!TextUtils.isEmpty(str2)) {
                        contentValues.put("data1", (Integer) 1);
                        contentValues.put("iconName", str2);
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        if (i == 0) {
            contentValues.put("icon_low_res", ar1.n(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 5, bitmap.getHeight() / 5, true)));
        } else {
            synchronized (this) {
                try {
                    if (this.q == null) {
                        this.q = Bitmap.createBitmap(bitmap.getWidth() / 5, bitmap.getHeight() / 5, Bitmap.Config.RGB_565);
                        this.r = new Canvas(this.q);
                        this.s = new Paint(3);
                    }
                    this.r.drawColor(i);
                    this.r.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.q.getWidth(), this.q.getHeight()), this.s);
                    contentValues.put("icon_low_res", ar1.n(this.q));
                } finally {
                }
            }
        }
        return contentValues;
    }

    public final boolean B(dl dlVar, ke0 ke0Var, boolean z) throws Throwable {
        jq1 jq1Var;
        Cursor cursorH;
        String str;
        ComponentName componentName = dlVar.a;
        iy iyVar = this.b;
        Objects.toString(dlVar);
        Objects.toString(ke0Var);
        Cursor cursor = null;
        Bitmap bitmapDecodeByteArray = null;
        Cursor cursor2 = null;
        try {
            me0 me0Var = this.c;
            String[] strArr = {z ? "icon_low_res" : "icon", "label"};
            jq1Var = dlVar.b;
            cursorH = me0Var.h("componentName = ? AND profileId = ?", strArr, new String[]{componentName.flattenToString(), Long.toString(iyVar.o(jq1Var))});
        } catch (SQLiteException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!cursorH.moveToNext()) {
                cursorH.close();
                return true;
            }
            BitmapFactory.Options options = z ? this.o : null;
            Objects.toString(cursorH);
            Objects.toString(options);
            try {
                byte[] blob = cursorH.getBlob(0);
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(blob, 0, blob.length, options);
            } catch (Throwable unused2) {
            }
            ke0Var.a = bitmapDecodeByteArray;
            ke0Var.d = z;
            String string = cursorH.getString(1);
            ke0Var.b = string;
            if (string == null) {
                Context context = this.g;
                String packageName = componentName.getPackageName();
                Rect rect = ar1.a;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128));
                } catch (Throwable unused3) {
                    str = "";
                }
                ke0Var.b = str;
                ke0Var.c = "";
            } else {
                ke0Var.c = iyVar.j(string, jq1Var);
            }
            cursorH.close();
            return false;
        } catch (SQLiteException unused4) {
            cursor2 = cursorH;
            if (cursor2 != null) {
                cursor2.close();
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorH;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void C(ComponentName componentName, Bitmap bitmap, String str, long j, xg0 xg0Var) {
        Objects.toString(componentName);
        Objects.toString(bitmap);
        Objects.toString(xg0Var);
        try {
            this.g.getPackageManager().getActivityIcon(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            String strI = i(componentName);
            String str2 = strI != null ? strI : str;
            if (str2 != null) {
                int i = xg0Var.h;
                ContentValues contentValuesA = A(Bitmap.createScaledBitmap(bitmap, i, i, true), str2, 0, 0, 0, null, 0);
                contentValuesA.put("componentName", componentName.flattenToString());
                contentValuesA.put("profileId", Long.valueOf(j));
                this.c.e(contentValuesA);
            }
        }
    }

    public final synchronized void D(ComponentName componentName, jq1 jq1Var) {
        Objects.toString(componentName);
        Objects.toString(jq1Var);
        this.k.remove(new dl(componentName, jq1Var));
        this.e.remove(componentName.getPackageName());
    }

    public final void E(String str, jq1 jq1Var) {
        Objects.toString(jq1Var);
        HashSet<dl> hashSet = new HashSet();
        HashMap map = this.k;
        for (dl dlVar : map.keySet()) {
            if (dlVar.a.getPackageName().equals(str) && dlVar.b.equals(jq1Var)) {
                hashSet.add(dlVar);
            }
        }
        for (dl dlVar2 : hashSet) {
            if (dlVar2 != null) {
                map.remove(dlVar2);
                ComponentName componentName = dlVar2.a;
                if (componentName != null) {
                    this.e.remove(componentName.getPackageName());
                }
            }
        }
    }

    public final void F(String str, jq1 jq1Var) {
        Objects.toString(jq1Var);
        HashSet<dl> hashSet = new HashSet();
        HashMap map = this.k;
        for (dl dlVar : map.keySet()) {
            if (dlVar.a.flattenToString().equals(str) && dlVar.b.equals(jq1Var)) {
                hashSet.add(dlVar);
            }
        }
        for (dl dlVar2 : hashSet) {
            if (dlVar2 != null) {
                map.remove(dlVar2);
                ComponentName componentName = dlVar2.a;
                if (componentName != null) {
                    this.e.remove(componentName.getPackageName());
                }
            }
        }
    }

    public final synchronized void G(String str, jq1 jq1Var) {
        Objects.toString(jq1Var);
        F(str, jq1Var);
        this.c.a("componentName = ? AND profileId = ?", new String[]{str, Long.toString(this.b.o(jq1Var))});
    }

    public final synchronized void H(String str, jq1 jq1Var) {
        Objects.toString(jq1Var);
        E(str, jq1Var);
        long jO = this.b.o(jq1Var);
        this.c.a("componentName LIKE ? AND profileId = ?", new String[]{str + "/%", Long.toString(jO)});
    }

    public final ContentValues I(ek0 ek0Var) {
        Objects.toString(ek0Var);
        ComponentName componentNameB = ek0Var.b();
        dl dlVar = new dl(componentNameB, ek0Var.f());
        int i = 0;
        ke0 ke0Var = null;
        le0 le0Var = new le0(0, (String) null, 1);
        HashMap map = this.k;
        ke0 ke0Var2 = (ke0) map.get(dlVar);
        if (ke0Var2 != null && !ke0Var2.d && ke0Var2.a != null) {
            ke0Var = ke0Var2;
        }
        if (ke0Var == null) {
            ke0Var = new ke0();
            le0Var = h(dlVar);
            if (le0Var.c == 1) {
                le0Var.b = r(dlVar, le0Var.b, String.valueOf(ek0Var.e()), ek0Var.a());
            }
            Drawable drawableK = k(le0Var);
            Context context = this.g;
            if (drawableK != null) {
                ke0Var.a = q(ar1.b(drawableK, ek0Var.f(), context));
                i = 1;
            } else {
                ke0Var.a = q(ar1.b(ek0Var.d(this.l), ek0Var.f(), context));
            }
        }
        CharSequence charSequenceI = i(componentNameB);
        if (charSequenceI == null) {
            charSequenceI = ek0Var.e();
        }
        ke0Var.b = charSequenceI;
        ke0Var.c = this.b.j(charSequenceI, ek0Var.f());
        map.put(new dl(ek0Var.b(), ek0Var.f()), ke0Var);
        return A(ke0Var.a, ke0Var.b.toString(), this.m, i, le0Var.b, le0Var.a, le0Var.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0199 A[PHI: r13 r18 r21 r25
  0x0199: PHI (r13v2 android.database.Cursor) = (r13v3 android.database.Cursor), (r13v5 android.database.Cursor) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0199: PHI (r18v2 long) = (r18v4 long), (r18v5 long) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0199: PHI (r21v2 java.util.HashMap) = (r21v4 java.util.HashMap), (r21v8 java.util.HashMap) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0199: PHI (r25v2 java.util.HashMap) = (r25v4 java.util.HashMap), (r25v8 java.util.HashMap) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(java.util.HashSet r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oe0.J(java.util.HashSet):void");
    }

    public final q11 K(BubbleTextView bubbleTextView, qh0 qh0Var) {
        Objects.toString(bubbleTextView);
        Objects.toString(qh0Var);
        xm xmVar = new xm(this, qh0Var, bubbleTextView, 3, false);
        Handler handler = this.d;
        handler.post(xmVar);
        return new q11(xmVar, handler, 13);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:? -> B:23:0x004f). Please report as a decompilation issue!!! */
    public final synchronized void L(String str, jq1 jq1Var) throws Throwable {
        try {
            Objects.toString(jq1Var);
            if (z(str)) {
                return;
            }
            H(str, jq1Var);
            try {
                PackageInfo packageInfo = this.h.getPackageInfo(str, 8192);
                long jO = this.b.o(jq1Var);
                for (ek0 ek0Var : this.i.r(str, jq1Var)) {
                    Objects.toString(ek0Var);
                    Objects.toString(packageInfo);
                    try {
                        try {
                            c(I(ek0Var), ek0Var.b(), packageInfo, jO);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            return;
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final synchronized void a(String str, jq1 jq1Var, int i) {
        Objects.toString(jq1Var);
        try {
            long jO = this.b.o(jq1Var);
            ContentValues contentValues = new ContentValues();
            contentValues.put("data2", Integer.valueOf(i));
            this.c.i(contentValues, new String[]{str, Long.toString(jO)});
            try {
                SharedPreferences.Editor editorEdit = this.j.edit();
                editorEdit.putInt(str, i);
                editorEdit.apply();
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public final synchronized void b(String str, jq1 jq1Var, String str2) {
        Objects.toString(jq1Var);
        try {
            long jO = this.b.o(jq1Var);
            ContentValues contentValues = new ContentValues();
            contentValues.put("label", str2);
            this.c.i(contentValues, new String[]{str, Long.toString(jO)});
            try {
                SharedPreferences.Editor editorEdit = this.j.edit();
                editorEdit.putString("custom_label_" + str, str2);
                editorEdit.apply();
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public final void c(ContentValues contentValues, ComponentName componentName, PackageInfo packageInfo, long j) {
        Objects.toString(contentValues);
        Objects.toString(componentName);
        Objects.toString(packageInfo);
        if (contentValues.get("label") != null) {
            contentValues.put("componentName", componentName.flattenToString());
            contentValues.put("profileId", Long.valueOf(j));
            contentValues.put("lastUpdated", Long.valueOf(packageInfo.lastUpdateTime));
            contentValues.put("version", Integer.valueOf(packageInfo.versionCode));
            this.c.e(contentValues);
        }
    }

    public final void d(ek0 ek0Var, PackageInfo packageInfo, long j, int i, String str, int i2) {
        int i3;
        int i4;
        Objects.toString(ek0Var);
        Objects.toString(packageInfo);
        Objects.toString(ek0Var);
        ComponentName componentNameB = ek0Var.b();
        dl dlVar = new dl(componentNameB, ek0Var.f());
        HashMap map = this.k;
        ke0 ke0Var = new ke0();
        Context context = this.g;
        Drawable drawableCreateFromPath = null;
        try {
            if (i2 == 1) {
                i3 = i;
                int iR = r(dlVar, i3, String.valueOf(ek0Var.e()), ek0Var.a());
                if (iR > 0) {
                    drawableCreateFromPath = context.getDrawable(iR);
                }
            } else {
                i3 = i;
                if (i2 == 2) {
                    if (!TextUtils.isEmpty(str)) {
                        drawableCreateFromPath = Drawable.createFromPath(str);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (drawableCreateFromPath != null) {
            ke0Var.a = q(ar1.b(drawableCreateFromPath, ek0Var.f(), context));
            i4 = 1;
        } else {
            ke0Var.a = q(ar1.b(ek0Var.d(this.l), ek0Var.f(), context));
            i4 = 0;
        }
        CharSequence charSequenceI = i(componentNameB);
        if (charSequenceI == null) {
            charSequenceI = ek0Var.e();
        }
        ke0Var.b = charSequenceI;
        ke0Var.c = this.b.j(charSequenceI, ek0Var.f());
        map.put(new dl(ek0Var.b(), ek0Var.f()), ke0Var);
        c(A(ke0Var.a, ke0Var.b.toString(), this.m, i4, i3, str, i2), ek0Var.b(), packageInfo, j);
    }

    public final ke0 e(ComponentName componentName, ek0 ek0Var, jq1 jq1Var, boolean z, boolean z2) {
        Objects.toString(componentName);
        Objects.toString(ek0Var);
        Objects.toString(jq1Var);
        dl dlVar = new dl(componentName, jq1Var);
        HashMap map = this.k;
        ke0 ke0Var = (ke0) map.get(dlVar);
        if (ke0Var != null && (!ke0Var.d || z2)) {
            return ke0Var;
        }
        ke0 ke0Var2 = new ke0();
        map.put(dlVar, ke0Var2);
        if (B(dlVar, ke0Var2, z2)) {
            if (ek0Var != null) {
                le0 le0VarH = h(dlVar);
                if (le0VarH.c == 1) {
                    le0VarH.b = r(dlVar, le0VarH.b, String.valueOf(ek0Var.e()), ek0Var.a());
                }
                Drawable drawableK = k(le0VarH);
                Context context = this.g;
                try {
                    if (drawableK != null) {
                        ke0Var2.a = q(ar1.b(drawableK, ek0Var.f(), context));
                    } else {
                        ke0Var2.a = q(ar1.b(ek0Var.d(this.l), ek0Var.f(), context));
                    }
                } catch (Throwable th) {
                    Objects.toString(componentName);
                    th.getMessage();
                    ke0Var2.a = j(jq1Var);
                }
            } else {
                if (z) {
                    ke0 ke0VarL = l(componentName.getPackageName(), jq1Var, false);
                    componentName.toShortString();
                    ke0Var2.a = ke0VarL.a;
                    ke0Var2.b = ke0VarL.b;
                    ke0Var2.c = ke0VarL.c;
                }
                if (ke0Var2.a == null) {
                    componentName.toShortString();
                    ke0Var2.a = j(jq1Var);
                }
            }
        }
        if (TextUtils.isEmpty(ke0Var2.b) && ek0Var != null) {
            CharSequence charSequenceE = ek0Var.e();
            ke0Var2.b = charSequenceE;
            ke0Var2.c = this.b.j(charSequenceE, jq1Var);
        }
        String strI = i(componentName);
        if (strI != null) {
            ke0Var2.b = strI;
        }
        return ke0Var2;
    }

    public final synchronized void f(String str, jq1 jq1Var, int i, String str2, int i2) {
        Objects.toString(jq1Var);
        G(str, jq1Var);
        try {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
            if (componentNameUnflattenFromString != null) {
                String packageName = componentNameUnflattenFromString.getPackageName();
                PackageInfo packageInfo = this.h.getPackageInfo(packageName, 8192);
                long jO = this.b.o(jq1Var);
                for (ek0 ek0Var : this.i.r(packageName, jq1Var)) {
                    if (ek0Var != null && ek0Var.b() != null && str.equals(ek0Var.b().flattenToString())) {
                        d(ek0Var, packageInfo, jO, i, str2, i2);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final int g(ComponentName componentName) {
        try {
            return this.j.getInt(componentName.flattenToString(), 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final le0 h(dl dlVar) {
        Cursor cursorH;
        int identifier;
        Objects.toString(dlVar);
        try {
            cursorH = this.c.h("componentName = ? AND profileId = ?", new String[]{"iconName", "data1", "data4"}, new String[]{dlVar.a.flattenToString(), Long.toString(this.b.o(dlVar.b))});
            try {
                if (cursorH.moveToNext()) {
                    String string = cursorH.getString(cursorH.getColumnIndexOrThrow("iconName"));
                    int i = cursorH.getInt(cursorH.getColumnIndexOrThrow("data1"));
                    if (i == 2 && !TextUtils.isEmpty(string)) {
                        le0 le0Var = new le0(0, string, 2);
                        cursorH.close();
                        return le0Var;
                    }
                    if (i == 1 && !TextUtils.isEmpty(string)) {
                        Context context = this.g;
                        try {
                            identifier = context.getResources().getIdentifier(string, "drawable", context.getPackageName());
                        } catch (Throwable unused) {
                            identifier = 0;
                        }
                        le0 le0Var2 = new le0(identifier, (String) null, 1);
                        cursorH.close();
                        return le0Var2;
                    }
                }
            } catch (Throwable unused2) {
                if (cursorH != null) {
                }
                return new le0(0, (String) null, 1);
            }
        } catch (Throwable unused3) {
            cursorH = null;
        }
        cursorH.close();
        return new le0(0, (String) null, 1);
    }

    public final String i(ComponentName componentName) {
        try {
            return this.j.getString("custom_label_" + componentName.flattenToString(), null);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public final synchronized Bitmap j(jq1 jq1Var) {
        try {
            Objects.toString(jq1Var);
            if (!this.f.containsKey(jq1Var)) {
                HashMap map = this.f;
                Objects.toString(jq1Var);
                map.put(jq1Var, ar1.b(m(), jq1Var, this.g));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Bitmap) this.f.get(jq1Var);
    }

    public final Drawable k(le0 le0Var) {
        int i;
        try {
            int i2 = le0Var.c;
            if (i2 != 2) {
                if (i2 != 1 || (i = le0Var.b) <= 0) {
                    return null;
                }
                return this.g.getDrawable(i);
            }
            String str = le0Var.a;
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return Drawable.createFromPath(str);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final ke0 l(String str, jq1 jq1Var, boolean z) {
        iy iyVar = this.b;
        PackageManager packageManager = this.h;
        Objects.toString(jq1Var);
        dl dlVarS = s(str, jq1Var);
        HashMap map = this.k;
        ke0 ke0Var = (ke0) map.get(dlVarS);
        if (ke0Var != null && (!ke0Var.d || z)) {
            return ke0Var;
        }
        ke0 ke0Var2 = new ke0();
        if (B(dlVarS, ke0Var2, z)) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, jq1.b().equals(jq1Var) ? 0 : 8192);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null) {
                    throw new PackageManager.NameNotFoundException("ApplicationInfo is null");
                }
                le0 le0VarH = h(dlVarS);
                int i = 1;
                if (le0VarH.c == 1) {
                    le0VarH.b = r(dlVarS, le0VarH.b, String.valueOf(applicationInfo.loadLabel(packageManager)), applicationInfo);
                }
                Drawable drawableK = k(le0VarH);
                Context context = this.g;
                if (drawableK != null) {
                    ke0Var2.a = q(ar1.b(drawableK, jq1Var, context));
                } else {
                    ke0Var2.a = q(ar1.b(applicationInfo.loadIcon(packageManager), jq1Var, context));
                    i = 0;
                }
                CharSequence charSequenceLoadLabel = applicationInfo.loadLabel(packageManager);
                ke0Var2.b = charSequenceLoadLabel;
                ke0Var2.c = iyVar.j(charSequenceLoadLabel, jq1Var);
                ke0Var2.d = false;
                String strI = i(dlVarS.a);
                ke0Var2.b = strI != null ? strI : ke0Var2.b.toString();
                c(A(ke0Var2.a, strI, this.n, i, le0VarH.b, le0VarH.a, le0VarH.c), dlVarS.a, packageInfo, iyVar.o(jq1Var));
            } catch (PackageManager.NameNotFoundException unused) {
                return ke0Var2;
            }
        }
        map.put(dlVarS, ke0Var2);
        return ke0Var2;
    }

    public final Drawable m() {
        return n(ar1.d ? R.drawable.sym_def_app_icon : R.mipmap.sym_def_app_icon, Resources.getSystem());
    }

    public final Drawable n(int i, Resources resources) {
        Drawable drawableForDensity;
        Objects.toString(resources);
        try {
            drawableForDensity = resources.getDrawableForDensity(i, this.l);
        } catch (Resources.NotFoundException unused) {
            drawableForDensity = null;
        }
        return drawableForDensity != null ? drawableForDensity : m();
    }

    public final Drawable o(ActivityInfo activityInfo) {
        Resources resourcesForApplication;
        int iconResource;
        Objects.toString(activityInfo);
        try {
            resourcesForApplication = this.h.getResourcesForApplication(activityInfo.applicationInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            resourcesForApplication = null;
        }
        return (resourcesForApplication == null || (iconResource = activityInfo.getIconResource()) == 0) ? m() : n(iconResource, resourcesForApplication);
    }

    public final synchronized Bitmap p(Intent intent, jq1 jq1Var) throws Throwable {
        Throwable th;
        try {
            try {
                Objects.toString(intent);
                Objects.toString(jq1Var);
                ComponentName component = intent.getComponent();
                if (component != null) {
                    return e(component, this.i.F(intent, jq1Var), jq1Var, true, false).a;
                }
                try {
                    return j(jq1Var);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    public final Bitmap q(Bitmap bitmap) {
        Objects.toString(bitmap);
        return ar1.p(this.g, bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r(defpackage.dl r7, int r8, java.lang.String r9, android.content.pm.ApplicationInfo r10) {
        /*
            Method dump skipped, instruction units count: 1453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oe0.r(dl, int, java.lang.String, android.content.pm.ApplicationInfo):int");
    }

    public final synchronized void t(v6 v6Var, ek0 ek0Var) {
        Throwable th;
        jq1 jq1VarF;
        try {
            try {
                Objects.toString(v6Var);
                Objects.toString(ek0Var);
                if (ek0Var == null) {
                    try {
                        jq1VarF = v6Var.w;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    jq1VarF = ek0Var.f();
                }
                jq1 jq1Var = jq1VarF;
                ke0 ke0VarE = e(v6Var.A, ek0Var, jq1Var, false, false);
                v6Var.u = ar1.B(ke0VarE.b);
                Objects.toString(ke0VarE);
                Objects.toString(jq1Var);
                Bitmap bitmapJ = ke0VarE.a;
                if (bitmapJ == null) {
                    bitmapJ = j(jq1Var);
                }
                v6Var.y = bitmapJ;
                v6Var.v = ke0VarE.c;
                v6Var.z = ke0VarE.d;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void u(og1 og1Var, ComponentName componentName, ek0 ek0Var, jq1 jq1Var, boolean z, boolean z2) {
        try {
            try {
                Objects.toString(og1Var);
                Objects.toString(componentName);
                Objects.toString(ek0Var);
                Objects.toString(jq1Var);
                ke0 ke0VarE = e(componentName, ek0Var, jq1Var, z, z2);
                Objects.toString(ke0VarE);
                Objects.toString(jq1Var);
                Bitmap bitmapJ = ke0VarE.a;
                if (bitmapJ == null) {
                    bitmapJ = j(jq1Var);
                }
                og1Var.C = bitmapJ;
                og1Var.u = ar1.B(ke0VarE.b);
                og1Var.z = x(ke0VarE.a, jq1Var);
                og1Var.A = ke0VarE.d;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized void v(og1 og1Var, Intent intent, jq1 jq1Var, boolean z) {
        Throwable th;
        try {
            try {
                Objects.toString(og1Var);
                Objects.toString(intent);
                Objects.toString(jq1Var);
                ComponentName component = intent.getComponent();
                if (component == null) {
                    try {
                        og1Var.C = j(jq1Var);
                        og1Var.u = "";
                        og1Var.z = true;
                        og1Var.A = false;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    u(og1Var, component, this.i.F(intent, jq1Var), jq1Var, true, z);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void w(String str, jq1 jq1Var, boolean z, s01 s01Var) {
        Objects.toString(jq1Var);
        Objects.toString(s01Var);
        ke0 ke0VarL = l(str, jq1Var, z);
        Objects.toString(ke0VarL);
        Objects.toString(jq1Var);
        Bitmap bitmapJ = ke0VarL.a;
        if (bitmapJ == null) {
            bitmapJ = j(jq1Var);
        }
        s01Var.x = bitmapJ;
        s01Var.u = ar1.B(ke0VarL.b);
        s01Var.y = ke0VarL.d;
        s01Var.v = ke0VarL.c;
    }

    public final boolean x(Bitmap bitmap, jq1 jq1Var) {
        Objects.toString(bitmap);
        Objects.toString(jq1Var);
        return this.f.get(jq1Var) == bitmap;
    }

    public final boolean y(int i, String str) {
        HashMap map = this.e;
        if (map.containsValue(Integer.valueOf(i))) {
            return false;
        }
        map.put(str, Integer.valueOf(i));
        return true;
    }

    public final boolean z(String str) {
        Cursor cursorH = null;
        try {
            cursorH = this.c.h("componentName LIKE ?", new String[]{"customIcon", "iconName"}, new String[]{"%" + str + "%"});
            if (cursorH != null) {
                int columnIndexOrThrow = cursorH.getColumnIndexOrThrow("customIcon");
                int columnIndexOrThrow2 = cursorH.getColumnIndexOrThrow("iconName");
                while (cursorH.moveToNext()) {
                    int i = cursorH.getInt(columnIndexOrThrow);
                    String string = cursorH.getString(columnIndexOrThrow2);
                    if (i > 0 || !TextUtils.isEmpty(string)) {
                        cursorH.close();
                        return true;
                    }
                }
            }
            if (cursorH == null) {
                return false;
            }
        } catch (Throwable unused) {
            if (cursorH == null) {
                return false;
            }
        }
        cursorH.close();
        return false;
    }
}
