package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.hs0;
import defpackage.z1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new z1(26);
    public final int g;
    public final long h;
    public final long i;
    public final float j;
    public final long k;
    public final int l;
    public final CharSequence m;
    public final long n;
    public final ArrayList o;
    public final long p;
    public final Bundle q;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();
        public final String g;
        public final CharSequence h;
        public final int i;
        public final Bundle j;

        public CustomAction(Parcel parcel) {
            this.g = parcel.readString();
            this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.i = parcel.readInt();
            this.j = parcel.readBundle(hs0.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.h) + ", mIcon=" + this.i + ", mExtras=" + this.j;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.g);
            TextUtils.writeToParcel(this.h, parcel, i);
            parcel.writeInt(this.i);
            parcel.writeBundle(this.j);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.g = parcel.readInt();
        this.h = parcel.readLong();
        this.j = parcel.readFloat();
        this.n = parcel.readLong();
        this.i = parcel.readLong();
        this.k = parcel.readLong();
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.o = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.p = parcel.readLong();
        this.q = parcel.readBundle(hs0.class.getClassLoader());
        this.l = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.g + ", position=" + this.h + ", buffered position=" + this.i + ", speed=" + this.j + ", updated=" + this.n + ", actions=" + this.k + ", error code=" + this.l + ", error message=" + this.m + ", custom actions=" + this.o + ", active item id=" + this.p + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeLong(this.h);
        parcel.writeFloat(this.j);
        parcel.writeLong(this.n);
        parcel.writeLong(this.i);
        parcel.writeLong(this.k);
        TextUtils.writeToParcel(this.m, parcel, i);
        parcel.writeTypedList(this.o);
        parcel.writeLong(this.p);
        parcel.writeBundle(this.q);
        parcel.writeInt(this.l);
    }
}
