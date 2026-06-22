package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.a2;
import defpackage.an0;
import defpackage.az1;
import defpackage.b2;
import defpackage.c2;
import defpackage.d2;
import defpackage.e2;
import defpackage.en0;
import defpackage.f2;
import defpackage.um0;
import defpackage.vm0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public Random a = new Random();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public ArrayList e = new ArrayList();
    public final transient HashMap f = new HashMap();
    public final HashMap g = new HashMap();
    public final Bundle h = new Bundle();

    public final boolean a(int i, int i2, Intent intent) {
        String str = (String) this.b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        e2 e2Var = (e2) this.f.get(str);
        if (e2Var != null) {
            b2 b2Var = e2Var.a;
            if (this.e.contains(str)) {
                b2Var.i(e2Var.b.D(i2, intent));
                this.e.remove(str);
                return true;
            }
        }
        this.g.remove(str);
        this.h.putParcelable(str, new a2(i2, intent));
        return true;
    }

    public abstract void b(int i, az1 az1Var, Intent intent);

    public final d2 c(String str, az1 az1Var, b2 b2Var) {
        e(str);
        this.f.put(str, new e2(b2Var, az1Var));
        HashMap map = this.g;
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            map.remove(str);
            b2Var.i(obj);
        }
        Bundle bundle = this.h;
        a2 a2Var = (a2) bundle.getParcelable(str);
        if (a2Var != null) {
            bundle.remove(str);
            b2Var.i(az1Var.D(a2Var.g, a2Var.h));
        }
        return new d2(this, str, az1Var, 1);
    }

    public final d2 d(final String str, androidx.activity.a aVar, final c2 c2Var, final b2 b2Var) {
        androidx.lifecycle.a aVar2 = aVar.j;
        if (aVar2.c.compareTo(vm0.j) >= 0) {
            throw new IllegalStateException("LifecycleOwner " + aVar + " is attempting to register while current state is " + aVar2.c + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        HashMap map = this.d;
        f2 f2Var = (f2) map.get(str);
        if (f2Var == null) {
            f2Var = new f2(aVar2);
        }
        an0 an0Var = new an0() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // defpackage.an0
            public final void a(en0 en0Var, um0 um0Var) {
                boolean zEquals = um0.ON_START.equals(um0Var);
                String str2 = str;
                a aVar3 = this.j;
                if (!zEquals) {
                    if (um0.ON_STOP.equals(um0Var)) {
                        aVar3.f.remove(str2);
                        return;
                    } else {
                        if (um0.ON_DESTROY.equals(um0Var)) {
                            aVar3.f(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap map2 = aVar3.f;
                b2 b2Var2 = b2Var;
                map2.put(str2, new e2(b2Var2, c2Var));
                HashMap map3 = aVar3.g;
                if (map3.containsKey(str2)) {
                    Object obj = map3.get(str2);
                    map3.remove(str2);
                    b2Var2.i(obj);
                }
                Bundle bundle = aVar3.h;
                a2 a2Var = (a2) bundle.getParcelable(str2);
                if (a2Var != null) {
                    bundle.remove(str2);
                    b2Var2.i(new a2(a2Var.g, a2Var.h));
                }
            }
        };
        f2Var.a.a(an0Var);
        f2Var.b.add(an0Var);
        map.put(str, f2Var);
        return new d2(this, str, c2Var, 0);
    }

    public final void e(String str) {
        HashMap map = this.c;
        if (((Integer) map.get(str)) != null) {
            return;
        }
        int iNextInt = this.a.nextInt(2147418112);
        while (true) {
            int i = iNextInt + ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST;
            HashMap map2 = this.b;
            if (!map2.containsKey(Integer.valueOf(i))) {
                map2.put(Integer.valueOf(i), str);
                map.put(str, Integer.valueOf(i));
                return;
            }
            iNextInt = this.a.nextInt(2147418112);
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.e.contains(str) && (num = (Integer) this.c.remove(str)) != null) {
            this.b.remove(num);
        }
        this.f.remove(str);
        HashMap map = this.g;
        if (map.containsKey(str)) {
            Objects.toString(map.get(str));
            map.remove(str);
        }
        Bundle bundle = this.h;
        if (bundle.containsKey(str)) {
            Objects.toString(bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap map2 = this.d;
        f2 f2Var = (f2) map2.get(str);
        if (f2Var != null) {
            ArrayList arrayList = f2Var.b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                f2Var.a.f((an0) obj);
            }
            arrayList.clear();
            map2.remove(str);
        }
    }
}
