package TRaMis8khae.starbucks.cart.infrastructure;


import TRaMis8khae.starbucks.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
