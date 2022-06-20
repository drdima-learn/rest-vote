package com.rubincomputers.restvote.util;

import com.rubincomputers.restvote.model.AbstractBaseEntity;

public class ValidationUtil {
    public static void checkNew(AbstractBaseEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalArgumentException(entity + " must be new (id=null)");
        }
    }
}
