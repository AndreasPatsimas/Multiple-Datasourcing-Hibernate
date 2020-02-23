package gr.icap.internal.shortbsparser.services;

import gr.icap.internal.shortbsparser.dto.BalanceSheetDto;
import gr.icap.internal.shortbsparser.dto.BsClipDto;
import org.springframework.stereotype.Service;

@Service
public interface TIsoldatService {

    void fillTIsoldat(BalanceSheetDto balanceSheetDto, BsClipDto bsClipDto);
}
