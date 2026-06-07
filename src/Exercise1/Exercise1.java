package Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        String fullname;
        String productname;
        int price;
        int stock;
        boolean card;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Tên khách hàng : ");
        fullname = scanner.nextLine();
        System.out.print("Tên sản phẩm : ");
        productname = scanner.nextLine();
        System.out.print("Giá : ");
        price = scanner.nextInt();
        System.out.print("Số lượng : ");
        stock = scanner.nextInt();
        System.out.print("Khách có thẻ thành viên ? (true/false) : ");
        card = scanner.nextBoolean();

        int total = price * stock;
        double sale;
        if (card){
            sale = total * 0.1;
        }else {
            sale = 0;
        }
        double VAT = total * 0.08;
        double alltotal =   total - sale + VAT;

        System.out.println("Khách hàng : " + fullname);
        System.out.println("Sản phẩm : "+ productname );
        System.out.println("Giá : "+ price + " VND" );
        System.out.println("Số lượng : "+ stock );
        System.out.println("Thành tiền : "+ total + " VND" );
        System.out.println("Giảm giá : "+ sale + " VND"  );
        System.out.println("Thuế VAT (8%) : "+ VAT + " VND" );
        System.out.println("Tổng thanh toán : "+ alltotal + " VND" );
    }
}
