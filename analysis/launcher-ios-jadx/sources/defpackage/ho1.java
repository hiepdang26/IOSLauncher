package defpackage;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.TopicsManager;

/* JADX INFO: loaded from: classes.dex */
public final class ho1 extends lo1 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ho1(TopicsManager topicsManager, int i) {
        super(topicsManager);
        this.b = i;
    }

    @Override // defpackage.lo1
    public GetTopicsRequest a(j80 j80Var) {
        switch (this.b) {
            case 1:
                qg0.l(j80Var, "request");
                GetTopicsRequest getTopicsRequestBuild = o7.e().setAdsSdkName("com.google.android.gms.ads").setShouldRecordObservation(j80Var.a).build();
                qg0.k(getTopicsRequestBuild, "Builder()\n            .s…ion)\n            .build()");
                return getTopicsRequestBuild;
            default:
                return super.a(j80Var);
        }
    }
}
