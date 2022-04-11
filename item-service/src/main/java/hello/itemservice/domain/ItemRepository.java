package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item newItem) {
        newItem.setId(++sequence);
        store.put(newItem.getId(), newItem);
        return newItem;
    }

    public Item findById(Long id) {
        return this.store.get(id); // 예외처리를 해주는게 맞지만 mvc 패턴 공부용이므로 생략하겠다.
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
        sequence = 0L;
    }
}
