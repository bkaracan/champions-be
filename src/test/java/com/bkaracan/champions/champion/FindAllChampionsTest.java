package com.bkaracan.champions.champion;

import com.bkaracan.champions.bean.champion.ListChampionBean;
import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.impl.ChampionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindAllChampionsTest {

    @Mock
    private ListChampionBean listChampionBean;

    @InjectMocks
    private ChampionServiceImpl championService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenFindAllChampionsCalled_thenReturnChampionDTOList() {

        ChampionDTO championDTO1 = ChampionDTO.builder()
                .id(1L)
                .name("Champion1")
                .title("The First")
                .description("This is the first champion.")
                .roleIds(Arrays.asList(1L, 2L))
                .build();

        ChampionDTO championDTO2 = ChampionDTO.builder()
                .id(2L)
                .name("Champion2")
                .title("The Second")
                .description("This is the second champion.")
                .roleIds(Arrays.asList(3L, 4L))
                .build();


        List<ChampionDTO> championDTOs = Arrays.asList(championDTO1, championDTO2);
        ResponsePayload<List<ChampionDTO>> expectedResponse = new ResponsePayload<>(ResponseEnum.OK, MessageEnum.FETCH_SUCCESS.getMessage(), championDTOs);

        when(listChampionBean.getAllChampions()).thenReturn(expectedResponse);

        ResponsePayload<List<ChampionDTO>> actualResponse = championService.findAllChampions();

        assertEquals(expectedResponse.getCode(), actualResponse.getCode(), "Codes don't match!");
        assertEquals(expectedResponse.getMessage(), actualResponse.getMessage(), "Messages don't match!");
        assertEquals(expectedResponse.getIsSuccess(), actualResponse.getIsSuccess(), "Success responses don't match!");
        assertEquals(expectedResponse.getData(), actualResponse.getData(), "Data don't match!");
        assertEquals(expectedResponse.getResponseEnum(), actualResponse.getResponseEnum(), "Response enums don't match!");

        verify(listChampionBean, times(1)).getAllChampions();
    }
}
