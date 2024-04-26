package com.fashionflow.controller;

import com.fashionflow.entity.Item;
import com.fashionflow.entity.ItemTag;
import com.fashionflow.repository.ItemRepository;
import com.fashionflow.repository.ItemTagRepository;
import com.fashionflow.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    //service 패키지가 없으므로 임시로 repository 사용
    private final ItemRepository itemRepository;

    private final ItemTagRepository itemTagRepository;

    //상품 리스트 출력
    @GetMapping("/item/{itemId}")
    public String itemDetali(Model model, @PathVariable("itemId") Long itemId){
        /* 원래는 서비스단에서 처리해야 할 코드 */

        Item item = itemRepository.findById(itemId).orElseThrow(() ->
                new EntityNotFoundException("해당 상품이 존재하지 않습니다. id = " + itemId));

        List<ItemTag> itemTagList = itemTagRepository.findByItemId(item.getId()); //조회한 상품의 아이디로 상품 태그 찾기

        model.addAttribute("item", item); //상품 전달
        model.addAttribute("itemTagList", itemTagList); //상품 태그 전달

        return "item/itemDetail";
    }
}
