package gr.icap.internal.shortbsparser.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BsClipDto {

    private Long compicapId;

    private Integer factCd;

    private Long grpCode;

    private Integer isolCateg;

    private LocalDate isolDateTo;
}
