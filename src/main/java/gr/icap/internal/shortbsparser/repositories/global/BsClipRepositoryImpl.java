package gr.icap.internal.shortbsparser.repositories.global;

import gr.icap.internal.shortbsparser.dto.BsClipDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class BsClipRepositoryImpl implements BsClipRepository {

    @PersistenceContext(unitName = "globalEntityManager")
    private EntityManager em;

    @Override
    public BsClipDto findBsClipByUplFil(String fileName) {

        Query query = em.createQuery(queryForBsClip(fileName));

        return (BsClipDto)query.getSingleResult();
    }

    private String queryForBsClip(String fileName){

        return "SELECT new gr.icap.internal.shortbsparser.dto.BsClipDto(B.entityCode, B.evnCode, M.grpCode, " +
                "CASE WHEN COALESCE(M.grpCode,0) IN (401, 405) THEN 1 WHEN COALESCE(M.grpCode,0) IN (421, 423) THEN 2 ELSE 0 END, " +
                "B.xrhshDate) " +
                "FROM BsClip B\n" +
                "LEFT JOIN Mcmpall M ON M.companyCode=B.entityCode AND M.entityType IN (1, 3) AND M.languageCode=1 \n" +
                "WHERE B.fileName LIKE '" + fileName + "%'";
    }
}
