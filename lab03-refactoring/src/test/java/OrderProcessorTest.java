import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.lang.reflect.Field;

public class OrderProcessorTest {

    private Order createOrder(String name, boolean isMember, List<Item> items) throws Exception {
        Customer customer = new Customer();
        Field nameField = Customer.class.getDeclaredField("name");
        Field memberField = Customer.class.getDeclaredField("isMember");
        nameField.setAccessible(true);
        memberField.setAccessible(true);
        nameField.set(customer, name);
        memberField.set(customer, isMember);

        Order order = new Order();
        Field customerField = Order.class.getDeclaredField("customer");
        Field itemsField = Order.class.getDeclaredField("items");
        customerField.setAccessible(true);
        itemsField.setAccessible(true);
        customerField.set(order, customer);
        itemsField.set(order, items);

        return order;
    }

    private Item createItem(String name, double price, int quantity) throws Exception {
        Item item = new Item();
        Field nameField = Item.class.getDeclaredField("name");
        Field priceField = Item.class.getDeclaredField("price");
        Field quantityField = Item.class.getDeclaredField("quantity");
        nameField.setAccessible(true);
        priceField.setAccessible(true);
        quantityField.setAccessible(true);
        nameField.set(item, name);
        priceField.set(item, price);
        quantityField.set(item, quantity);
        return item;
    }

    @Test
    public void testPrintOrderSummaryNonMember() throws Exception {
        Item item = createItem("Book", 10.0, 2);
        Order order = createOrder("Alice", false, List.of(item));
        OrderProcessor processor = new OrderProcessor();
        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }

    @Test
    public void testPrintOrderSummaryMember() throws Exception {
        Item item = createItem("Pen", 5.0, 4);
        Order order = createOrder("Bob", true, List.of(item));
        OrderProcessor processor = new OrderProcessor();
        assertDoesNotThrow(() -> processor.printOrderSummary(order));
    }
}