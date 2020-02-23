package gr.icap.internal.shortbsparser.repositories.ubank;


import java.math.BigDecimal;

public interface TProfileGrpsRepository {

    BigDecimal findPrPrId(Long grpCode);
}
