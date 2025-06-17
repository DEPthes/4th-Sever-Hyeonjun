package shoping.study.spring.MyShopingMall.Controller;

import shoping.study.spring.MyShopingMall.Entity.Book;
import shoping.study.spring.MyShopingMall.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shoping.study.spring.MyShopingMall.service.ItemService;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;
    @RequestMapping(value = "/items/new", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("item", new Book()); // ★ 반드시 필요!
        return "items/createItemForm";
    }
    @RequestMapping(value = "/items/new", method = RequestMethod.POST)
    public String create(Book item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }



    @RequestMapping(value = "/items/{itemId}/edit", method = RequestMethod.GET)
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Book book = (Book) itemService.fineOne(itemId); // Book으로 캐스팅
        model.addAttribute("item", book);
        return "items/updateItemForm";
    }

    // 상품 수정 처리 (POST)
    @RequestMapping(value = "/items/{itemId}/edit", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("item") Book item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

}


