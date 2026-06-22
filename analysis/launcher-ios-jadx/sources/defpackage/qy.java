package defpackage;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.luutinhit.launcherios.activity.EditWidgetActivity;
import com.luutinhit.launcherios.activity.HiddenAppsActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class qy extends AsyncTask {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ qy(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0155  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r14) {
        /*
            Method dump skipped, instruction units count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qy.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onCancelled(Object obj) {
        switch (this.a) {
            case 2:
                ((qi0) this.b).c();
                break;
            default:
                super.onCancelled(obj);
                break;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                EditWidgetActivity editWidgetActivity = (EditWidgetActivity) this.b;
                try {
                    y00 y00Var = new y00((bz0) editWidgetActivity, editWidgetActivity.L, true);
                    editWidgetActivity.N = y00Var;
                    editWidgetActivity.G.setAdapter(y00Var);
                    editWidgetActivity.N.n = editWidgetActivity;
                    kh0 kh0Var = new kh0(arrayList);
                    editWidgetActivity.M = kh0Var;
                    editWidgetActivity.F.setAdapter(kh0Var);
                    editWidgetActivity.M.m = editWidgetActivity;
                    vh0 vh0Var = new vh0(new b3(editWidgetActivity.N, editWidgetActivity, 1));
                    editWidgetActivity.D = vh0Var;
                    vh0Var.i(editWidgetActivity.G);
                    new vh0(new b3(editWidgetActivity.M, editWidgetActivity, 0)).i(editWidgetActivity.F);
                    editWidgetActivity.H.setVisibility(8);
                    editWidgetActivity.I.clearAnimation();
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 1:
                ArrayList arrayList2 = (ArrayList) obj;
                HiddenAppsActivity hiddenAppsActivity = (HiddenAppsActivity) this.b;
                try {
                    y00 y00Var2 = new y00((bz0) hiddenAppsActivity, hiddenAppsActivity.M, false);
                    hiddenAppsActivity.O = y00Var2;
                    hiddenAppsActivity.H.setAdapter(y00Var2);
                    hiddenAppsActivity.O.n = hiddenAppsActivity;
                    kh0 kh0Var2 = new kh0(arrayList2);
                    hiddenAppsActivity.N = kh0Var2;
                    hiddenAppsActivity.G.setAdapter(kh0Var2);
                    hiddenAppsActivity.N.m = hiddenAppsActivity;
                    vh0 vh0Var2 = new vh0(new b3(hiddenAppsActivity.O, hiddenAppsActivity, 1));
                    hiddenAppsActivity.E = vh0Var2;
                    vh0Var2.i(hiddenAppsActivity.H);
                    new vh0(new b3(hiddenAppsActivity.N, hiddenAppsActivity, 0)).i(hiddenAppsActivity.G);
                    hiddenAppsActivity.I.setVisibility(8);
                    hiddenAppsActivity.J.clearAnimation();
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
                break;
            case 2:
                ((qi0) this.b).c();
                break;
            case 3:
            default:
                super.onPostExecute(obj);
                break;
            case 4:
                String str = (String) obj;
                WebView webView = ((dd2) this.b).l;
                if (webView != null && str != null) {
                    webView.loadUrl(str);
                    break;
                }
                break;
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        switch (this.a) {
            case 0:
                super.onPreExecute();
                EditWidgetActivity editWidgetActivity = (EditWidgetActivity) this.b;
                editWidgetActivity.H.setVisibility(0);
                editWidgetActivity.I.startAnimation(editWidgetActivity.J);
                EditWidgetActivity.S.postDelayed(new py(editWidgetActivity, 3), 6000L);
                break;
            case 1:
                super.onPreExecute();
                HiddenAppsActivity hiddenAppsActivity = (HiddenAppsActivity) this.b;
                hiddenAppsActivity.I.setVisibility(0);
                hiddenAppsActivity.J.startAnimation(hiddenAppsActivity.K);
                HiddenAppsActivity.T.postDelayed(new bc0(hiddenAppsActivity, 3), 6000L);
                break;
            default:
                super.onPreExecute();
                break;
        }
    }
}
