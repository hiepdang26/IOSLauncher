package defpackage;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
public final class pj0 extends AsyncTask {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public pj0(jz jzVar, k11 k11Var) {
        this.c = jzVar;
        this.b = k11Var;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        switch (this.a) {
            case 0:
                ((lk0) this.b).deleteAppWidgetId(((qk0) this.c).x);
                return null;
            default:
                try {
                    return ((jz) this.c).b();
                } catch (Exception unused) {
                    return null;
                }
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        switch (this.a) {
            case 1:
                ((k11) this.b).b((m11) obj);
                break;
            default:
                super.onPostExecute(obj);
                break;
        }
    }

    public pj0(lk0 lk0Var, qk0 qk0Var) {
        this.b = lk0Var;
        this.c = qk0Var;
    }
}
