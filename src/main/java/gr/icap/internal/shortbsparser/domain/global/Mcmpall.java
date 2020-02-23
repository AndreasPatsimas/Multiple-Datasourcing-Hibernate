package gr.icap.internal.shortbsparser.domain.global;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "GLOBALDB.MCMPALL")
public class Mcmpall {

    @Id
    @Column(name = "CMPCDE")
    private Long companyCode;

    @Column(name = "LNGCDE")
    private Integer languageCode;

    @Column(name = "SCTCDE")
    private Long grpCode;

    @Column(name = "ENTTYP")
    private Integer entityType;
}
