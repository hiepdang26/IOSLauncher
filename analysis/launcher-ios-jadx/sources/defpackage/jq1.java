package defpackage;

import android.os.Process;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
public final class jq1 {
    public final UserHandle a;

    public jq1(UserHandle userHandle) {
        this.a = userHandle;
    }

    public static jq1 a(UserHandle userHandle) {
        if (userHandle == null) {
            return null;
        }
        return new jq1(userHandle);
    }

    public static jq1 b() {
        return ar1.o ? new jq1(Process.myUserHandle()) : new jq1();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jq1)) {
            return false;
        }
        if (!ar1.o) {
            return true;
        }
        return this.a.equals(((jq1) obj).a);
    }

    public final int hashCode() {
        if (ar1.o) {
            return this.a.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return ar1.o ? this.a.toString() : "";
    }
}
