package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class qq1 extends pq1 {
    public final PackageManager q;
    public final Context r;

    public qq1(Context context) {
        super(context);
        this.q = context.getPackageManager();
        this.r = context;
    }

    @Override // defpackage.pq1, defpackage.iy
    public final void i() {
        synchronized (this) {
            try {
                this.n = new wp0();
                this.o = new HashMap();
                List<UserHandle> userProfiles = this.p.getUserProfiles();
                if (userProfiles != null) {
                    for (UserHandle userHandle : userProfiles) {
                        long serialNumberForUser = this.p.getSerialNumberForUser(userHandle);
                        jq1 jq1VarA = jq1.a(userHandle);
                        this.n.put(serialNumberForUser, jq1VarA);
                        this.o.put(jq1VarA, Long.valueOf(serialNumberForUser));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.iy
    public final CharSequence j(CharSequence charSequence, jq1 jq1Var) {
        return jq1Var == null ? charSequence : this.q.getUserBadgedLabel(charSequence, jq1Var.a);
    }

    @Override // defpackage.iy
    public final long q(jq1 jq1Var) {
        try {
            if (ar1.i) {
                return this.p.getUserCreationTime(jq1Var.a);
            }
            SharedPreferences sharedPreferencesQ = ar1.q(this.r);
            String str = "user_creation_time_" + o(jq1Var);
            if (!sharedPreferencesQ.contains(str)) {
                sharedPreferencesQ.edit().putLong(str, System.currentTimeMillis()).apply();
            }
            return sharedPreferencesQ.getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // defpackage.iy
    public final List t() {
        synchronized (this) {
            try {
                if (this.n != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.o.keySet());
                    return arrayList;
                }
                List<UserHandle> userProfiles = this.p.getUserProfiles();
                if (userProfiles == null) {
                    return Collections.EMPTY_LIST;
                }
                ArrayList arrayList2 = new ArrayList(userProfiles.size());
                Iterator<UserHandle> it = userProfiles.iterator();
                while (it.hasNext()) {
                    arrayList2.add(jq1.a(it.next()));
                }
                return arrayList2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
