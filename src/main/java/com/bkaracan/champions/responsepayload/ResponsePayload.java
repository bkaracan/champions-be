package com.bkaracan.champions.responsepayload;

import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponsePayload<T> {

    private Integer code;
    private String message;
    private Boolean isSuccess;
    private ResponseEnum responseEnum;
    private Boolean showNotification = false;
    private T data;

    public ResponsePayload(ResponseEnum responseEnum) {
        super();
        this.responseEnum = responseEnum;
        this.code = responseEnum.getHttpStatusCode();
        this.message = responseEnum.getDescription();
        this.isSuccess = responseEnum.getIsSuccess();
    }

    public ResponsePayload(Integer code, String message, Boolean isSuccess, T data) {
        this(code, message, isSuccess);
        this.data = data;
    }

    public ResponsePayload(ResponseEnum responseEnum, String message) {
        this(responseEnum);
        if (responseEnum.equals(ResponseEnum.BAD_REQUEST) || responseEnum.equals(ResponseEnum.FORBIDDEN)
                || responseEnum.equals(ResponseEnum.NOT_FOUND) || responseEnum.equals(
                ResponseEnum.UNAUTHORIZED) || responseEnum.equals(ResponseEnum.ERROR)) {
            this.isSuccess = false;
            this.showNotification = true;
        }
        this.message = message;
    }

    public ResponsePayload(ResponseEnum responseEnum, String message, T data) {
        this(responseEnum);
        this.message = message;
        this.data = data;
    }

    public ResponsePayload(ResponseEnum responseEnum, String message, T data,
                           Boolean showNotification) {
        this(responseEnum);
        this.message = message;
        this.data = data;
        this.showNotification = showNotification;
    }

    public ResponsePayload(Integer code, String message, Boolean success) {
        this(code, success);
        this.message = message;
    }

    public ResponsePayload(Integer code, Boolean success) {
        this(success);
        this.code = code;
    }

    public ResponsePayload(Boolean isSuccess) {
        super();
        this.isSuccess = isSuccess;
    }

    public ResponsePayload(ResponseEnum responseEnum, T data) {
        this(responseEnum);
        this.data = data;
    }

    public ResponsePayload(ResponseEnum responseEnum, T data, Boolean showNotification) {
        this(responseEnum);
        this.data = data;
        this.showNotification = showNotification;
    }

    public ResponsePayload(ResponseEnum responseEnum, String message, Boolean isSuccess, T data) {
        this(responseEnum);
        this.message = message;
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public ResponsePayload(ResponseEnum responseEnum, String message, Boolean isSuccess, T data,
                           Boolean showNotification) {
        this(responseEnum);
        this.message = message;
        this.isSuccess = isSuccess;
        this.data = data;
        this.showNotification = showNotification;
    }

    public ResponsePayload(MessageEnum messageEnum, Boolean isSuccess) {
        this.code = messageEnum.getCode();
        this.message = messageEnum.getMessage();
        this.isSuccess = isSuccess;
    }
}
