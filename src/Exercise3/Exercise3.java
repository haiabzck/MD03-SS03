package Exercise3;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> danhSachLuong = new ArrayList<>();
        int luaChon;

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
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    nhapLuongNhanVien(scanner, danhSachLuong);
                    break;
                case 2:
                    hienThiThongKe(danhSachLuong);
                    break;
                case 3:
                    tongThuong(danhSachLuong);
                    break;
                case 4:
                    System.out.println("Đã kết thúc chương trình. Tạm biệt!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại (1-4).");
            }
        }
    }

    private static void nhapLuongNhanVien(Scanner scanner, ArrayList<Long> danhSachLuong) {
        System.out.println("\n--- Nhập lương nhân viên (Nhập -1 để dừng) ---");
        while (true) {
            System.out.print("Nhập lương nhân viên: ");
            if (!scanner.hasNextFloat()) {
                System.out.println("Cảnh báo: Lương số phải là một số thực!");
                scanner.next();
                continue;
            }
            long luong = scanner.nextLong();

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

            // Thêm điểm vào danh sách
            danhSachLuong.add(luong);

            // Xếp loại học lực và in ra ngay lập tức
            var xepLoai = "";
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
        }
    }

    // Chức năng 2: Hiển thị thống kê
    private static void hienThiThongKe(ArrayList<Long> danhSachLuong) {
        System.out.println("\n--- KẾT QUẢ THỐNG KÊ ---");
        if (danhSachLuong.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
            return;
        }

        int tongSoNhanVien = danhSachLuong.size();
        long tongLuong = 0;
        long luongCaoNhat = danhSachLuong.get(0);
        long luongThapNhat = danhSachLuong.get(0);

        // Duyệt danh sách để tính toán các chỉ số
        for (long luong : danhSachLuong) {
            tongLuong += luong;
            if (luong > luongCaoNhat) {
                luongCaoNhat = luong;
            }
            if (luong < luongThapNhat) {
                luongThapNhat = luong;
            }
        }

        long luongTrungBinh = tongLuong / tongSoNhanVien;

        // In kết quả ra màn hình console
        System.out.println("Số học viên đã nhập: " + tongSoNhanVien);
        System.out.println("Lương trung bình: "+ luongTrungBinh +" VND");
        System.out.println("Lương cao nhất: " + luongCaoNhat +" VND");
        System.out.println("Lương thấp nhất: " + luongThapNhat +" VND");
        System.out.println("Tổng lương: " + tongLuong +" VND");

    }
    private static void tongThuong(ArrayList<Long> danhSachLuong) {
        long tongThuong = 0;
        for (long luong : danhSachLuong) {

            if (luong < 5000000) {
                tongThuong += (long) (luong * 0.05);
            }
            if (luong >= 5000000 && luong < 15000000) {
                tongThuong += (long) (luong * 0.1);
            }
            if (luong >= 15000000 && luong < 50000000) {
                tongThuong += (long) (luong * 0.15);
            }
            if (luong >= 50000000 && luong < 100000000) {
                tongThuong += (long) (luong * 0.2);
            }
            if ( luong > 100000000) {
                tongThuong += (long) (luong * 0.25);
            }
            tongThuong +=tongThuong;
        }
        System.out.println("Tổng tiền thưởng của nhân viên : " +tongThuong+" VND" );
    }

}
