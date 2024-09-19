package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryListServiceImpl implements ProductCategoryListService{

    private final ProductRepository productRepository;
    private final ProductCategoryListRepository productCategoryListRepository;
    private final ProductCategoryListRepositoryCustom productCategoryListRepositoryCustom;

    @Override
    public void addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto) {

        Product product = productRepository.findByProductUUID(productCategoryListRequestDto.getProductUUID())
            .orElseThrow( () -> new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT));

        productCategoryListRepository.save(productCategoryListRequestDto.toEntity(product));

    }


    @Override
    public List<ProductCategoryListResponseDto> findProductsByCategories(String topCode, String middleCode, String bottomCode) {

        List<ProductCategoryList> productCategoryList = productCategoryListRepositoryCustom.findProductsByCategories(topCode, middleCode, bottomCode);

        return productCategoryList.stream().map(ProductCategoryListResponseDto::toDto).toList();
    }


}