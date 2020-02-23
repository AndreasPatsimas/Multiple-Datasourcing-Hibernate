package gr.icap.internal.shortbsparser.services;

import gr.icap.internal.shortbsparser.dto.BalanceSheetDto;
import org.springframework.stereotype.Service;

@Service
public interface ProcessService {

    void process(BalanceSheetDto balanceSheetDto);
}
