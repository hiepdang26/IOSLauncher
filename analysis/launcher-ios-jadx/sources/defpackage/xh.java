package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class xh {
    public boolean a;
    public boolean b;
    public final Object c;
    public final Object d;
    public Object e;

    public xh(int i) {
        switch (i) {
            case 2:
                this.a = false;
                this.d = new WeakHashMap();
                this.c = new m6(this, 7);
                break;
            default:
                this.c = new HashMap();
                this.d = new HashSet();
                break;
        }
    }

    public boolean a(lr0 lr0Var) {
        int id = lr0Var.getId();
        HashSet hashSet = (HashSet) this.d;
        if (hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        lr0 lr0Var2 = (lr0) ((HashMap) this.c).get(Integer.valueOf(c()));
        if (lr0Var2 != null) {
            e(lr0Var2, false);
        }
        boolean zAdd = hashSet.add(Integer.valueOf(id));
        if (!lr0Var.isChecked()) {
            lr0Var.setChecked(true);
        }
        return zAdd;
    }

    public ArrayList b(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet((HashSet) this.d);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof lr0) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int c() {
        if (!this.a) {
            return -1;
        }
        HashSet hashSet = (HashSet) this.d;
        if (hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    public void d() {
        ow1 ow1Var = (ow1) this.e;
        if (ow1Var != null) {
            new HashSet((HashSet) this.d);
            ChipGroup chipGroup = (ChipGroup) ow1Var.h;
            ni niVar = chipGroup.m;
            if (niVar != null) {
                chipGroup.n.b(chipGroup);
                ChipGroup chipGroup2 = (ChipGroup) ((fz1) niVar).h;
                if (chipGroup2.n.a) {
                    chipGroup2.getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    public boolean e(lr0 lr0Var, boolean z) {
        int id = lr0Var.getId();
        HashSet hashSet = (HashSet) this.d;
        if (!hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            lr0Var.setChecked(true);
            return false;
        }
        boolean zRemove = hashSet.remove(Integer.valueOf(id));
        if (lr0Var.isChecked()) {
            lr0Var.setChecked(false);
        }
        return zRemove;
    }

    public synchronized void f(Context context) {
        try {
            if (this.a) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            this.e = applicationContext;
            if (applicationContext == null) {
                this.e = context;
            }
            zzbbw.zza((Context) this.e);
            zzbbn zzbbnVar = zzbbw.zzdv;
            n42 n42Var = n42.d;
            this.b = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (!((Boolean) n42Var.c.zza(zzbbw.zzkb)).booleanValue() || Build.VERSION.SDK_INT < 33) {
                ((Context) this.e).registerReceiver((m6) this.c, intentFilter);
            } else {
                ((Context) this.e).registerReceiver((m6) this.c, intentFilter, 4);
            }
            this.a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void g(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.b) {
            ((WeakHashMap) this.d).remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public xh(Context context, String str, ei eiVar, boolean z, boolean z2) {
        qg0.l(context, "context");
        qg0.l(eiVar, "callback");
        this.c = context;
        this.d = str;
        this.e = eiVar;
        this.a = z;
        this.b = z2;
    }
}
