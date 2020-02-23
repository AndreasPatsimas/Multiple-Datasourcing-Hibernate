package gr.icap.internal.shortbsparser.domain.ubank;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode
public class TIsoldatGdeId implements Serializable {

    private Long compIcapId;

    private LocalDate isolDateTo;
}
