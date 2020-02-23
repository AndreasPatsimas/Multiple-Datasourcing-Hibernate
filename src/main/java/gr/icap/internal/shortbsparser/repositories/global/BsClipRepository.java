package gr.icap.internal.shortbsparser.repositories.global;

import gr.icap.internal.shortbsparser.dto.BsClipDto;

public interface BsClipRepository {

    BsClipDto findBsClipByUplFil(String fileName);
}
