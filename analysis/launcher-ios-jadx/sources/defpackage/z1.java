package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVersion;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.z1;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class z1 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ z1(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Uri mediaUri;
        Bundle bundle;
        switch (this.a) {
            case 0:
                return new a2(parcel);
            case 1:
                return new da(parcel);
            case 2:
                pa paVar = new pa();
                paVar.j = 255;
                paVar.k = -2;
                paVar.l = -2;
                paVar.r = Boolean.TRUE;
                paVar.g = parcel.readInt();
                paVar.h = (Integer) parcel.readSerializable();
                paVar.i = (Integer) parcel.readSerializable();
                paVar.j = parcel.readInt();
                paVar.k = parcel.readInt();
                paVar.l = parcel.readInt();
                paVar.n = parcel.readString();
                paVar.o = parcel.readInt();
                paVar.q = (Integer) parcel.readSerializable();
                paVar.s = (Integer) parcel.readSerializable();
                paVar.t = (Integer) parcel.readSerializable();
                paVar.u = (Integer) parcel.readSerializable();
                paVar.v = (Integer) parcel.readSerializable();
                paVar.w = (Integer) parcel.readSerializable();
                paVar.x = (Integer) parcel.readSerializable();
                paVar.r = (Boolean) parcel.readSerializable();
                paVar.m = (Locale) parcel.readSerializable();
                return paVar;
            case 3:
                return new lf((pu0) parcel.readParcelable(pu0.class.getClassLoader()), (pu0) parcel.readParcelable(pu0.class.getClassLoader()), (ls) parcel.readParcelable(ls.class.getClassLoader()), (pu0) parcel.readParcelable(pu0.class.getClassLoader()));
            case 4:
                return new op((Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Exception) parcel.readSerializable(), parcel.createFloatArray(), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 5:
                qp qpVar = new qp();
                qpVar.g = rp.values()[parcel.readInt()];
                qpVar.h = parcel.readFloat();
                qpVar.i = parcel.readFloat();
                qpVar.j = parcel.readFloat();
                qpVar.k = sp.values()[parcel.readInt()];
                qpVar.l = yp.values()[parcel.readInt()];
                qpVar.m = parcel.readByte() != 0;
                qpVar.n = parcel.readByte() != 0;
                qpVar.o = parcel.readByte() != 0;
                qpVar.p = parcel.readByte() != 0;
                qpVar.q = parcel.readInt();
                qpVar.r = parcel.readFloat();
                qpVar.s = parcel.readByte() != 0;
                qpVar.t = parcel.readInt();
                qpVar.u = parcel.readInt();
                qpVar.v = parcel.readFloat();
                qpVar.w = parcel.readInt();
                qpVar.x = parcel.readFloat();
                qpVar.y = parcel.readFloat();
                qpVar.z = parcel.readFloat();
                qpVar.A = parcel.readInt();
                qpVar.B = parcel.readFloat();
                qpVar.C = parcel.readInt();
                qpVar.D = parcel.readInt();
                qpVar.E = parcel.readInt();
                qpVar.F = parcel.readInt();
                qpVar.G = parcel.readInt();
                qpVar.H = parcel.readInt();
                qpVar.I = parcel.readInt();
                qpVar.J = parcel.readInt();
                Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
                qpVar.K = (CharSequence) creator.createFromParcel(parcel);
                qpVar.L = parcel.readInt();
                qpVar.M = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
                qpVar.N = Bitmap.CompressFormat.valueOf(parcel.readString());
                qpVar.O = parcel.readInt();
                qpVar.P = parcel.readInt();
                qpVar.Q = parcel.readInt();
                qpVar.c0 = uo.y(5)[parcel.readInt()];
                qpVar.R = parcel.readByte() != 0;
                qpVar.S = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
                qpVar.T = parcel.readInt();
                qpVar.U = parcel.readByte() != 0;
                qpVar.V = parcel.readByte() != 0;
                qpVar.W = parcel.readByte() != 0;
                qpVar.X = parcel.readInt();
                qpVar.Y = parcel.readByte() != 0;
                qpVar.Z = parcel.readByte() != 0;
                qpVar.a0 = (CharSequence) creator.createFromParcel(parcel);
                qpVar.b0 = parcel.readInt();
                return qpVar;
            case 6:
                return new ls(parcel.readLong());
            case 7:
                return new ny(parcel);
            case 8:
                e60 e60Var = new e60();
                e60Var.g = parcel.readString();
                e60Var.h = parcel.readInt();
                return e60Var;
            case 9:
                i60 i60Var = new i60();
                i60Var.k = null;
                i60Var.l = new ArrayList();
                i60Var.m = new ArrayList();
                i60Var.g = parcel.createTypedArrayList(m60.CREATOR);
                i60Var.h = parcel.createStringArrayList();
                i60Var.i = (da[]) parcel.createTypedArray(da.CREATOR);
                i60Var.j = parcel.readInt();
                i60Var.k = parcel.readString();
                i60Var.l = parcel.createStringArrayList();
                i60Var.m = parcel.createTypedArrayList(Bundle.CREATOR);
                i60Var.n = parcel.createTypedArrayList(e60.CREATOR);
                return i60Var;
            case 10:
                return new m60(parcel);
            case 11:
                return new lg0(parcel);
            case 12:
                on0 on0Var = new on0();
                on0Var.g = parcel.readInt();
                on0Var.h = parcel.readInt();
                on0Var.i = parcel.readInt() == 1;
                return on0Var;
            case 13:
                return new xn0(parcel);
            case 14:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new z1(14);
                    public final int g;
                    public final MediaDescriptionCompat h;

                    {
                        this.g = parcel.readInt();
                        this.h = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.g + ", mDescription=" + this.h + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i) {
                        parcel2.writeInt(this.g);
                        this.h.writeToParcel(parcel2, i);
                    }
                };
            case 15:
                int i = Build.VERSION.SDK_INT;
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String mediaId = mediaDescription.getMediaId();
                CharSequence title = mediaDescription.getTitle();
                CharSequence subtitle = mediaDescription.getSubtitle();
                CharSequence description = mediaDescription.getDescription();
                Bitmap iconBitmap = mediaDescription.getIconBitmap();
                Uri iconUri = mediaDescription.getIconUri();
                Bundle extras = mediaDescription.getExtras();
                if (extras != null) {
                    extras.setClassLoader(hs0.class.getClassLoader());
                    mediaUri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                } else {
                    mediaUri = null;
                }
                if (mediaUri == null) {
                    bundle = extras;
                } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                    bundle = null;
                } else {
                    extras.remove("android.support.v4.media.description.MEDIA_URI");
                    extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = extras;
                }
                if (mediaUri == null) {
                    mediaUri = i >= 23 ? mediaDescription.getMediaUri() : null;
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
                mediaDescriptionCompat.o = objCreateFromParcel;
                return mediaDescriptionCompat;
            case 16:
                return new MediaMetadataCompat(parcel);
            case 17:
                return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new z1(17);
                    public final MediaDescriptionCompat g;
                    public final long h;

                    {
                        this.g = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        this.h = parcel.readLong();
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaSession.QueueItem {Description=" + this.g + ", Id=" + this.h + " }";
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i2) {
                        this.g.writeToParcel(parcel2, i2);
                        parcel2.writeLong(this.h);
                    }
                };
            case 18:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.g = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 19:
                final Parcelable parcelable = parcel.readParcelable(null);
                return new Parcelable(parcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new z1(19);
                    public final Parcelable g;

                    {
                        this.g = parcelable;
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MediaSessionCompat$Token)) {
                            return false;
                        }
                        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
                        Parcelable parcelable2 = this.g;
                        if (parcelable2 == null) {
                            return mediaSessionCompat$Token.g == null;
                        }
                        Parcelable parcelable3 = mediaSessionCompat$Token.g;
                        if (parcelable3 == null) {
                            return false;
                        }
                        return parcelable2.equals(parcelable3);
                    }

                    public final int hashCode() {
                        Parcelable parcelable2 = this.g;
                        if (parcelable2 == null) {
                            return 0;
                        }
                        return parcelable2.hashCode();
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i2) {
                        parcel2.writeParcelable(this.g, i2);
                    }
                };
            case 20:
                return pu0.b(parcel.readInt(), parcel.readInt());
            case zzbbc.zzt.zzm /* 21 */:
                return new cv0(parcel);
            case 22:
                uw0 uw0Var = new uw0(parcel);
                uw0Var.g = parcel.readInt();
                return uw0Var;
            case 23:
                return new ParcelImpl(parcel);
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                n11 n11Var = new n11();
                ClassLoader classLoader = n11.class.getClassLoader();
                int i2 = parcel.readInt();
                for (int i3 = 0; i3 < i2; i3++) {
                    n11Var.put(parcel.readInt(), parcel.readParcelable(classLoader));
                }
                return n11Var;
            case 25:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.g = parcel.readInt();
                parcelableVolumeInfo.i = parcel.readInt();
                parcelableVolumeInfo.j = parcel.readInt();
                parcelableVolumeInfo.k = parcel.readInt();
                parcelableVolumeInfo.h = parcel.readInt();
                return parcelableVolumeInfo;
            case 26:
                return new PlaybackStateCompat(parcel);
            case 27:
                return new r21(parcel);
            case 28:
                return new a31(parcel);
            default:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new a2[i];
            case 1:
                return new da[i];
            case 2:
                return new pa[i];
            case 3:
                return new lf[i];
            case 4:
                return new op[i];
            case 5:
                return new qp[i];
            case 6:
                return new ls[i];
            case 7:
                return new ny[i];
            case 8:
                return new e60[i];
            case 9:
                return new i60[i];
            case 10:
                return new m60[i];
            case 11:
                return new lg0[i];
            case 12:
                return new on0[i];
            case 13:
                return new xn0[i];
            case 14:
                return new MediaBrowserCompat$MediaItem[i];
            case 15:
                return new MediaDescriptionCompat[i];
            case 16:
                return new MediaMetadataCompat[i];
            case 17:
                return new MediaSessionCompat$QueueItem[i];
            case 18:
                return new MediaSessionCompat$ResultReceiverWrapper[i];
            case 19:
                return new MediaSessionCompat$Token[i];
            case 20:
                return new pu0[i];
            case zzbbc.zzt.zzm /* 21 */:
                return new cv0[i];
            case 22:
                return new uw0[i];
            case 23:
                return new ParcelImpl[i];
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                return new n11[i];
            case 25:
                return new ParcelableVolumeInfo[i];
            case 26:
                return new PlaybackStateCompat[i];
            case 27:
                return new r21[i];
            case 28:
                return new a31[i];
            default:
                return new RatingCompat[i];
        }
    }
}
