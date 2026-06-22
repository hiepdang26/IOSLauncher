package defpackage;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class o7 {
    public static /* bridge */ /* synthetic */ MeasurementManager d(Object obj) {
        return (MeasurementManager) obj;
    }

    public static /* synthetic */ GetTopicsRequest.Builder e() {
        return new GetTopicsRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ GetTopicsResponse i(Object obj) {
        return (GetTopicsResponse) obj;
    }

    public static /* bridge */ /* synthetic */ Topic j(Object obj) {
        return (Topic) obj;
    }

    public static /* bridge */ /* synthetic */ TopicsManager k(Object obj) {
        return (TopicsManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return MeasurementManager.class;
    }

    public static /* synthetic */ void o() {
        new DeletionRequest.Builder();
    }

    public static /* bridge */ /* synthetic */ Class u() {
        return TopicsManager.class;
    }

    public static /* synthetic */ void v() {
    }

    public static /* synthetic */ void w() {
    }
}
