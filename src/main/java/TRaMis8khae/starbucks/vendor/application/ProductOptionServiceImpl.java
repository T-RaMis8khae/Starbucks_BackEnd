package TRaMis8khae.starbucks.vendor.application;


import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.vendor.dto.in.ProductOptionRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ProductOptionResponseDto;
import TRaMis8khae.starbucks.vendor.dto.in.VolumeRequestDto;
import TRaMis8khae.starbucks.vendor.entity.Color;
import TRaMis8khae.starbucks.vendor.entity.ProductOption;
import TRaMis8khae.starbucks.vendor.entity.Volume;
import TRaMis8khae.starbucks.vendor.infrastructure.ColorRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductOptionRepository;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductOptionRepositoryCustom;
import TRaMis8khae.starbucks.vendor.infrastructure.VolumeRepository;
import TRaMis8khae.starbucks.vendor.vo.in.ColorRequestVo;
import TRaMis8khae.starbucks.vendor.vo.in.VolumeRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static TRaMis8khae.starbucks.vendor.dto.in.ColorRequestDto.toDto;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductOptionServiceImpl implements ProductOptionService{

	private final ProductRepository productRepository;
	private final VolumeRepository volumeRepository;
	private final ColorRepository colorRepository;
	private final ProductOptionRepository productOptionRepository;
	private final ProductOptionRepositoryCustom productOptionRepositoryCustom;

	@Override
	@Transactional
	public void addProductOption(ProductOptionRequestDto requestDto) {

		if (!productRepository.existsByProductUUID(requestDto.getProductUUID())) {
			throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
		}
		Volume volume = null;
		if (!requestDto.getVolumeName().isEmpty()) {
			volume = volumeRepository.findByName(requestDto.getVolumeName())
					.orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
					);
		}
		productOptionRepository.save(requestDto.toEntity(volume, null));
	}

	@Override
	public void updateProductOption(ProductOptionRequestDto requestDto) {

	}

	@Transactional
	@Override
	public void deleteProductOption(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		productOptionRepository.delete(productOption);
	}

	@Override
	public ProductOptionResponseDto findProductOption(String productUUID) {

		ProductOption productOption = productOptionRepository.findByProductUUID(productUUID).orElseThrow(
			() -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT)
		);

		return ProductOptionResponseDto.toDto(productOption);
	}

	@Override
	public List<String> findProductUUIDSByVolume(String volumeName) {

		return productOptionRepositoryCustom.getProductUUIDByVolume(volumeName);
	}

}
