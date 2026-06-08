package Exercise3;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luong;
        int tongSoNhanVien = 0;
        int tongLuong = 0;
        int luongCaoNhat = Integer.MIN_VALUE;
        int luongThapNhat = Integer.MAX_VALUE;
        int tongThuong = 0;
        while (true) {
            System.out.println("\n***************MENU NHẬP LƯƠNG***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            // Kiểm tra dữ liệu đầu vào của menu để tránh lỗi crash chương trình
            if (!scanner.hasNextInt()) {
                System.out.println("Cảnh báo: Vui lòng chỉ nhập số từ 1 đến 4!");
                scanner.next(); // Đọc bỏ giá trị sai
                continue;
            }
            byte luaChon = Byte.parseByte(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập lương nhân viên (Nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập lương nhân viên: ");
                        if (!scanner.hasNextFloat()) {
                            System.out.println("Cảnh báo: Lương số phải là một số thực!");
                            scanner.next();
                            continue;
                        }
                        luong = Integer.parseInt(scanner.nextLine());
                        tongSoNhanVien++ ;
                        tongLuong += luong;
                        // Điều kiện thoát
                        if (luong == -1) {
                            System.out.println("Đã dừng nhập lương.");
                            break;
                        }

                        // Kiểm tra khoảng lương hợp lệ
                        if (luong < 0 || luong > 500000000) {
                            System.out.println("Cảnh báo: Điểm phải nằm trong khoảng từ 0 đến 10 (hoặc -1 để dừng).");
                            continue;
                        }

                        if (luongCaoNhat < luong){
                            luongCaoNhat = luong;
                        }
                        if (luongThapNhat > luong){
                            luongThapNhat = luong;
                        }

                        String xepLoai;
                        if (luong < 5000000) {
                            xepLoai = " Thu nhập thấp";
                        } else if (luong < 15000000) {
                            xepLoai = " Thu nhập trung bình";
                        } else if (luong <= 50000000) {
                            xepLoai = " Thu nhập khá";
                        } else {
                            xepLoai = " Thu nhập cao";
                        }
                        System.out.println("-> Phân loại : " + xepLoai);

                        if (luong < 5000000) {
                            tongThuong += (int) (luong * 0.05);
                        }
                        if (luong >= 5000000 && luong < 15000000) {
                            tongThuong += (int) (luong * 0.1);
                        }
                        if (luong >= 15000000 && luong < 50000000) {
                            tongThuong += (int) (luong * 0.15);
                        }
                        if (luong >= 50000000 && luong < 100000000) {
                            tongThuong += (int) (luong * 0.2);
                        }
                        if ( luong > 100000000) {
                            tongThuong += (int) (luong * 0.25);
                        }
                        tongThuong +=tongThuong;
                    }
                    break;
                case 2:
                    if(tongSoNhanVien != 0){
                        int luongTrungBinh = tongLuong / tongSoNhanVien;

                        // In kết quả ra màn hình console
                        System.out.println("Số nhân viên đã nhập: " + tongSoNhanVien);
                        System.out.println("Lương trung bình: "+ luongTrungBinh +" VND");
                        System.out.println("Lương cao nhất: " + luongCaoNhat +" VND");
                        System.out.println("Lương thấp nhất: " + luongThapNhat +" VND");
                        System.out.println("Tổng lương: " + tongLuong +" VND");

                    }else {
                        System.out.println("Chưa có dữ liệu !");
                    }
                    break;
                case 3:
                    System.out.println("Tổng tiền thưởng của nhân viên : " +tongThuong+" VND" );
                    break;
                case 4:
                    System.out.println("Đã kết thúc chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại (1-4).");
                    break;
            }
            if (luaChon == 4){
                break;
            }
        }
    }
}
