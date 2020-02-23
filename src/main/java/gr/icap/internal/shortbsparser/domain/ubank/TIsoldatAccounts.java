package gr.icap.internal.shortbsparser.domain.ubank;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "UBANK.T_ISOLDAT_ACCOUNTS")
public class TIsoldatAccounts {

    @Id
    @Column(name = "ISDC_ID")
    private Long isdcId;

    @NotNull
    @Column(name = "ISD_ISD_ID")
    private Long isdIsdId;

    @NotNull
    @Column(name = "AC_SECTION")
    private String acSection;

    @Column(name = "ACSM_ACSM_ID")
    private Long acsmAcsmId;

    @Column(name = "AC_AC_ID")
    private Long acAcId;

    @Column(name = "AC_AC_VNO")
    private Long acAcVno;

    @Column(name = "INIT_VALUE")
    private Integer initValue;

    @Column(name = "DEPR_VALUE")
    private Integer deprValue;

    @Column(name = "UNDEPR_VALUE")
    private Integer undeprValue;

    @Column(name = "LBREAK_FLG")
    private String lbreakFlg;

    @Column(name = "AC_GROUP")
    private Integer acGroup;

    @Column(name = "DISP_ORD")
    private Integer dispOrd;

    @NotNull
    @Column(name = "STATUSFLAG")
    private String statusFlag;

    @Column(name = "INSUSER")
    private String insUser;

    @Column(name = "INSDATE")
    private LocalDate insDate;

    @Column(name = "UPDUSER")
    private String updUser;

    @Column(name = "UPDDATE")
    private LocalDate updDate;

    @Column(name = "LDML_DATE")
    private LocalDate ldmlDate;
}
