package TRaMis8khae.starbucks.voucher.infrastructure;

import TRaMis8khae.starbucks.voucher.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

}