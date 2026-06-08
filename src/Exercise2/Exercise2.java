package Exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        float diem;
        int tongSoHocVien = 0;
        float tongDiem = 0;
        float diemCaoNhat = Integer.MIN_VALUE;
        float diemThapNhat = Integer.MAX_VALUE;
        while (true) {
            System.out.println("\n***************MENU NHẬP ĐIỂM***************");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            // Kiểm tra dữ liệu đầu vào của menu để tránh lỗi crash chương trình
            if (!scanner.hasNextInt()) {
                System.out.println("Cảnh báo: Vui lòng chỉ nhập số từ 1 đến 3!");
                scanner.next(); // Đọc bỏ giá trị sai
                continue;
            }
            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- BẮT ĐẦU NHẬP ĐIỂM (Nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập điểm học viên: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Cảnh báo: Điểm số phải là một số thực!");
                            scanner.next();
                            continue;
                        }
                         diem = Float.parseFloat(scanner.nextLine());
                        tongSoHocVien++;
                        tongDiem +=diem;
                        // Điều kiện thoát
                        if (diem == -1) {
                            System.out.println("Đã dừng nhập điểm.");
                            break;
                        }

                        // Kiểm tra khoảng điểm hợp lệ
                        if (diem < 0 || diem > 10) {
                            System.out.println("Cảnh báo: Điểm phải nằm trong khoảng từ 0 đến 10 (hoặc -1 để dừng).");
                            continue;
                        }
                        if (diem > diemCaoNhat) {
                            diemCaoNhat = diem;
                        }
                        if (diem < diemThapNhat) {
                            diemThapNhat = diem;
                        }
                        String xepLoai = "";
                        if (diem >= 0 && diem < 5) {
                            xepLoai = "Yếu";
                        } else if (diem >= 5 && diem < 7) {
                            xepLoai = "Trung Bình";
                        } else if (diem >= 7 && diem < 8) {
                            xepLoai = "Khá";
                        } else if (diem >= 8 && diem < 9) {
                            xepLoai = "Giỏi";
                        } else if (diem >= 9) {
                            xepLoai = "Xuất sắc";
                        }
                        System.out.println("-> Xếp loại học lực: " + xepLoai);

                    }
                    break;
                case 2:
                    System.out.println("\n--- KẾT QUẢ THỐNG KÊ ---");
                    if (tongSoHocVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    }else {
                        double diemTrungBinh = tongDiem / tongSoHocVien;

                        // In kết quả ra màn hình console
                        System.out.println("Số học viên đã nhập: " + tongSoHocVien);
                        System.out.printf("Điểm trung bình: %.2f\n", diemTrungBinh);
                        System.out.println("Điểm cao nhất: " + diemCaoNhat);
                        System.out.println("Điểm thấp nhất: " + diemThapNhat);
                    }
                    break;
                case 3:
                    System.out.println("Đã kết thúc chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại (1-3).");
                    break;
            }
            if (luaChon == 3){
                break;
            }
        }
    }
}
