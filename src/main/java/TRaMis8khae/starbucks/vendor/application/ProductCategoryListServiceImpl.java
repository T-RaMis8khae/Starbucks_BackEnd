package TRaMis8khae.starbucks.vendor.application;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import TRaMis8khae.starbucks.common.utils.CursorPage;
import TRaMis8khae.starbucks.product.entity.Product;
import TRaMis8khae.starbucks.product.infrastructure.ProductRepository;
import TRaMis8khae.starbucks.vendor.dto.in.ProductCategoryListRequestDto;
import TRaMis8khae.starbucks.vendor.dto.out.ProductCategoryListResponseDto;
import TRaMis8khae.starbucks.vendor.entity.ProductCategoryList;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepository;
import TRaMis8khae.starbucks.vendor.infrastructure.ProductCategoryListRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryListServiceImpl implements ProductCategoryListService{

    private final ProductRepository productRepository;
    private final ProductCategoryListRepository productCategoryListRepository;
    private final ProductCategoryListRepositoryCustom productCategoryListRepositoryCustom;

    @Override
    @Transactional
    public ProductCategoryList addProductByCategory(ProductCategoryListRequestDto productCategoryListRequestDto) {

        if (!productRepository.existsByProductUUID((productCategoryListRequestDto.getProductUUID()))) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_PRODUCT);
        }

        return productCategoryListRepository.save(productCategoryListRequestDto.toEntity());

    }


    @Override
    public List<ProductCategoryListResponseDto> findProductsByCategories(String topCode, String middleCode, String bottomCode) {
        return null;
    }

    @Override
    public CursorPage<String> getProductCategoryListByCategories(
        String topCategoryCode,
        String middleCategoryCode,
        String bottomCategoryCode,
        Long lastId,
        Integer pageSize,
        Integer page
    ) {
        return productCategoryListRepositoryCustom.getProductCategoryListByCategories(
            topCategoryCode,
            middleCategoryCode,
            bottomCategoryCode,
            lastId,
            pageSize,
            page
        );
    }

}