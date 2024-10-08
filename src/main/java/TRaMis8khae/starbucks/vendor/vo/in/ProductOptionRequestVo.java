package TRaMis8khae.starbucks.vendor.vo.in;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductOptionRequestVo {

	private String productName;

	private Double price;

	private Integer stockQuantity;

	private Integer limitCnt;

	private Boolean soldOutChecked;

	private Boolean closedChecked;

	private Boolean openChecked;

	private String productUUID;

	private String volumeName;

	private String colorName;

}
