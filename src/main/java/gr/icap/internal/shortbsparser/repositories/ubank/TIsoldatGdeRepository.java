package gr.icap.internal.shortbsparser.repositories.ubank;

import gr.icap.internal.shortbsparser.domain.ubank.TIsoldatGde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TIsoldatGdeRepository extends JpaRepository<TIsoldatGde, Long> {
}
