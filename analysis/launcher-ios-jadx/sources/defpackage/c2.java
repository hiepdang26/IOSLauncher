package defpackage;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c2 extends az1 {
    public final /* synthetic */ int h;

    public /* synthetic */ c2(int i) {
        this.h = i;
    }

    @Override // defpackage.az1
    public final Object D(int i, Intent intent) {
        switch (this.h) {
            case 0:
                wz wzVar = wz.g;
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i2 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i2 == 0));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArrayExtra) {
                            if (str != null) {
                                arrayList2.add(str);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList3 = new ArrayList(Math.min(yj.w(arrayList2), yj.w(arrayList)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList3.add(new h11(it.next(), it2.next()));
                        }
                        break;
                    }
                }
                break;
        }
        return new a2(i, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.az1
    public final Intent l(e6 e6Var, Intent intent) {
        Bundle bundleExtra;
        switch (this.h) {
            case 0:
                String[] strArr = (String[]) intent;
                qg0.l(strArr, "input");
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                qg0.k(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intentPutExtra;
            case 1:
                qg0.l(intent, "input");
                return intent;
            default:
                lg0 lg0Var = (lg0) intent;
                Intent intent2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent3 = lg0Var.h;
                if (intent3 != null && (bundleExtra = intent3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent3.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        lg0Var = new lg0(lg0Var.g, lg0Var.i, lg0Var.j);
                    }
                }
                intent2.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", lg0Var);
                if (h60.E(2)) {
                    intent2.toString();
                }
                return intent2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.az1
    public mc1 t(e6 e6Var, Intent intent) {
        switch (this.h) {
            case 0:
                String[] strArr = (String[]) intent;
                qg0.l(strArr, "input");
                if (strArr.length == 0) {
                    return new mc1(wz.g, 2);
                }
                for (String str : strArr) {
                    if (np1.d(e6Var, str) != 0) {
                        return null;
                    }
                }
                int iE = uq0.E(strArr.length);
                if (iE < 16) {
                    iE = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new mc1(linkedHashMap, 2);
            default:
                return super.t(e6Var, intent);
        }
    }
}
