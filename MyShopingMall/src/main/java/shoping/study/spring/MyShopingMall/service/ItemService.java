package shoping.study.spring.MyShopingMall.service;

import shoping.study.spring.MyShopingMall.Entity.Item;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoping.study.spring.MyShopingMall.repository.ItemRepository;

import java.util.List;

@Service
@Transactional
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
    public Item fineOne(Long itemId) {
        return itemRepository.fineOne(itemId);
    }
}
