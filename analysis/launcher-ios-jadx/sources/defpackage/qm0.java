package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import com.luutinhit.launcher6.leftpage.database.LeftPageWidgetDatabase_Impl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class qm0 implements rm1 {
    public static final iy e = new iy();
    public static final aq1 f = new aq1(2);
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;

    public qm0(wb2 wb2Var) {
        iy iyVar = e;
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = wb2Var;
        this.b = iyVar;
    }

    public synchronized void a(Class cls, Class cls2, mu0 mu0Var) {
        bv0 bv0Var = new bv0(cls, cls2, mu0Var);
        ArrayList arrayList = (ArrayList) this.a;
        arrayList.add(arrayList.size(), bv0Var);
    }

    public synchronized lu0 b(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) this.a;
            int size = arrayList2.size();
            boolean z = false;
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                bv0 bv0Var = (bv0) obj;
                if (((HashSet) this.c).contains(bv0Var)) {
                    z = true;
                } else if (bv0Var.a.isAssignableFrom(cls) && bv0Var.b.isAssignableFrom(cls2)) {
                    ((HashSet) this.c).add(bv0Var);
                    arrayList.add(bv0Var.c.s(this));
                    ((HashSet) this.c).remove(bv0Var);
                }
            }
            if (arrayList.size() > 1) {
                iy iyVar = (iy) this.b;
                wb2 wb2Var = (wb2) this.d;
                iyVar.getClass();
                return new l9(arrayList, wb2Var, 2);
            }
            if (arrayList.size() == 1) {
                return (lu0) arrayList.get(0);
            }
            if (z) {
                return f;
            }
            throw new w91("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            ((HashSet) this.c).clear();
            throw th;
        }
    }

    public synchronized ArrayList c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) this.a;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                bv0 bv0Var = (bv0) obj;
                if (!((HashSet) this.c).contains(bv0Var) && bv0Var.a.isAssignableFrom(cls)) {
                    ((HashSet) this.c).add(bv0Var);
                    arrayList.add(bv0Var.c.s(this));
                    ((HashSet) this.c).remove(bv0Var);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public void d(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((ug1) this.b).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                d(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void e(Runnable runnable) {
        ((jf1) this.a).execute(runnable);
    }

    public synchronized ArrayList f(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            bv0 bv0Var = (bv0) obj;
            if (!arrayList.contains(bv0Var.b) && bv0Var.a.isAssignableFrom(cls)) {
                arrayList.add(bv0Var.b);
            }
        }
        return arrayList;
    }

    public void g(int i, int i2) {
        LeftPageWidgetDatabase_Impl leftPageWidgetDatabase_Impl = (LeftPageWidgetDatabase_Impl) this.a;
        leftPageWidgetDatabase_Impl.b();
        pm0 pm0Var = (pm0) this.d;
        z60 z60VarA = pm0Var.a();
        z60VarA.q(1, i2);
        z60VarA.q(2, i);
        try {
            leftPageWidgetDatabase_Impl.c();
            try {
                z60VarA.a();
                leftPageWidgetDatabase_Impl.n();
            } finally {
                leftPageWidgetDatabase_Impl.j();
            }
        } finally {
            pm0Var.d(z60VarA);
        }
    }

    public qm0(LeftPageWidgetDatabase_Impl leftPageWidgetDatabase_Impl) {
        this.a = leftPageWidgetDatabase_Impl;
        new su(leftPageWidgetDatabase_Impl, 1);
        this.b = new su(leftPageWidgetDatabase_Impl, 2);
        this.c = new om0(leftPageWidgetDatabase_Impl, 0);
        new om0(leftPageWidgetDatabase_Impl, 1);
        this.d = new pm0(leftPageWidgetDatabase_Impl, 0);
    }

    public qm0(int i) {
        switch (i) {
            case 4:
                this.a = new e9(0);
                this.b = new SparseArray();
                this.c = new xp0();
                this.d = new e9(0);
                break;
            default:
                this.a = new k21(10);
                this.b = new ug1(0);
                this.c = new ArrayList();
                this.d = new HashSet();
                break;
        }
    }

    public qm0(ExecutorService executorService) {
        this.c = new Handler(Looper.getMainLooper());
        this.d = new dz1(this, 0);
        jf1 jf1Var = new jf1(executorService);
        this.a = jf1Var;
        this.b = new j10(jf1Var);
    }

    public qm0(zx0 zx0Var) {
        Bundle bundle;
        int i;
        ArrayList arrayList;
        Notification.Action.Builder builder;
        Bundle bundle2;
        int i2;
        new ArrayList();
        this.d = new Bundle();
        this.c = zx0Var;
        Context context = zx0Var.a;
        this.a = context;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            this.b = ao.a(context, zx0Var.n);
        } else {
            this.b = new Notification.Builder(zx0Var.a);
        }
        Notification notification = zx0Var.p;
        ((Notification.Builder) this.b).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(zx0Var.e).setContentText(zx0Var.f).setContentInfo(null).setContentIntent(zx0Var.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        int i4 = 23;
        if (i3 < 23) {
            Notification.Builder builder2 = (Notification.Builder) this.b;
            IconCompat iconCompat = zx0Var.h;
            builder2.setLargeIcon(iconCompat == null ? null : iconCompat.c());
        } else {
            Notification.Builder builder3 = (Notification.Builder) this.b;
            IconCompat iconCompat2 = zx0Var.h;
            t1.q(builder3, iconCompat2 == null ? null : iconCompat2.g(context));
        }
        ((Notification.Builder) this.b).setSubText(null).setUsesChronometer(false).setPriority(zx0Var.i);
        ArrayList arrayList2 = zx0Var.b;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            ux0 ux0Var = (ux0) obj;
            int i6 = Build.VERSION.SDK_INT;
            if (ux0Var.b == null && (i2 = ux0Var.e) != 0) {
                ux0Var.b = IconCompat.b(i2);
            }
            IconCompat iconCompat3 = ux0Var.b;
            PendingIntent pendingIntent = ux0Var.g;
            CharSequence charSequence = ux0Var.f;
            if (i6 >= i4) {
                builder = t1.a(iconCompat3 != null ? iconCompat3.g(null) : null, charSequence, pendingIntent);
            } else {
                builder = new Notification.Action.Builder(iconCompat3 != null ? iconCompat3.d() : 0, charSequence, pendingIntent);
            }
            Bundle bundle3 = ux0Var.a;
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            boolean z = ux0Var.c;
            bundle2.putBoolean("android.support.allowGeneratedReplies", z);
            if (i6 >= 24) {
                sl.g(builder, z);
            }
            bundle2.putInt("android.support.action.semanticAction", 0);
            if (i6 >= 28) {
                eu.o(builder);
            }
            if (i6 >= 29) {
                d7.g(builder);
            }
            if (i6 >= 31) {
                ay0.a(builder);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", ux0Var.d);
            builder.addExtras(bundle2);
            ((Notification.Builder) this.b).addAction(builder.build());
            i4 = 23;
        }
        Bundle bundle4 = zx0Var.m;
        if (bundle4 != null) {
            ((Bundle) this.d).putAll(bundle4);
        }
        int i7 = Build.VERSION.SDK_INT;
        ((Notification.Builder) this.b).setShowWhen(zx0Var.j);
        ((Notification.Builder) this.b).setLocalOnly(zx0Var.l);
        ((Notification.Builder) this.b).setGroup(null);
        ((Notification.Builder) this.b).setSortKey(null);
        ((Notification.Builder) this.b).setGroupSummary(false);
        ((Notification.Builder) this.b).setCategory(null);
        ((Notification.Builder) this.b).setColor(0);
        ((Notification.Builder) this.b).setVisibility(0);
        ((Notification.Builder) this.b).setPublicVersion(null);
        ((Notification.Builder) this.b).setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList3 = zx0Var.q;
        ArrayList arrayList4 = zx0Var.c;
        if (i7 < 28) {
            if (arrayList4 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList4.size());
                Iterator it = arrayList4.iterator();
                if (it.hasNext()) {
                    throw uo.c(it);
                }
            }
            if (arrayList != null) {
                if (arrayList3 == null) {
                    arrayList3 = arrayList;
                } else {
                    g9 g9Var = new g9(arrayList3.size() + arrayList.size());
                    g9Var.addAll(arrayList);
                    g9Var.addAll(arrayList3);
                    arrayList3 = new ArrayList(g9Var);
                }
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            int i8 = 0;
            while (i8 < size2) {
                Object obj2 = arrayList3.get(i8);
                i8++;
                ((Notification.Builder) this.b).addPerson((String) obj2);
            }
        }
        ArrayList arrayList5 = zx0Var.d;
        if (arrayList5.size() > 0) {
            if (zx0Var.m == null) {
                zx0Var.m = new Bundle();
            }
            Bundle bundle5 = zx0Var.m.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            for (int i9 = 0; i9 < arrayList5.size(); i9++) {
                String string = Integer.toString(i9);
                ux0 ux0Var2 = (ux0) arrayList5.get(i9);
                Bundle bundle8 = new Bundle();
                if (ux0Var2.b == null && (i = ux0Var2.e) != 0) {
                    ux0Var2.b = IconCompat.b(i);
                }
                IconCompat iconCompat4 = ux0Var2.b;
                bundle8.putInt("icon", iconCompat4 != null ? iconCompat4.d() : 0);
                bundle8.putCharSequence("title", ux0Var2.f);
                bundle8.putParcelable("actionIntent", ux0Var2.g);
                Bundle bundle9 = ux0Var2.a;
                if (bundle9 != null) {
                    bundle = new Bundle(bundle9);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", ux0Var2.c);
                bundle8.putBundle("extras", bundle);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", ux0Var2.d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(string, bundle8);
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (zx0Var.m == null) {
                zx0Var.m = new Bundle();
            }
            zx0Var.m.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) this.d).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            ((Notification.Builder) this.b).setExtras(zx0Var.m);
            sl.h((Notification.Builder) this.b);
        }
        if (i10 >= 26) {
            ao.f((Notification.Builder) this.b);
            ao.l((Notification.Builder) this.b);
            ao.m((Notification.Builder) this.b);
            ao.n((Notification.Builder) this.b);
            ao.h((Notification.Builder) this.b);
            if (!TextUtils.isEmpty(zx0Var.n)) {
                ((Notification.Builder) this.b).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator it2 = arrayList4.iterator();
            if (it2.hasNext()) {
                throw uo.c(it2);
            }
        }
        if (i10 >= 29) {
            d7.e((Notification.Builder) this.b, zx0Var.o);
            d7.f((Notification.Builder) this.b);
        }
    }
}
