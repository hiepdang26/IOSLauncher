package defpackage;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.luutinhit.launcher6.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s1 implements Runnable {
    public final /* synthetic */ int g;
    public final int h;
    public final Object i;
    public final Object j;

    public /* synthetic */ s1(Object obj, int i, Object obj2, int i2) {
        this.g = i2;
        this.j = obj;
        this.h = i;
        this.i = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int i = 0;
        Object obj = this.i;
        int i2 = this.h;
        Object obj2 = this.j;
        switch (this.g) {
            case 0:
                String[] strArr = (String[]) obj;
                int[] iArr = new int[strArr.length];
                Activity activity = (Activity) obj2;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                while (i < length) {
                    iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    i++;
                }
                ((u1) activity).onRequestPermissionsResult(i2, strArr, iArr);
                break;
            case 1:
                int i3 = BottomSheetBehavior.b0;
                ((BottomSheetBehavior) obj2).D((View) obj, i2, false);
                break;
            case 2:
                Object obj3 = ((mc1) obj).h;
                al alVar = (al) obj2;
                String str = (String) alVar.b.get(Integer.valueOf(i2));
                if (str != null) {
                    e2 e2Var = (e2) alVar.f.get(str);
                    if (e2Var == null) {
                        alVar.h.remove(str);
                        alVar.g.put(str, obj3);
                    } else {
                        b2 b2Var = e2Var.a;
                        if (alVar.e.remove(str)) {
                            b2Var.i(obj3);
                        }
                    }
                    break;
                }
                break;
            case 3:
                ((al) obj2).a(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj));
                break;
            case 4:
                ((kr) obj2).h.onNavigationEvent(i2, (Bundle) obj);
                break;
            case 5:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                if (i2 == 1) {
                    while (i < size) {
                        ((xy) arrayList.get(i)).onInitialized();
                        i++;
                    }
                } else {
                    while (i < size) {
                        ((xy) arrayList.get(i)).onFailed((Throwable) obj2);
                        i++;
                    }
                }
                break;
            case 6:
                vh0 vh0Var = (vh0) obj2;
                RecyclerView recyclerView = vh0Var.x;
                if (recyclerView != null && recyclerView.y) {
                    sh0 sh0Var = (sh0) obj;
                    if (!sh0Var.q) {
                        m91 m91Var = sh0Var.k;
                        if (m91Var.d() != -1) {
                            r81 itemAnimator = vh0Var.x.getItemAnimator();
                            if (itemAnimator == null || !itemAnimator.f()) {
                                ArrayList arrayList2 = vh0Var.v;
                                int size2 = arrayList2.size();
                                while (i < size2) {
                                    if (((sh0) arrayList2.get(i)).r) {
                                        i++;
                                    }
                                }
                                vh0Var.s.u(m91Var, i2);
                            }
                            vh0Var.x.post(this);
                        }
                    }
                    break;
                }
                break;
            case 7:
                hl0 hl0VarL = ((u) obj2).l((hl0) obj);
                if (hl0VarL != null && i2 != -1001) {
                    hl0VarL.onPageBoundSynchronously(i2);
                    break;
                }
                break;
            case 8:
                ((hl1) obj).a(i2, (Intent) obj2);
                break;
            default:
                ((SystemForegroundService) obj2).k.notify(i2, (Notification) obj);
                break;
        }
    }

    public /* synthetic */ s1(Object obj, Object obj2, int i, int i2) {
        this.g = i2;
        this.i = obj;
        this.j = obj2;
        this.h = i;
    }

    public /* synthetic */ s1(Object obj, Object obj2, int i, int i2, boolean z) {
        this.g = i2;
        this.j = obj;
        this.i = obj2;
        this.h = i;
    }

    public s1(List list, int i, Throwable th) {
        this.g = 5;
        qg0.j(list, "initCallbacks cannot be null");
        this.i = new ArrayList(list);
        this.h = i;
        this.j = th;
    }
}
