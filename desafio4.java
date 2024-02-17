import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface DiscountStrategy {
    double applyDiscount(double total);
}

class TenPercentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.9;
    }
}

class FreeShipping implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        System.out.println("Frete gratis aplicado");
        return total;
    }
}

class ShoppingCart {
    private List<Double> products = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public void addProduct(double price) {
        products.add(price);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Double price : products) {
            total += price;
        }
        return discountStrategy.applyDiscount(total);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DiscountStrategy tenPercentDiscount = new TenPercentDiscount();
        DiscountStrategy freeShipping = new FreeShipping();

        ShoppingCart cart = new ShoppingCart();

        String productName = scanner.nextLine();
        double productPrice = scanner.nextDouble();
        cart.addProduct(productPrice);

        int strategyChoice = scanner.nextInt();
        switch (strategyChoice) {
            case 1:
                cart.setDiscountStrategy(tenPercentDiscount);
                break;
            case 2:
                cart.setDiscountStrategy(freeShipping);
                break;
            default:
                System.out.println("Escolha invalida. Nenhum desconto aplicado.");
        }

        double total = cart.calculateTotal();
        System.out.println("Total da compra: R$" + total);
    }
}
