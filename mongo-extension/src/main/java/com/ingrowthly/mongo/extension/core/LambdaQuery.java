package com.ingrowthly.mongo.extension.core;

import com.ingrowthly.mongo.extension.util.LambdaUtil;
import java.util.Collection;
import lombok.NonNull;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @since 2022/11/24
 */
public class LambdaQuery<T> implements QueryFunc<LambdaQuery<T>, Func<T, ?>> {

    private final Query query;

    public LambdaQuery(@NonNull Query query) {
        this.query = query;
    }

    public LambdaQuery() {
        this.query = new Query();
    }

    public Query getQuery() {
        return this.query;
    }

    @Override
    public LambdaQuery<T> isNull(boolean condition, Func<T, ?> column) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).isNull());
        }
        return this;
    }

    @Override
    public LambdaQuery<T> exists(boolean condition, Func<T, ?> column) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).exists(true));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> in(boolean condition, Func<T, ?> column, Collection<?> coll) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).in(coll));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> nin(boolean condition, Func<T, ?> column, Collection<?> coll) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).nin(coll));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> regex(boolean condition, Func<T, ?> column, String regex) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).regex(regex));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> is(boolean condition, Func<T, ?> column, Object value) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).is(value));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> ne(boolean condition, Func<T, ?> column, Object value) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).ne(value));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> gt(boolean condition, Func<T, ?> column, Object value) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).gt(value));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> gte(boolean condition, Func<T, ?> column, Object value) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).gte(value));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> lt(boolean condition, Func<T, ?> column, Object value) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).lt(value));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> lte(boolean condition, Func<T, ?> column, Object value) {
        if (condition) {
            query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).lte(value));
        }
        return this;
    }

    @Override
    public LambdaQuery<T> between(boolean condition, Func<T, ?> column, Object value1, Object value2) {
        if (condition) {
            if (value1 != null && value2 != null) {
                query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).gte(value1).lte(value2));
            } else if (value1 != null) {
                query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).gte(value1));
            } else if (value2 != null) {
                query.addCriteria(Criteria.where(LambdaUtil.toColumn(column)).lte(value2));
            }
        }
        return this;
    }
}
