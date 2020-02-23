package gr.icap.internal.shortbsparser.domain.ubank;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@IdClass(TIsoldatGdeId.class)
@Table(name = "UBANK.T_ISOLDAT_GDE")
public class TIsoldatGde {

    @Id
    @Column(name = "COMPICAPID")
    private Long compIcapId;

    @Id
    @Column(name = "ISOLDATE_TO")
    private LocalDate isolDateTo;

    @NotNull
    @Column(name = "ISOLYEAR")
    private Integer isolYear;

    @Column(name = "SENERG_VALUE")
    private Double senergValue;

    @NotNull
    @Column(name = "FACTCD")
    private Integer factCd;

    @NotNull
    @Column(name = "PR_PR_ID")
    private BigDecimal prPrId;

    @NotNull
    @Column(name = "ISOLCATEG0")
    private String isolCateg0;

    @Column(name = "GRPCODE")
    private Long grpCode;

    @NotNull
    @Column(name = "SYNOPTIKOS_FLG")
    private String synoptikosFlg;

    @NotNull
    @Column(name = "REFORM_FLG")
    private String reformFlg;

    @NotNull
    @Column(name = "ISOLDATE_FROM")
    private LocalDate isolDateFrom;

    @NotNull
    @Column(name = "ISOLSTATUS")
    private String isolStatus;

    @NotNull
    @Column(name = "NOLOCKS_FLG")
    private String noLocksFlg;

    @Column(name = "CUR_CUR_ID")
    private Long curCurId;

    @NotNull
    @Column(name = "CURRENCY_UNIT")
    private String currencyUnit;

    @NotNull
    @Column(name = "DTP_FLG")
    private String dtpFlg;

    @NotNull
    @Column(name = "KRYFOS_FLG")
    private String kryfosFlg;

    @NotNull
    @Column(name = "PARATYPIES_FLG")
    private String paratypiesFlg;

    @NotNull
    @Column(name = "AUDIT_FLG")
    private String auditFlg;

    @Column(name = "ISOL_FLAG")
    private String isolFlag;

    @Column(name = "FYEAR_AA")
    private Integer fYearAA;

    @Column(name = "CPR_CPR_ID")
    private Long cprCprId;

    @Column(name = "PRESSCD")
    private Integer pressCd;

    @Column(name = "PRESSDATE")
    private LocalDate pressDate;

    @NotNull
    @Column(name = "STATUSFLAG")
    private String statusFlag;

    @Column(name = "INSDATE")
    private Instant insDate;

    @Column(name = "INSUSER")
    private String insUser;

    @Column(name = "UPDUSER")
    private String updUser;

    @Column(name = "UPDDATE")
    private Instant updDate;

    @NotNull
    @Column(name = "ISOLRANGE_FLG")
    private String isolRangeFlg;

    @NotNull
    @Column(name = "RUNSET_FLG")
    private String runSetFlg;

    @Column(name = "MIGRATION_FLG")
    private String migrationFlg;

    @NotNull
    @Column(name = "TRANS_TO_AS400_FLG")
    private String transToAS400Flg;

    @NotNull
    @Column(name = "CONVERTED_TO_BASE_FLG")
    private String convertedToBaseFlg;

    @Column(name = "FEKCODE")
    private String fekCode;

    @NotNull
    @Column(name = "SENERG_VALUE_FLG")
    private String senergValueFlg;

    @NotNull
    @Column(name = "ISOLTYPE")
    private String isolType;

    @NotNull
    @Column(name = "NOTES_FLG")
    private String notesFlg;

    @NotNull
    @Column(name = "FINNOTES_FLG")
    private String finNotesFlg;

    @NotNull
    @Column(name = "REFNOTES_FLG")
    private String refNotesFlg;
}
