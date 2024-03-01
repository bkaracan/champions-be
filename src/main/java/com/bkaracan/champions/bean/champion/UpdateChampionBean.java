package com.bkaracan.champions.bean.champion;

import com.bkaracan.champions.bean.role.FindRoleBean;
import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.entity.Champion;
import com.bkaracan.champions.entity.Role;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.ChampionDtoMapper;
import com.bkaracan.champions.mapper.RoleDtoMapper;
import com.bkaracan.champions.repository.ChampionRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateChampionBean extends AbstractResponsePayload {

    private final ChampionRepository championRepository;
    private final ChampionDtoMapper championDtoMapper;
    private final RoleDtoMapper roleDtoMapper;
    private final FindChampionBean findChampionBean;
    private final FindRoleBean findRoleBean;

    @Transactional
    public ResponsePayload<ChampionDTO> updateChampion(ChampionDTO championDTO) {

        // ChampionDTO'yu alıp, mevcut Champion'ı bul
        ResponsePayload<ChampionDTO> championDTOResponsePayload = findChampionBean.findById(championDTO.getId());

        if (Boolean.TRUE.equals(championDTOResponsePayload.getIsSuccess())) {

            // ChampionDTO'dan Champion entity'sine dönüştür
            Champion champion = championDtoMapper.convertToEntity(championDTO);

            // Role ID'lerini kullanarak Role nesnelerini bul ve güncelle
            List<Role> roles = championDTO.getRoleIds().stream()
                    .map(findRoleBean::findById)
                    .filter(ResponsePayload::getIsSuccess)
                    .map(responsePayload -> roleDtoMapper.convertToEntity(responsePayload.getData()))
                    .collect(Collectors.toList());

            champion.setRoles(roles);

            // Champion nesnesini güncelle
            Champion updatedChampion = championRepository.save(champion);

            // Güncellenmiş Champion'ı DTO'ya dönüştür ve yanıtı dön
            ChampionDTO updatedChampionDTO = championDtoMapper.map(updatedChampion);
            return setResponse(ResponseEnum.OK, MessageEnum.UPDATE_SUCCESS, updatedChampionDTO);
        }
        return setResponse(ResponseEnum.ERROR, MessageEnum.NOT_FOUND.getMessage());
    }


}
