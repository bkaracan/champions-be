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
    EMPTY_LIST(8, "The list is empty!"),
    ID_REQUIRED(9, "The id is required!"),
    ID_MUST_BE_NULL(10, "The id must be null!"),
    ROLE_NOT_FOUND(11, "The role not found!"),
    CHAMPION_NOT_FOUND(12, "The champion not found!"),
    SKILL_NOT_FOUND(13, "The skill not found!"),
    USER_NOT_FOUND(14, "The user not found!");

    private final Integer code;
    private final String message;
}
