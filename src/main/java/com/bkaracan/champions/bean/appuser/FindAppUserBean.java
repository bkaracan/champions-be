package com.bkaracan.champions.bean.appuser;

import com.bkaracan.champions.dto.AppUserDTO;
import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.AppUserDtoMapper;
import com.bkaracan.champions.repository.AppUserRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindAppUserBean extends AbstractResponsePayload {

    private final AppUserRepository appUserRepository;
    private final AppUserDtoMapper appUserDtoMapper;

    public ResponsePayload<AppUserDTO> findByUsername(String username) {
        Optional<AppUser> appUserOptional = appUserRepository.findByUsername(username);
        if(appUserOptional.isPresent()) {
            return setResponse(appUserDtoMapper.map(appUserOptional.get()));
        }
        return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.USER_NOT_FOUND.getMessage());
    }
}
