package enigma.travelwise.service.impl;

import enigma.travelwise.model.Accommodation;
import enigma.travelwise.model.OrderAccommodation;
import enigma.travelwise.model.OrderAccommodationDetail;
import enigma.travelwise.repository.OrderAccommodationDetailRepository;
import enigma.travelwise.service.AccommodationService;
import enigma.travelwise.service.OrderAccommodationDetailService;
import enigma.travelwise.utils.dto.OrderAccommodationDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderAccommodationDetailServiceImpl implements OrderAccommodationDetailService {
    private final OrderAccommodationDetailRepository orderAccommodationDetailRepository;
    private final AccommodationService accommodationService;

    @Override
    public OrderAccommodationDetail create(OrderAccommodationDetailDTO request) {
        OrderAccommodationDetail newOrder = new OrderAccommodationDetail();
        Accommodation accommodation = accommodationService.getById(request.getAccommodationId());
        OrderAccommodation orderAccommodation = request.getOrderAccommodation();

        newOrder.setPrice(accommodation.getCategory_prices().get(request.getCategory()));
        newOrder.setQuantity(request.getQuantity());
        newOrder.setAccommodation(accommodation);
        newOrder.setOrderAccommodation(orderAccommodation);
        newOrder.setCategoryRoom(request.getCategory());

        return orderAccommodationDetailRepository.save(newOrder);
    }

    @Override
    public Page<OrderAccommodationDetail> getAll(Pageable pageable) {
        return orderAccommodationDetailRepository.findAll(pageable);
    }

    @Override
    public OrderAccommodationDetail getOne(Long id) {
        return null;
    }
}
