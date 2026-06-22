package retrofit2;

import defpackage.ep0;
import defpackage.vb1;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    public static final class OptionalConverter<T> implements Converter<vb1, Optional<T>> {
        final Converter<vb1, T> delegate;

        public OptionalConverter(Converter<vb1, T> converter) {
            this.delegate = converter;
        }

        @Override // retrofit2.Converter
        public Optional<T> convert(vb1 vb1Var) {
            return Optional.ofNullable(this.delegate.convert(vb1Var));
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<vb1, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Converter.Factory.getRawType(type) != ep0.k()) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
