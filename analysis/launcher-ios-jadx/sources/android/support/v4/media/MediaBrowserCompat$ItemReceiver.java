package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import defpackage.bc1;
import defpackage.hs0;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends bc1 {
    @Override // defpackage.bc1
    public final void a(int i, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(hs0.class.getClassLoader());
        }
        if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
            throw null;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
            throw null;
        }
        throw null;
    }
}
