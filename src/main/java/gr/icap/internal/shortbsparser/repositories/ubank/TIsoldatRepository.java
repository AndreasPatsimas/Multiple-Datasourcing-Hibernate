package gr.icap.internal.shortbsparser.repositories.ubank;

import gr.icap.internal.shortbsparser.domain.ubank.TIsoldat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TIsoldatRepository extends JpaRepository<TIsoldat, Long> {

    @Query(value = "SELECT * FROM T_ISOLDAT WHERE FACTCD = :factCd AND COMPICAPID = :compicapId AND STATUSFLAG='0' AND " +
            "ISOLDATE_TO = TO_DATE(:isolDateTo, 'yy-mm-dd')",
            nativeQuery = true)
    TIsoldat findTIsoldatByBsClip(@Param("factCd") Integer factCd,
                                  @Param("compicapId") Long compicapId,
                                  @Param("isolDateTo") String isolDateTo);
}
