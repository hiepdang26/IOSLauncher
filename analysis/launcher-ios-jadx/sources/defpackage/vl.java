package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class vl extends b0 {
    public final int g;
    public final int h;
    public final PendingIntent i;
    public final String j;
    public static final vl k = new vl(0);
    public static final Parcelable.Creator<vl> CREATOR = new zb1(16);

    public vl(int i, int i2, PendingIntent pendingIntent, String str) {
        this.g = i;
        this.h = i2;
        this.i = pendingIntent;
        this.j = str;
    }

    public static String a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case zzbbc.zzt.zzm /* 21 */:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return uo.d(i, "UNKNOWN_ERROR_CODE(", ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vl)) {
            return false;
        }
        vl vlVar = (vl) obj;
        return this.h == vlVar.h && bf1.c(this.i, vlVar.i) && bf1.c(this.j, vlVar.j);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.h), this.i, this.j});
    }

    public final String toString() {
        tu tuVar = new tu(this);
        tuVar.c(a(this.h), "statusCode");
        tuVar.c(this.i, "resolution");
        tuVar.c(this.j, "message");
        return tuVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h);
        os.y(parcel, 3, this.i, i);
        os.z(parcel, 4, this.j);
        os.F(iE, parcel);
    }

    public vl(int i) {
        this(1, i, null, null);
    }

    public vl(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
