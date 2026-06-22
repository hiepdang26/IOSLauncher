package defpackage;

import android.os.Parcel;
import android.view.View;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.FolderIcon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class pw1 implements c02, z91, fo {
    public Object g;

    public /* synthetic */ pw1(Object obj) {
        this.g = obj;
    }

    public boolean a(lz1 lz1Var) {
        List list = (List) this.g;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            lm lmVar = (lm) obj;
            lmVar.getClass();
            if (lmVar.b(lz1Var) && lmVar.c(lmVar.a.a())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            ka0 ka0VarJ = ka0.j();
            int i = ty1.a;
            wj.y(arrayList, null, ap.i, 31);
            ka0VarJ.getClass();
        }
        return arrayList.isEmpty();
    }

    @Override // defpackage.z91
    public void e(Object obj, Object obj2) {
        qm1 qm1Var = (qm1) obj2;
        n12 n12Var = (n12) ((s12) obj).getService();
        n12Var.getClass();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(n12Var.i);
        int i = a12.a;
        vm1 vm1Var = (vm1) this.g;
        if (vm1Var == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            vm1Var.writeToParcel(parcelObtain, 0);
        }
        try {
            n12Var.h.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            qm1Var.a(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // defpackage.c02
    public boolean h(qh0 qh0Var, View view, FolderIcon folderIcon) {
        boolean z = qh0Var instanceof og1;
        HashSet hashSet = (HashSet) this.g;
        if (z && (view instanceof BubbleTextView) && hashSet.contains(qh0Var)) {
            ((BubbleTextView) view).u(false);
            return false;
        }
        if ((view instanceof x11) && (qh0Var instanceof qk0) && hashSet.contains(qh0Var)) {
            ((x11) view).d();
        }
        return false;
    }

    @Override // defpackage.fo
    public Object then(pm1 pm1Var) {
        tu tuVar = (tu) this.g;
        if (pm1Var.d() || ((od2) pm1Var).d) {
            return pm1Var;
        }
        Exception excA = pm1Var.a();
        if (!(excA instanceof v5)) {
            return pm1Var;
        }
        int i = ((v5) excA).g.g;
        if (i == 43001 || i == 43002 || i == 43003 || i == 17) {
            return ((wb2) tuVar.i).a();
        }
        if (i == 43000) {
            Exception exc = new Exception("Failed to get app set ID due to an internal error. Please try again later.");
            od2 od2Var = new od2();
            od2Var.g(exc);
            return od2Var;
        }
        if (i != 15) {
            return pm1Var;
        }
        Exception exc2 = new Exception("The operation to get app set ID timed out. Please try again later.");
        od2 od2Var2 = new od2();
        od2Var2.g(exc2);
        return od2Var2;
    }

    public pw1(hz1 hz1Var) {
        qg0.l(hz1Var, "trackers");
        xb xbVar = new xb((fn) hz1Var.a, 0);
        xb xbVar2 = new xb((yb) hz1Var.b);
        xb xbVar3 = new xb((fn) hz1Var.d, 4);
        fn fnVar = (fn) hz1Var.c;
        this.g = xj.v(xbVar, xbVar2, xbVar3, new xb(fnVar, 2), new xb(fnVar, 3), new ex0(fnVar), new dx0(fnVar));
    }
}
