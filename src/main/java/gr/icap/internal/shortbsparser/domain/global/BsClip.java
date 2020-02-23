package gr.icap.internal.shortbsparser.domain.global;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "GLOBALDB.BSCLIP")
public class BsClip {

    @Id
    @Column(name = "ROWID")
    private Long rowId;

    @Column(name = "ENTCDE")
    private Long entityCode;

    @Column(name = "EVNCDE")
    private Integer evnCode;

    @Column(name = "UPLFIL")
    private String fileName;

    @Column(name = "XRHSHDATE")
    private LocalDate xrhshDate;
}
