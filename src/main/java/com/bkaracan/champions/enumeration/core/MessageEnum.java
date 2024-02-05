package com.bkaracan.champions.enumeration.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageEnum {

    NOT_FOUND(1, "The record is not found!"),
    UNEXPECTED_ERROR(2, "Unexpected error!"),
    FETCH_SUCCESS(3, "Record is found successfully!"),
    SAVE_SUCCESS(4, "Record is saved successfully!"),
    UPDATE_SUCCESS(5, "Record is updated successfully!"),
    DELETE_SUCCESS(6, "Record is deleted successfully!"),
    RECORD_EXISTS(7, "Record is already exists!"),
    EMPTY_LIST(8, "The list is empty!");

    private final Integer code;
    private final String message;
}
