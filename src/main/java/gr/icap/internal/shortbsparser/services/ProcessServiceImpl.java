package gr.icap.internal.shortbsparser.services;

import gr.icap.internal.shortbsparser.dto.BalanceSheetDto;
import gr.icap.internal.shortbsparser.dto.BsClipDto;
import gr.icap.internal.shortbsparser.repositories.global.BsClipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    BsClipRepository bsClipRepository;

    @Autowired
    TIsoldatService tIsoldatService;

    @Override
    public void process(BalanceSheetDto balanceSheetDto) {

        log.info("Process for: {} begins", balanceSheetDto.getFileName());

        BsClipDto bsClipDto = bsClipRepository.findBsClipByUplFil(balanceSheetDto.getFileName());

        if(!ObjectUtils.isEmpty(bsClipDto)){

            tIsoldatService.fillTIsoldat(balanceSheetDto, bsClipDto);

            log.info("Process for: {} completed", balanceSheetDto.getFileName());
        }
        else
            log.error("Problem with: {}", balanceSheetDto.getFileName());
    }
}
