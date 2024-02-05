package com.bkaracan.champions.enumeration.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

    OK(200, "OK", Boolean.TRUE),
    BAD_REQUEST(400, "BAD REQUEST", Boolean.FALSE),
    UNAUTHORIZED(401, "UNAUTHORIZED", Boolean.FALSE),
    FORBIDDEN(403, "FORBIDDEN", Boolean.FALSE),
    NOT_FOUND(404, "NOT FOUND", Boolean.FALSE),
    ERROR(1000, "ERROR", Boolean.FALSE),
    NOTIFICATION(1001, "NOTIFICATION", Boolean.FALSE),
    INFO(1002, "INFO", Boolean.TRUE),
    WARNING(100, "WARNING", Boolean.TRUE);

    private final Integer httpStatusCode;
    private final String description;
    private final Boolean isSuccess;
}
