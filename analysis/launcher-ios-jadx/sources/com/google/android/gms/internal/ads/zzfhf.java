package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import defpackage.pd2;
import defpackage.tb2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhf implements zzfhe {
    private final Object[] zza;

    public zzfhf(tb2 tb2Var, String str, int i, String str2, pd2 pd2Var) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(tb2Var.h));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zza(tb2Var.i));
        } else if (hashSet.contains("npa")) {
            arrayList.add(tb2Var.i.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(tb2Var.j));
        }
        if (hashSet.contains("keywords")) {
            List list = tb2Var.k;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(tb2Var.l));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(tb2Var.m));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(tb2Var.n));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(tb2Var.o);
        }
        if (hashSet.contains("location")) {
            Location location = tb2Var.q;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(tb2Var.r);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zza(tb2Var.s));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zza(tb2Var.t));
        }
        if (hashSet.contains("categoryExclusions")) {
            List list2 = tb2Var.u;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(tb2Var.v);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(tb2Var.w);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(tb2Var.x));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(tb2Var.z));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(tb2Var.A);
        }
        if (hashSet.contains("orientation")) {
            if (pd2Var != null) {
                arrayList.add(Integer.valueOf(pd2Var.g));
            } else {
                arrayList.add(null);
            }
        }
        this.zza = arrayList.toArray();
    }

    private static String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? zza((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfhe
    public final boolean equals(Object obj) {
        if (obj instanceof zzfhf) {
            return Arrays.equals(this.zza, ((zzfhf) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfhe
    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        Object[] objArr = this.zza;
        return "[PoolKey#" + Arrays.hashCode(objArr) + " " + Arrays.toString(objArr) + "]";
    }
}
