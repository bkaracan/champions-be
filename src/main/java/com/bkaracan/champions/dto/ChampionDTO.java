package com.bkaracan.champions.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(
        name = "Champion",
        description = "Champion verisini tutmak için ilgili şema"
)
public class ChampionDTO implements Serializable {

    @Schema(
            description = "Şampiyon id'si"
    )
    private Long id;

    @Schema(
            description = "Şampiyon adı"
    )
    private String name;

    @Schema(
            description = "Şampiyon unvanı"
    )
    private String title;

    @Schema(
            description = "Şampiyon tanıtımı"
    )
    private String description;

    @Schema(
            description = "Şampiyonun üyesi olduğu rol id'si/id'leri"
    )
    private List<Long> roleIds;

    @Schema(
            description = "Şampiyona ait yeteneklerin listesi"
    )
    private List<SkillDTO> skills;

}
