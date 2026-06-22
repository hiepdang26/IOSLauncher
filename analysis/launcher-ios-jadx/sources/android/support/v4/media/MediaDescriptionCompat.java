package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.z1;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new z1(15);
    public final String g;
    public final CharSequence h;
    public final CharSequence i;
    public final CharSequence j;
    public final Bitmap k;
    public final Uri l;
    public final Bundle m;
    public final Uri n;
    public Object o;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.g = str;
        this.h = charSequence;
        this.i = charSequence2;
        this.j = charSequence3;
        this.k = bitmap;
        this.l = uri;
        this.m = bundle;
        this.n = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.h) + ", " + ((Object) this.i) + ", " + ((Object) this.j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Object objBuild = this.o;
        if (objBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.g);
            builder.setTitle(this.h);
            builder.setSubtitle(this.i);
            builder.setDescription(this.j);
            builder.setIconBitmap(this.k);
            builder.setIconUri(this.l);
            Uri uri = this.n;
            Bundle bundle = this.m;
            if (i2 < 23 && uri != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", uri);
            }
            builder.setExtras(bundle);
            if (i2 >= 23) {
                builder.setMediaUri(uri);
            }
            objBuild = builder.build();
            this.o = objBuild;
        }
        ((MediaDescription) objBuild).writeToParcel(parcel, i);
    }
}
