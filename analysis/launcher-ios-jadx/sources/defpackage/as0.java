package defpackage;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;

/* JADX INFO: loaded from: classes.dex */
public final class as0 {
    public final MeasurementManager a;

    public as0(Context context) {
        qg0.l(context, "context");
        Object systemService = context.getSystemService((Class<Object>) o7.m());
        qg0.k(systemService, "context.getSystemService…:class.java\n            )");
        this.a = o7.d(systemService);
    }

    public Object a(pu puVar, eo eoVar) {
        new gg(1, e42.d(eoVar)).o();
        o7.o();
        throw null;
    }

    public Object b(eo eoVar) {
        gg ggVar = new gg(1, e42.d(eoVar));
        ggVar.o();
        this.a.getMeasurementApiStatus(new t8(1), new io(ggVar));
        return ggVar.n();
    }

    public Object c(Uri uri, InputEvent inputEvent, eo eoVar) {
        gg ggVar = new gg(1, e42.d(eoVar));
        ggVar.o();
        this.a.registerSource(uri, inputEvent, new t8(1), new io(ggVar));
        Object objN = ggVar.n();
        return objN == hp.g ? objN : zp1.a;
    }

    public Object d(Uri uri, eo eoVar) {
        gg ggVar = new gg(1, e42.d(eoVar));
        ggVar.o();
        this.a.registerTrigger(uri, new t8(1), new io(ggVar));
        Object objN = ggVar.n();
        return objN == hp.g ? objN : zp1.a;
    }

    public Object e(qw1 qw1Var, eo eoVar) {
        new gg(1, e42.d(eoVar)).o();
        o7.v();
        throw null;
    }

    public Object f(rw1 rw1Var, eo eoVar) {
        new gg(1, e42.d(eoVar)).o();
        o7.w();
        throw null;
    }
}
