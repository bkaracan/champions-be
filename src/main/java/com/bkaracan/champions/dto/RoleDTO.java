package com.bkaracan.champions.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Schema(
        name = "Role",
        description = "Role verisini tutmak için ilgili şema"
)
public class RoleDTO implements Serializable {

    @Schema(
            description = "Role id'si"
    )
    private Long id;

    @Schema(
            description = "Role adı"
    )
    private String name;

}
