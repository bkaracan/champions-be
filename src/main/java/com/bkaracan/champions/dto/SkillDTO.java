package com.bkaracan.champions.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(
        name = "Skill",
        description = "Skill verisini tutmak için ilgili şema"
)
public class SkillDTO implements Serializable {

    @Schema(
            description = "Yetenek id'si"
    )
    private Long id;

    @Schema(description = "Yetenek tipi")
    private String type;

    @Schema(
            description = "Yetenek adı"
    )
    private String name;

    @Schema(
            description = "Yetenek tanımı"
    )
    private String description;

    @Schema(
            description = "Yetenek aktif/pasif durumu"
    )
    private Boolean isActive;

    @Schema(
            description = "Ait olduğu şampiyon id'si"
    )
    private Long championId;

}
