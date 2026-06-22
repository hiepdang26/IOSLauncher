package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.motion.widget.MotionScene;
import com.google.android.gms.internal.ads.zzgxs;
import com.google.android.gms.internal.ads.zzgxy;
import defpackage.k31;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgxy<MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> extends zzgvv<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Object, zzgxy<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzhat zzt = zzhat.zzc();

    public static zzgya zzbA() {
        return zzgwc.zzd();
    }

    public static zzgya zzbB(zzgya zzgyaVar) {
        int size = zzgyaVar.size();
        return zzgyaVar.zzf(size == 0 ? 10 : size + size);
    }

    public static zzgyb zzbC() {
        return zzgxf.zze();
    }

    public static zzgyb zzbD(zzgyb zzgybVar) {
        int size = zzgybVar.size();
        return zzgybVar.zzf(size == 0 ? 10 : size + size);
    }

    public static zzgyf zzbE() {
        return zzgxp.zze();
    }

    public static zzgyf zzbF(zzgyf zzgyfVar) {
        int size = zzgyfVar.size();
        return zzgyfVar.zzf(size == 0 ? 10 : size + size);
    }

    public static zzgyg zzbG() {
        return zzgxz.zzg();
    }

    public static zzgyg zzbH(zzgyg zzgygVar) {
        int size = zzgygVar.size();
        return zzgygVar.zzf(size == 0 ? 10 : size + size);
    }

    public static zzgyj zzbI() {
        return zzgyy.zzh();
    }

    public static zzgyj zzbJ(zzgyj zzgyjVar) {
        int size = zzgyjVar.size();
        return zzgyjVar.zzf(size == 0 ? 10 : size + size);
    }

    public static <E> zzgyk<E> zzbK() {
        return zzgzu.zzd();
    }

    public static <E> zzgyk<E> zzbL(zzgyk<E> zzgykVar) {
        int size = zzgykVar.size();
        return zzgykVar.zzf(size == 0 ? 10 : size + size);
    }

    public static Object zzbR(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzbS(zzgzj zzgzjVar, String str, Object[] objArr) {
        return new zzgzv(zzgzjVar, str, objArr);
    }

    public static Method zzbT(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static <ContainingType extends zzgzj, Type> zzgxw<ContainingType, Type> zzbe(ContainingType containingtype, zzgzj zzgzjVar, zzgyd zzgydVar, int i, zzhbf zzhbfVar, boolean z, Class cls) {
        return new zzgxw<>(containingtype, Collections.EMPTY_LIST, zzgzjVar, new zzgxv(zzgydVar, i, zzhbfVar, true, z), cls);
    }

    public static <ContainingType extends zzgzj, Type> zzgxw<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzgzj zzgzjVar, zzgyd zzgydVar, int i, zzhbf zzhbfVar, Class cls) {
        return new zzgxw<>(containingtype, type, zzgzjVar, new zzgxv(zzgydVar, i, zzhbfVar, false, false), cls);
    }

    public static <T extends zzgxy> T zzbh(Class<T> cls) {
        zzgxy<?, ?> zzgxyVar = zzc.get(cls);
        if (zzgxyVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgxyVar = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgxyVar != null) {
            return zzgxyVar;
        }
        zzgxy<?, ?> zzgxyVarZzbt = ((zzgxy) zzhaz.zzg(cls)).zzbt();
        if (zzgxyVarZzbt == null) {
            throw new IllegalStateException();
        }
        zzc.put(cls, zzgxyVarZzbt);
        return zzgxyVarZzbt;
    }

    public static <T extends zzgxy<T, ?>> T zzbk(T t, InputStream inputStream) throws zzgyn {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T t2 = (T) zzf(t, inputStream, zzgxi.zza);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbl(T t, InputStream inputStream, zzgxi zzgxiVar) throws zzgyn {
        T t2 = (T) zzf(t, inputStream, zzgxiVar);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbm(T t, zzgwm zzgwmVar) throws zzgyn {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T t2 = (T) zzbr(t, zzgwmVar, zzgxi.zza);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbn(T t, zzgww zzgwwVar) {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return (T) zzbs(t, zzgwwVar, zzgxi.zza);
    }

    public static <T extends zzgxy<T, ?>> T zzbo(T t, InputStream inputStream) throws zzgyn {
        zzgww zzgwwVarZzG = zzgww.zzG(inputStream, MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T t2 = (T) zzbz(t, zzgwwVarZzG, zzgxi.zza);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbp(T t, ByteBuffer byteBuffer) {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return (T) zzbv(t, byteBuffer, zzgxi.zza);
    }

    public static <T extends zzgxy<T, ?>> T zzbq(T t, byte[] bArr) throws zzgyn {
        int length = bArr.length;
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        T t2 = (T) zzh(t, bArr, 0, length, zzgxi.zza);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbr(T t, zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        T t2 = (T) zzg(t, zzgwmVar, zzgxiVar);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbs(T t, zzgww zzgwwVar, zzgxi zzgxiVar) throws zzgyn {
        T t2 = (T) zzbz(t, zzgwwVar, zzgxiVar);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbu(T t, InputStream inputStream, zzgxi zzgxiVar) throws zzgyn {
        T t2 = (T) zzbz(t, zzgww.zzG(inputStream, MotionScene.Transition.TransitionOnClick.JUMP_TO_START), zzgxiVar);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbv(T t, ByteBuffer byteBuffer, zzgxi zzgxiVar) throws zzgyn {
        zzgww zzgwwVarZzH;
        boolean z = false;
        if (byteBuffer.hasArray()) {
            zzgwwVarZzH = zzgww.zzH(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), false);
        } else if (byteBuffer.isDirect() && zzhaz.zzB()) {
            zzgwwVarZzH = new zzgwu(byteBuffer, z, null);
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            zzgwwVarZzH = zzgww.zzH(bArr, 0, iRemaining, true);
        }
        T t2 = (T) zzbs(t, zzgwwVarZzH, zzgxiVar);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzbx(T t, byte[] bArr, zzgxi zzgxiVar) throws zzgyn {
        T t2 = (T) zzh(t, bArr, 0, bArr.length, zzgxiVar);
        zze(t2);
        return t2;
    }

    public static <T extends zzgxy<T, ?>> T zzby(T t, zzgww zzgwwVar) {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return (T) zzbz(t, zzgwwVar, zzgxi.zza);
    }

    public static <T extends zzgxy<T, ?>> T zzbz(T t, zzgww zzgwwVar, zzgxi zzgxiVar) throws zzgyn {
        T t2 = (T) t.zzbj();
        try {
            zzhae zzhaeVarZzb = zzgzt.zza().zzb(t2.getClass());
            zzhaeVarZzb.zzh(t2, zzgwx.zzq(zzgwwVar), zzgxiVar);
            zzhaeVarZzb.zzf(t2);
            return t2;
        } catch (zzgyn e) {
            if (e.zzk()) {
                throw new zzgyn(e);
            }
            throw e;
        } catch (zzhar e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgyn) {
                throw ((zzgyn) e3.getCause());
            }
            throw new zzgyn(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgyn) {
                throw ((zzgyn) e4.getCause());
            }
            throw e4;
        }
    }

    private int zzc(zzhae<?> zzhaeVar) {
        if (zzhaeVar != null) {
            return zzhaeVar.zza(this);
        }
        return zzgzt.zza().zzb(getClass()).zza(this);
    }

    public static <T extends zzgxy> void zzcb(Class<T> cls, T t) {
        t.zzbX();
        zzc.put(cls, t);
    }

    public static final <T extends zzgxy<T, ?>> boolean zzce(T t, boolean z) {
        byte bByteValue = ((Byte) t.zzbP(zzgxx.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzgzt.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.zzbQ(zzgxx.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t);
        }
        return zZzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends zzgxu<MessageType, BuilderType>, BuilderType, T> zzgxw<MessageType, T> zzd(zzgxg<MessageType, T> zzgxgVar) {
        return (zzgxw) zzgxgVar;
    }

    private static <T extends zzgxy<T, ?>> T zze(T t) throws zzgyn {
        if (t == null || t.zzbw()) {
            return t;
        }
        throw t.zzaP().zza();
    }

    private static <T extends zzgxy<T, ?>> T zzf(T t, InputStream inputStream, zzgxi zzgxiVar) throws zzgyn {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            zzgww zzgwwVarZzG = zzgww.zzG(new zzgvt(inputStream, zzgww.zzE(i, inputStream)), MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
            T t2 = (T) zzbz(t, zzgwwVarZzG, zzgxiVar);
            zzgwwVarZzG.zzy(0);
            return t2;
        } catch (zzgyn e) {
            if (e.zzk()) {
                throw new zzgyn(e);
            }
            throw e;
        } catch (IOException e2) {
            throw new zzgyn(e2);
        }
    }

    private static <T extends zzgxy<T, ?>> T zzg(T t, zzgwm zzgwmVar, zzgxi zzgxiVar) {
        zzgww zzgwwVarZzl = zzgwmVar.zzl();
        T t2 = (T) zzbz(t, zzgwwVarZzl, zzgxiVar);
        zzgwwVarZzl.zzy(0);
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends zzgxy<T, ?>> T zzh(T t, byte[] bArr, int i, int i2, zzgxi zzgxiVar) throws zzgyn {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzbj();
        try {
            zzhae zzhaeVarZzb = zzgzt.zza().zzb(t2.getClass());
            zzhaeVarZzb.zzi(t2, bArr, i, i + i2, new zzgwa(zzgxiVar));
            zzhaeVarZzb.zzf(t2);
            return t2;
        } catch (zzgyn e) {
            if (e.zzk()) {
                throw new zzgyn(e);
            }
            throw e;
        } catch (zzhar e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgyn) {
                throw ((zzgyn) e3.getCause());
            }
            throw new zzgyn(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw zzgyn.zzi();
        }
    }

    private void zzi() {
        if (this.zzt == zzhat.zzc()) {
            this.zzt = zzhat.zzf();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgzt.zza().zzb(getClass()).zzk(this, (zzgxy) obj);
    }

    public int hashCode() {
        if (zzcf()) {
            return zzaW();
        }
        if (zzcd()) {
            zzcc(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzgzl.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public int zzaL() {
        return this.zzd & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public int zzaM(zzhae zzhaeVar) {
        if (zzcf()) {
            int iZzc = zzc(zzhaeVar);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException(k31.k(iZzc, "serialized size must be non-negative, was "));
        }
        if (zzaL() != Integer.MAX_VALUE) {
            return zzaL();
        }
        int iZzc2 = zzc(zzhaeVar);
        zzaS(iZzc2);
        return iZzc2;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public zzgzo zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public void zzaS(int i) {
        if (i < 0) {
            throw new IllegalStateException(k31.k(i, "serialized size must be non-negative, was "));
        }
        this.zzd = i | (this.zzd & Integer.MIN_VALUE);
    }

    public int zzaW() {
        return zzgzt.zza().zzb(getClass()).zzb(this);
    }

    public int zzaX() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzgzj
    public int zzaY() {
        return zzaM(null);
    }

    public final <MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> BuilderType zzaZ() {
        return (BuilderType) zzbP(zzgxx.NEW_BUILDER);
    }

    public final zzgzr<MessageType> zzbN() {
        return (zzgzr) zzbP(zzgxx.GET_PARSER);
    }

    public Object zzbO() {
        return zzbP(zzgxx.BUILD_MESSAGE_INFO);
    }

    public Object zzbP(zzgxx zzgxxVar) {
        return zzde(zzgxxVar, null, null);
    }

    public Object zzbQ(zzgxx zzgxxVar, Object obj) {
        return zzde(zzgxxVar, obj, null);
    }

    public void zzbU() {
        this.zzq = 0;
    }

    public void zzbV() {
        zzaS(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public void zzbW() {
        zzgzt.zza().zzb(getClass()).zzf(this);
        zzbX();
    }

    public void zzbX() {
        this.zzd &= ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public void zzbY(int i, zzgwm zzgwmVar) {
        zzi();
        zzhat zzhatVar = this.zzt;
        zzhatVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhatVar.zzj((i << 3) | 2, zzgwmVar);
    }

    public final void zzbZ(zzhat zzhatVar) {
        this.zzt = zzhat.zze(this.zzt, zzhatVar);
    }

    public final <MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> BuilderType zzba(MessageType messagetype) {
        BuilderType buildertype = (BuilderType) zzaZ();
        buildertype.zzbj(messagetype);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzj
    /* JADX INFO: renamed from: zzbb, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcZ() {
        return (BuilderType) zzbP(zzgxx.NEW_BUILDER);
    }

    /* JADX INFO: renamed from: zzbc, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzbM() {
        BuilderType buildertype = (BuilderType) zzbP(zzgxx.NEW_BUILDER);
        buildertype.zzbj(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzk
    /* JADX INFO: renamed from: zzbi, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbt() {
        return (MessageType) zzbP(zzgxx.GET_DEFAULT_INSTANCE);
    }

    public MessageType zzbj() {
        return (MessageType) zzbP(zzgxx.NEW_MUTABLE_INSTANCE);
    }

    @Override // com.google.android.gms.internal.ads.zzgzk
    public final boolean zzbw() {
        return zzce(this, true);
    }

    public void zzca(int i, int i2) {
        zzi();
        zzhat zzhatVar = this.zzt;
        zzhatVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhatVar.zzj(i << 3, Long.valueOf(i2));
    }

    public void zzcc(int i) {
        this.zzq = i;
    }

    public boolean zzcd() {
        return zzaX() == 0;
    }

    public boolean zzcf() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public boolean zzcg(int i, zzgww zzgwwVar) {
        if ((i & 7) == 4) {
            return false;
        }
        zzi();
        return this.zzt.zzm(i, zzgwwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzj
    public void zzda(zzgxd zzgxdVar) {
        zzgzt.zza().zzb(getClass()).zzj(this, zzgxe.zza(zzgxdVar));
    }

    public abstract Object zzde(zzgxx zzgxxVar, Object obj, Object obj2);
}
