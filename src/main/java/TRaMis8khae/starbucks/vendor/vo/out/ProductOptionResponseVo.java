package TRaMis8khae.starbucks.vendor.vo.out;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ProductOptionResponseVo {

	private String productName;

	private Double price;

	private Integer stockQuantity;

	private Integer limitCnt;

	private Boolean soldOutChecked;

	private Boolean closedChecked;

	private Boolean openChecked;



}
