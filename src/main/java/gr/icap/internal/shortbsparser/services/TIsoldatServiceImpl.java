package gr.icap.internal.shortbsparser.services;

import gr.icap.internal.shortbsparser.domain.ubank.TIsoldat;
import gr.icap.internal.shortbsparser.domain.ubank.TIsoldatGde;
import gr.icap.internal.shortbsparser.dto.BalanceSheetDto;
import gr.icap.internal.shortbsparser.dto.BsClipDto;
import gr.icap.internal.shortbsparser.exceptions.ProcessException;
import gr.icap.internal.shortbsparser.repositories.ubank.TIsoldatGdeRepository;
import gr.icap.internal.shortbsparser.repositories.ubank.TIsoldatRepository;
import gr.icap.internal.shortbsparser.repositories.ubank.TProfileGrpsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;

@Service
@Slf4j
public class TIsoldatServiceImpl implements TIsoldatService {

    @Autowired
    TIsoldatRepository tIsoldatRepository;

    @Autowired
    TIsoldatGdeRepository tIsoldatGdeRepository;

    @Autowired
    TProfileGrpsRepository tProfileGrpsRepository;

    @Override
    public void fillTIsoldat(BalanceSheetDto balanceSheetDto, BsClipDto bsClipDto) {

        if(!isThereBalanceSheet(bsClipDto)){

            saveTIsoldat(balanceSheetDto, bsClipDto);
        }
        else
            throw new ProcessException("There is already balance sheet.");

    }

    private boolean isThereBalanceSheet(BsClipDto bsClipDto){

        TIsoldat tIsoldat = tIsoldatRepository.findTIsoldatByBsClip(bsClipDto.getFactCd(), bsClipDto.getCompicapId(),
                bsClipDto.getIsolDateTo().toString());

        if(tIsoldat == null)
            return false;

        return true;
    }

    private void saveTIsoldat(BalanceSheetDto balanceSheetDto, BsClipDto bsClipDto){

        TIsoldatGde tIsoldatGde = TIsoldatGde.builder()
                .compIcapId(bsClipDto.getCompicapId())
                .isolYear(getIsolYear(LocalDate.parse(balanceSheetDto.getTo()).getYear(), LocalDate.parse(balanceSheetDto.getTo())))
                .senergValue(Double.valueOf(balanceSheetDto.getTotalAssets1()))
                .factCd(bsClipDto.getFactCd())
                .prPrId(tProfileGrpsRepository.findPrPrId(bsClipDto.getGrpCode()))
                .isolCateg0(bsClipDto.getIsolCateg().toString())
                .grpCode(bsClipDto.getGrpCode())
                .synoptikosFlg("0")
                .reformFlg("N")
                .isolDateFrom(LocalDate.parse(balanceSheetDto.getFrom()))
                .isolDateTo(LocalDate.parse(balanceSheetDto.getTo()))
                .isolStatus("I")
                .noLocksFlg("N")
                .curCurId(6L)
                .currencyUnit("U")
                .dtpFlg("0")
                .kryfosFlg("0")
                .paratypiesFlg("0")
                .auditFlg("N")
                .isolFlag("0")
                .fYearAA(null)
                .cprCprId(null)
                .pressCd(null)
                .pressDate(null)
                .statusFlag("0")
                .insDate(Instant.now())
                .insUser("OCR")
                .updUser("OCR")
                .updDate(Instant.now())
                .isolRangeFlg("C")
                .runSetFlg("N")
                .migrationFlg("N")
                .transToAS400Flg("Y")
                .convertedToBaseFlg("N")
                .fekCode(null)
                .senergValueFlg("P")
                .isolType("N")
                .notesFlg("N")
                .finNotesFlg("N")
                .refNotesFlg("N")
                .build();

        System.out.println(tIsoldatGde);

        //tIsoldatGdeRepository.save(tIsoldatGde);
    }

    private Integer getIsolYear(Integer year, LocalDate date){

        if(date.isAfter(LocalDate.parse(year + "-06-30")) && date.isBefore(LocalDate.parse(year + "-12-31")))
            return year;

        return year - 1;
    }
}
