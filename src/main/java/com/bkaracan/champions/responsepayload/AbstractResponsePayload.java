package com.bkaracan.champions.responsepayload;

import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AbstractResponsePayload {

    public ResponsePayload setResponse() {
        return getDefaultSuccessResponse();
    }

    public <T> ResponsePayload<T> setResponse(T data) {
        return setResponseData(ResponseEnum.OK, data);
    }

    public <T> ResponsePayload<T> setResponse(ResponseEnum responseEnum, T data) {
        return setResponseData(responseEnum, data);
    }

    public ResponsePayload setResponse(ResponseEnum responseEnum, String message) {
        return setResponseData(responseEnum, message);
    }

    public ResponsePayload setResponse(ResponseEnum responseEnum, MessageEnum message) {
        return setResponseData(responseEnum, message.getMessage());
    }

    public <T> ResponsePayload<T> setResponse(ResponseEnum responseEnum, MessageEnum message,
                                              T data) {
        return setResponseData(responseEnum, message.getMessage(), data);
    }

    private ResponsePayload setResponseData(ResponseEnum responseEnum, String message) {
        return new ResponsePayload(responseEnum, message);
    }

    private <T> ResponsePayload<T> setResponseData(ResponseEnum responseEnum, T data) {
        return new ResponsePayload<T>(responseEnum, data);
    }

    private <T> ResponsePayload<T> setResponseData(ResponseEnum responseEnum, String message,
                                                   T data) {
        return new ResponsePayload<T>(responseEnum, message, data);
    }

    private ResponsePayload getDefaultSuccessResponse() {
        return new ResponsePayload(ResponseEnum.OK);
    }

    public <T> ResponsePayload<T> setResponse(ResponseEnum responseEnum, String message, T data,
                                              Boolean showNotification) {
        return new ResponsePayload<T>(responseEnum, message, data, showNotification);
    }

    public ResponsePayload setResponse(ResponseEnum responseEnum, MessageEnum message,
                                       Boolean showNotification) {
        return setResponseData(responseEnum, message.getMessage(), showNotification);
    }

    public ResponsePayload setResponse(ResponseEnum responseEnum, String message,
                                       Boolean showNotification) {
        return setResponseData(responseEnum, message, showNotification);
    }
}
