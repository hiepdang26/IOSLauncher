package defpackage;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.profileinstaller.ProfileVersion;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.data.a;
import com.google.android.gms.internal.ads.zzbcs;
import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzhfv;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class wb2 implements e7, hg, c40, nb1, tf0, my0, jl0, zzbcs {
    public static wb2 k;
    public static wb2 l;
    public final /* synthetic */ int g;
    public Object h;
    public Object i;
    public Object j;

    public /* synthetic */ wb2(int i, boolean z) {
        this.g = i;
    }

    public static final SharedPreferences F(Context context) {
        return context.getSharedPreferences("app_set_id_storage", 0);
    }

    public static final void G(Context context) throws rb2 {
        SharedPreferences sharedPreferencesF = F(context);
        if (sharedPreferencesF.edit().putLong("app_set_id_last_used_time", System.currentTimeMillis()).commit()) {
            return;
        }
        String strValueOf = String.valueOf(context.getPackageName());
        if (strValueOf.length() != 0) {
            "Failed to store app set ID last used time for App ".concat(strValueOf);
        }
        throw new rb2("Failed to store the app set ID last used time.");
    }

    public void A(kn knVar, int i, int i2, int i3) {
        int i4 = knVar.c0;
        int i5 = knVar.d0;
        knVar.c0 = 0;
        knVar.d0 = 0;
        knVar.N(i2);
        knVar.K(i3);
        if (i4 < 0) {
            knVar.c0 = 0;
        } else {
            knVar.c0 = i4;
        }
        if (i5 < 0) {
            knVar.d0 = 0;
        } else {
            knVar.d0 = i5;
        }
        kn knVar2 = (kn) this.j;
        knVar2.w0 = i;
        knVar2.T();
    }

    public void D(kn knVar) {
        ArrayList arrayList = (ArrayList) this.h;
        arrayList.clear();
        int size = knVar.t0.size();
        for (int i = 0; i < size; i++) {
            jn jnVar = (jn) knVar.t0.get(i);
            in[] inVarArr = jnVar.T;
            in inVar = inVarArr[0];
            in inVar2 = in.i;
            if (inVar == inVar2 || inVarArr[1] == inVar2) {
                arrayList.add(jnVar);
            }
        }
        knVar.v0.b = true;
    }

    public void E(String str, double d, double d2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i = 0;
        while (true) {
            arrayList = (ArrayList) this.h;
            int size = arrayList.size();
            arrayList2 = (ArrayList) this.i;
            arrayList3 = (ArrayList) this.j;
            if (i >= size) {
                break;
            }
            double dDoubleValue = ((Double) arrayList3.get(i)).doubleValue();
            double dDoubleValue2 = ((Double) arrayList2.get(i)).doubleValue();
            if (d < dDoubleValue || (dDoubleValue == d && d2 < dDoubleValue2)) {
                break;
            } else {
                i++;
            }
        }
        arrayList.add(i, str);
        arrayList3.add(i, Double.valueOf(d));
        arrayList2.add(i, Double.valueOf(d2));
    }

    public void H() {
        synchronized (((HashMap) this.h)) {
            try {
                Iterator it = ((HashMap) this.h).values().iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                }
                ((HashMap) this.h).clear();
            } finally {
            }
        }
        synchronized (((HashMap) this.j)) {
            try {
                Iterator it2 = ((HashMap) this.j).values().iterator();
                while (it2.hasNext()) {
                    if (it2.next() != null) {
                        throw new ClassCastException();
                    }
                }
                ((HashMap) this.j).clear();
            } finally {
            }
        }
        synchronized (((HashMap) this.i)) {
            try {
                Iterator it3 = ((HashMap) this.i).values().iterator();
                while (it3.hasNext()) {
                    if (it3.next() != null) {
                        throw new ClassCastException();
                    }
                }
                ((HashMap) this.i).clear();
            } finally {
            }
        }
    }

    @Override // defpackage.e7
    public od2 a() {
        qm1 qm1Var = new qm1();
        ((ExecutorService) this.j).execute(new gb2(this, qm1Var, 0));
        return qm1Var.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.c40
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.Object r7, defpackage.go r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof defpackage.fw
            if (r0 == 0) goto L13
            r0 = r8
            fw r0 = (defpackage.fw) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            fw r0 = new fw
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.g
            hp r1 = defpackage.hp.g
            int r2 = r0.i
            zp1 r3 = defpackage.zp1.a
            r4 = 1
            if (r2 == 0) goto L31
            if (r2 != r4) goto L29
            defpackage.np1.I(r8)
            return r3
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            defpackage.np1.I(r8)
            java.lang.Object r8 = r6.h
            gw r8 = (defpackage.gw) r8
            r8.getClass()
            java.lang.Object r8 = r6.i
            t91 r8 = (defpackage.t91) r8
            java.lang.Object r2 = r8.g
            wg1 r5 = defpackage.np1.c
            if (r2 == r5) goto L4b
            boolean r2 = defpackage.qg0.d(r2, r7)
            if (r2 != 0) goto L5a
        L4b:
            r8.g = r7
            r0.i = r4
            java.lang.Object r8 = r6.j
            c40 r8 = (defpackage.c40) r8
            java.lang.Object r7 = r8.b(r7, r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wb2.b(java.lang.Object, go):java.lang.Object");
    }

    @Override // defpackage.tf0
    public Object c() {
        return null;
    }

    @Override // defpackage.tf0
    public Uri d() {
        return (Uri) this.h;
    }

    @Override // defpackage.jl0
    public boolean f(w40 w40Var, qh0 qh0Var, ComponentName componentName) {
        if (!((HashSet) this.h).contains(componentName.getPackageName()) || !qh0Var.w.equals((jq1) this.i)) {
            return false;
        }
        ((HashSet) this.j).add(componentName);
        return true;
    }

    @Override // defpackage.tf0
    public Uri g() {
        return (Uri) this.j;
    }

    @Override // defpackage.tf0
    public ClipDescription getDescription() {
        return (ClipDescription) this.i;
    }

    public Object h() {
        Object objA = ((l21) this.j).a();
        if (objA == null) {
            objA = ((h20) this.h).create();
            if (Log.isLoggable("FactoryPools", 2)) {
                objA.getClass().toString();
            }
        }
        if (objA instanceof i20) {
            ((i20) objA).b().a = false;
        }
        return objA;
    }

    public void i(w50 w50Var) {
        if (((ArrayList) this.h).contains(w50Var)) {
            throw new IllegalStateException("Fragment already added: " + w50Var);
        }
        synchronized (((ArrayList) this.h)) {
            ((ArrayList) this.h).add(w50Var);
        }
        w50Var.r = true;
    }

    public void j(int[] iArr, ValueAnimator valueAnimator) {
        m21 m21Var = new m21();
        valueAnimator.addListener((be) this.j);
        ((ArrayList) this.h).add(m21Var);
    }

    public mz0 k() {
        mz0 mz0Var = new mz0((UUID) this.h, (lz1) this.i, (LinkedHashSet) this.j);
        nn nnVar = ((lz1) this.i).j;
        int i = Build.VERSION.SDK_INT;
        boolean z = (i >= 24 && nnVar.a()) || nnVar.d || nnVar.b || (i >= 23 && nnVar.c);
        lz1 lz1Var = (lz1) this.i;
        if (lz1Var.q) {
            if (z) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            if (lz1Var.g > 0) {
                throw new IllegalArgumentException("Expedited jobs cannot be delayed");
            }
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        qg0.k(uuidRandomUUID, "randomUUID()");
        this.h = uuidRandomUUID;
        String string = uuidRandomUUID.toString();
        qg0.k(string, "id.toString()");
        lz1 lz1Var2 = (lz1) this.i;
        qg0.l(lz1Var2, "other");
        this.i = new lz1(string, lz1Var2.b, lz1Var2.c, lz1Var2.d, new wr(lz1Var2.e), new wr(lz1Var2.f), lz1Var2.g, lz1Var2.h, lz1Var2.i, new nn(lz1Var2.j), lz1Var2.k, lz1Var2.l, lz1Var2.m, lz1Var2.n, lz1Var2.o, lz1Var2.p, lz1Var2.q, lz1Var2.r, lz1Var2.s, lz1Var2.u, lz1Var2.v, lz1Var2.w, 524288);
        return mz0Var;
    }

    @Override // defpackage.nb1
    public eb1 l(eb1 eb1Var, g01 g01Var) {
        Drawable drawable = (Drawable) eb1Var.get();
        if (drawable instanceof BitmapDrawable) {
            return ((t3) this.i).l(pc.b((oc) this.h, ((BitmapDrawable) drawable).getBitmap()), g01Var);
        }
        if (drawable instanceof l80) {
            return ((ka0) this.j).l(eb1Var, g01Var);
        }
        return null;
    }

    public int m(String str, String str2) {
        boolean z = false;
        boolean z2 = str.length() > 0 && Character.isLetterOrDigit(str.codePointAt(0));
        if (str2.length() > 0 && Character.isLetterOrDigit(str2.codePointAt(0))) {
            z = true;
        }
        if (z2 && !z) {
            return -1;
        }
        if (z2 || !z) {
            return ((Collator) this.h).compare(str, str2);
        }
        return 1;
    }

    @Override // defpackage.hg
    public void n() {
        View view = (View) this.h;
        view.clearAnimation();
        ((ViewGroup) this.i).endViewTransition(view);
        ((au) this.j).d();
    }

    public Bitmap o(BitmapFactory.Options options) {
        switch (this.g) {
            case 15:
                return BitmapFactory.decodeStream(new af(cf.c((ByteBuffer) this.h)), null, options);
            case 16:
                k81 k81Var = (k81) ((fz1) this.h).h;
                k81Var.reset();
                return BitmapFactory.decodeStream(k81Var, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((a) this.j).a().getFileDescriptor(), null, options);
        }
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        CellLayout cellLayout = (CellLayout) this.i;
        t tVar = (t) this.j;
        if (cellLayout == null) {
            tVar.getDragController().a();
            return;
        }
        Workspace workspace = tVar.getWorkspace();
        int iIndexOfChild = workspace.indexOfChild((CellLayout) this.i);
        if (iIndexOfChild != workspace.getCurrentPage()) {
            workspace.Z(iIndexOfChild);
        }
    }

    public w50 q(String str) {
        androidx.fragment.app.a aVar = (androidx.fragment.app.a) ((HashMap) this.i).get(str);
        if (aVar != null) {
            return aVar.c;
        }
        return null;
    }

    public w50 r(String str) {
        for (androidx.fragment.app.a aVar : ((HashMap) this.i).values()) {
            if (aVar != null) {
                w50 w50VarR = aVar.c;
                if (!str.equals(w50VarR.l)) {
                    w50VarR = w50VarR.A.c.r(str);
                }
                if (w50VarR != null) {
                    return w50VarR;
                }
            }
        }
        return null;
    }

    public ArrayList s() {
        ArrayList arrayList = new ArrayList();
        for (androidx.fragment.app.a aVar : ((HashMap) this.i).values()) {
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public List t() {
        ArrayList arrayList;
        if (((ArrayList) this.h).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.h)) {
            arrayList = new ArrayList((ArrayList) this.h);
        }
        return arrayList;
    }

    public ImageHeaderParser$ImageType u() throws Throwable {
        switch (this.g) {
            case 15:
                return np1.t((ArrayList) this.i, cf.c((ByteBuffer) this.h));
            case 16:
                k81 k81Var = (k81) ((fz1) this.h).h;
                k81Var.reset();
                return np1.s((ArrayList) this.j, k81Var, (cq0) this.i);
            default:
                a aVar = (a) this.j;
                cq0 cq0Var = (cq0) this.h;
                ArrayList arrayList = (ArrayList) this.i;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    af0 af0Var = (af0) arrayList.get(i);
                    k81 k81Var2 = null;
                    try {
                        k81 k81Var3 = new k81(new FileInputStream(aVar.a().getFileDescriptor()), cq0Var);
                        try {
                            ImageHeaderParser$ImageType imageHeaderParser$ImageTypeD = af0Var.d(k81Var3);
                            k81Var3.b();
                            aVar.a();
                            if (imageHeaderParser$ImageTypeD != ImageHeaderParser$ImageType.UNKNOWN) {
                                return imageHeaderParser$ImageTypeD;
                            }
                        } catch (Throwable th) {
                            th = th;
                            k81Var2 = k81Var3;
                            if (k81Var2 != null) {
                                k81Var2.b();
                            }
                            aVar.a();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public void v(androidx.fragment.app.a aVar) {
        w50 w50Var = aVar.c;
        String str = w50Var.l;
        HashMap map = (HashMap) this.i;
        if (map.get(str) != null) {
            return;
        }
        map.put(w50Var.l, aVar);
        if (h60.E(2)) {
            w50Var.toString();
        }
    }

    public void w(androidx.fragment.app.a aVar) {
        w50 w50Var = aVar.c;
        if (w50Var.H) {
            ((j60) this.j).b(w50Var);
        }
        if (((androidx.fragment.app.a) ((HashMap) this.i).put(w50Var.l, null)) != null && h60.E(2)) {
            w50Var.toString();
        }
    }

    public boolean x(int i, om omVar, jn jnVar) {
        in[] inVarArr = jnVar.T;
        in inVar = inVarArr[0];
        ub ubVar = (ub) this.i;
        ubVar.a = inVar;
        ubVar.b = inVarArr[1];
        ubVar.c = jnVar.r();
        ubVar.d = jnVar.l();
        ubVar.i = false;
        ubVar.j = i;
        in inVar2 = ubVar.a;
        in inVar3 = in.i;
        boolean z = inVar2 == inVar3;
        boolean z2 = ubVar.b == inVar3;
        boolean z3 = z && jnVar.X > 0.0f;
        boolean z4 = z2 && jnVar.X > 0.0f;
        in inVar4 = in.g;
        int[] iArr = jnVar.t;
        if (z3 && iArr[0] == 4) {
            ubVar.a = inVar4;
        }
        if (z4 && iArr[1] == 4) {
            ubVar.b = inVar4;
        }
        omVar.b(jnVar, ubVar);
        jnVar.N(ubVar.e);
        jnVar.K(ubVar.f);
        jnVar.E = ubVar.h;
        int i2 = ubVar.g;
        jnVar.b0 = i2;
        jnVar.E = i2 > 0;
        ubVar.j = 0;
        return ubVar.i;
    }

    public void y(um0 um0Var) {
        dl0 dl0Var = (dl0) this.j;
        if (dl0Var != null) {
            dl0Var.run();
        }
        dl0 dl0Var2 = new dl0((androidx.lifecycle.a) this.h, um0Var);
        this.j = dl0Var2;
        ((Handler) this.i).postAtFrontOfQueue(dl0Var2);
    }

    public boolean z(Object obj) {
        if (obj instanceof i20) {
            ((i20) obj).b().a = true;
        }
        ((j20) this.i).d(obj);
        return ((l21) this.j).c(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public void zza() {
        zzbct zzbctVar = (zzbct) this.i;
        or orVarZza = zzbctVar.zza();
        Intent intent = new Intent("android.intent.action.VIEW");
        if (orVarZza != null) {
            intent.setPackage(orVarZza.d.getPackageName());
            kr krVar = orVarZza.c;
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", krVar);
            intent.putExtras(bundle);
        }
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle2 = new Bundle();
            bundle2.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle2);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
        intent.putExtras(new Bundle());
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
        Context context = (Context) this.h;
        intent.setPackage(zzhfv.zza(context));
        intent.setData((Uri) this.j);
        context.startActivity(intent, null);
        zzbctVar.zzf((Activity) context);
    }

    public wb2(zzbct zzbctVar, Context context, Uri uri) {
        this.g = 28;
        this.i = zzbctVar;
        this.h = context;
        this.j = uri;
    }

    public /* synthetic */ wb2(Object obj, Object obj2, Object obj3, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
        this.j = obj3;
    }

    public wb2(m21 m21Var) {
        this.g = 26;
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
    }

    public wb2(Context context, int i) {
        this.g = i;
        switch (i) {
            case 2:
                this.h = Collator.getInstance();
                this.i = new z6(this, context);
                this.j = new a7(this, 0);
                break;
            case 5:
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(z71.o(context, ir0.class.getCanonicalName(), q41.materialCalendarStyle), f71.MaterialCalendar);
                y2.d(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendar_dayStyle, 0));
                this.j = y2.d(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendar_dayInvalidStyle, 0));
                y2.d(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendar_daySelectedStyle, 0));
                y2.d(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendar_dayTodayStyle, 0));
                ColorStateList colorStateListL = np1.l(context, typedArrayObtainStyledAttributes, f71.MaterialCalendar_rangeFillColor);
                this.h = y2.d(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendar_yearStyle, 0));
                y2.d(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendar_yearSelectedStyle, 0));
                this.i = y2.d(context, typedArrayObtainStyledAttributes.getResourceId(f71.MaterialCalendar_yearTodayStyle, 0));
                new Paint().setColor(colorStateListL.getDefaultColor());
                typedArrayObtainStyledAttributes.recycle();
                break;
            default:
                ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                this.i = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                this.j = Executors.newSingleThreadExecutor();
                this.h = context;
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new da2(this, 4), 0L, 86400L, TimeUnit.SECONDS);
                break;
        }
    }

    private final void B() {
    }

    private final void C() {
    }

    @Override // defpackage.tf0
    public void e() {
    }

    public wb2(hn0 hn0Var) {
        this.g = 20;
        this.h = new androidx.lifecycle.a(hn0Var);
        this.i = new Handler();
    }

    public wb2(int i) {
        this.g = i;
        switch (i) {
            case 22:
                this.h = new ArrayList();
                this.i = null;
                this.j = new be(this, 17);
                break;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                List list = Collections.EMPTY_LIST;
                this.h = list;
                this.i = list;
                break;
            case 27:
                this.h = new ArrayList();
                this.i = new ArrayList();
                this.j = new ArrayList();
                break;
            default:
                this.h = new ArrayList();
                this.i = new HashMap();
                break;
        }
    }

    public wb2(Class cls) {
        this.g = 19;
        UUID uuidRandomUUID = UUID.randomUUID();
        qg0.k(uuidRandomUUID, "randomUUID()");
        this.h = uuidRandomUUID;
        String string = ((UUID) this.h).toString();
        qg0.k(string, "id.toString()");
        this.i = new lz1(string, 0, cls.getName(), (String) null, (wr) null, (wr) null, 0L, 0L, 0L, (nn) null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0L, 0, 0, 8388602);
        String[] strArr = {cls.getName()};
        LinkedHashSet linkedHashSet = new LinkedHashSet(uq0.E(1));
        linkedHashSet.add(strArr[0]);
        this.j = linkedHashSet;
    }

    public wb2(Context context, LocationManager locationManager) {
        this.g = 23;
        this.j = new lp1();
        this.h = context;
        this.i = locationManager;
    }

    public wb2(kn knVar) {
        this.g = 3;
        this.h = new ArrayList();
        this.i = new ub();
        this.j = knVar;
    }

    public wb2(l21 l21Var, h20 h20Var, j20 j20Var) {
        this.g = 13;
        this.j = l21Var;
        this.h = h20Var;
        this.i = j20Var;
    }

    public wb2(vq0 vq0Var, ArrayList arrayList, cq0 cq0Var) {
        this.g = 16;
        n90.h(cq0Var, "Argument must not be null");
        this.i = cq0Var;
        n90.h(arrayList, "Argument must not be null");
        this.j = arrayList;
        this.h = new fz1(vq0Var, cq0Var);
    }

    public wb2(ow1 ow1Var) {
        this.g = 1;
        this.g = 1;
        this.h = ow1Var;
        this.i = Choreographer.getInstance();
        this.j = new l5(this, 0);
    }

    public wb2(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, cq0 cq0Var) {
        this.g = 17;
        n90.h(cq0Var, "Argument must not be null");
        this.h = cq0Var;
        n90.h(arrayList, "Argument must not be null");
        this.i = arrayList;
        this.j = new a(parcelFileDescriptor);
    }

    public wb2(d00 d00Var, yg1 yg1Var, h00 h00Var) {
        this.g = 12;
        this.j = d00Var;
        this.i = yg1Var;
        this.h = h00Var;
    }
}
