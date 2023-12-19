package StaffManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ArrayList<Staff> staffList = new ArrayList<>();
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        int choice = 1;

        while (choice != 0) {
            System.out.println("1. Tính trung bình lương của nhân viên cả công ty");
            System.out.println("2. Tính trung bình lương của nhân viên fulltime");
            System.out.println("3. Tính trung bình lương của nhân viên parttime");
            System.out.println("4. Tính tổng lương phải trả cho nhân viên parttime");
            System.out.println("5. Đếm số người có mức lương cao hơn mức lương trung bình toàn công ty");
            System.out.println("6. Đếm số nhân viên parttime có tên được nhập vào từ bàn phím");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập vào lựa chọn: ");
            choice = inputInt.nextInt();

            switch (choice) {
                case 1:
                    double trungBinhLuongCongTy = tinhTrungBinhLuongCaCongTy(staffList);
                    System.out.println("Trung bình lương của nhân viên cả công ty: " + trungBinhLuongCongTy);
                    break;
                case 2:
                    double trungBinhLuongFulltime = tinhTrungBinhLuongFulltime(staffList);
                    System.out.println("Trung bình lương của nhân viên fulltime: " + trungBinhLuongFulltime);
                    break;
                case 3:
                    double trungBinhLuongParttime = tinhTrungBinhLuongParttime(staffList);
                    System.out.println("Trung bình lương của nhân viên parttime: " + trungBinhLuongParttime);
                    break;
                case 4:
                    double tongLuongParttime = tinhTongLuongParttime(staffList);
                    System.out.println("Tổng lương phải trả cho nhân viên parttime: " + tongLuongParttime);
                    break;
                case 5:
                    int soNguoiLuongCaoHonTB = demSoNguoiLuongCaoHonTrungBinh(staffList);
                    System.out.println("Số người có mức lương cao hơn mức lương trung bình toàn công ty: " + soNguoiLuongCaoHonTB);
                    break;
                case 6:
                    System.out.print("Nhập tên nhân viên parttime: ");
                    String tenNhanVienPartime = inputString.nextLine();
                    int soNhanVienTheoTen = demSoNhanVienParttimeTheoTen(staffList, tenNhanVienPartime);
                    System.out.println("Số nhân viên parttime có tên " + tenNhanVienPartime + " là: " + soNhanVienTheoTen);
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    public static double tinhTrungBinhLuongCaCongTy(ArrayList<Staff> staffList) {
        double tongLuong = 0;
        for (Staff staff : staffList) {
            if (staff instanceof FullTime) {
                tongLuong += ((FullTime) staff).total();
            } else if (staff instanceof PartTime) {
                tongLuong += ((PartTime) staff).total();
            }
        }
        return staffList.isEmpty() ? 0 : tongLuong / staffList.size();
    }

    public static double tinhTrungBinhLuongFulltime(ArrayList<Staff> staffList) {
        double tongLuongFulltime = 0;
        int soNhanVienFulltime = 0;
        for (Staff staff : staffList) {
            if (staff instanceof FullTime) {
                tongLuongFulltime += ((FullTime) staff).total();
                soNhanVienFulltime++;
            }
        }
        return soNhanVienFulltime == 0 ? 0 : tongLuongFulltime / soNhanVienFulltime;
    }

    public static double tinhTrungBinhLuongParttime(ArrayList<Staff> staffList) {
        double tongLuongParttime = 0;
        int soNhanVienParttime = 0;
        for (Staff staff : staffList) {
            if (staff instanceof PartTime) {
                tongLuongParttime += ((PartTime) staff).total();
                soNhanVienParttime++;
            }
        }
        return soNhanVienParttime == 0 ? 0 : tongLuongParttime / soNhanVienParttime;
}

    public static double tinhTongLuongParttime(ArrayList<Staff> staffList) {
        double tongLuongParttime = 0;
        for (Staff staff : staffList) {
            if (staff instanceof PartTime) {
                tongLuongParttime += ((PartTime) staff).total();
            }
        }
        return tongLuongParttime;
    }

    public static int demSoNguoiLuongCaoHonTrungBinh(ArrayList<Staff> staffList) {
        double trungBinhLuongCongTy = tinhTrungBinhLuongCaCongTy(staffList);
        int count = 0;
        for (Staff staff : staffList) {
            if (staff instanceof FullTime && ((FullTime) staff).total() > trungBinhLuongCongTy) {
                count++;
            }
        }
        return count;
    }

    public static int demSoNhanVienParttimeTheoTen(ArrayList<Staff> staffList, String tenNhanVien) {
        int count = 0;
        for (Staff staff : staffList) {
            if (staff instanceof PartTime && staff.getName().equalsIgnoreCase(tenNhanVien)) {
                count++;
            }
        }
        return count;
    }
}
