package com.connor.cloud.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;


@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {


    private String getCurrentUsername() {
        return "sys";
    }


    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("start insertFill fill ....");
        this.strictInsertFill(metaObject, "createdTime", () -> Date.from(ZonedDateTime.now().toInstant()), Date.class);
        this.strictInsertFill(metaObject, "createdBy", () -> getCurrentUsername(), String.class);
        this.strictInsertFill(metaObject, "updatedBy", () -> getCurrentUsername(), String.class);
        this.strictUpdateFill(metaObject, "updatedTime", () -> Date.from(ZonedDateTime.now().toInstant()), Date.class);

    }


    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("start update fill ....");
        this.strictInsertFill(metaObject, "updatedBy", () -> getCurrentUsername(), String.class);
        this.strictUpdateFill(metaObject, "updatedTime", () -> Date.from(ZonedDateTime.now().toInstant()), Date.class);
    }
}
