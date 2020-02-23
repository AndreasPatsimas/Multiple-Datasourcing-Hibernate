package gr.icap.internal.shortbsparser.repositories.ubank;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

@Repository
public class TProfileGrpsRepositoryImpl implements TProfileGrpsRepository {

    @PersistenceContext(unitName = "ubankEntityManager")
    private EntityManager em;

    @Override
    public BigDecimal findPrPrId(Long grpCode) {

        Query query = em.createNativeQuery(queryForPrPrId(grpCode));

        return (BigDecimal)query.getSingleResult();
    }

    private String queryForPrPrId(Long grpCode){

        return "SELECT G.PR_PR_ID FROM T_PROFILE_GRPS G INNER JOIN T_PROFILES P ON G.PR_PR_ID=P.PR_ID AND P.PRMODEL='E' " +
                "AND P.STATUSFLAG=0WHERE G.GRPCODE=" + grpCode + " AND G.STATUSFLAG=0 AND G.PR_PR_ID>=20";
    }
}
