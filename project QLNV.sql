Create database QLNVKH;

go 

use QLNVKH;

-- Tạo bảng phòng ban

Create table PhongBan(
MaPhong varchar(10) primary key,
TenPhong nvarchar(100),
Email varchar(100),
DienThoai varchar(20),
MaTruongPhong int
);

-- Tạo bảng nhân viên
Create table NhanVien(
MaNV int identity (1,1) primary key,
HoTen nvarchar (100),
Email varchar (100), 
DienThoai varchar(20),
DiaChi nvarchar(200),
NgaySinh date,
TrinhDo nvarchar(100),
GioiTinh tinyint,
NgayVaoCongTy date,
MaPhong varchar(10),
MaChucVu varchar (10),
MaQuyen varchar(10),
MatKhau varchar(32)
);

-- Sửa kiểu dữ liêu

Alter table NhanVien
alter column MaChucVu int;

-- Thêm cột vào bảng nhân viên
Alter table NhanVien
add LoaiGTCN int;

Alter table NhanVien
add NoiCapGTCN nvarchar(100);

Alter table NhanVien
add NgayCapGTCN date;

-- Thiết lập Email không trùng lặp
Alter table NhanVien
add constraint UNI_NhanVien_Email UNIQUE (Email);

Create unique nonclustered index UNI_NhanVien_Email  on dbo.NhanVien(Email) where Email is not null;

-- Tạo bảng GiayToCaNhan

Create table GiayToCaNhan(
LoaiGT int identity (1,1) primary key,
TenGT nvarchar(100)
);
--Tạo bảng chức vụ

Create table ChucVu(
MaCV varchar(10) primary key,
TenChucVu nvarchar (100),
);

alter table ChucVu
alter column MaCV int;

-- Thêm cột ngày bắt đầu
Alter table ChucVu
add NgayBatDau date;
-- tạo bảng khách hàng

Create table KhachHang(
MaKH varchar (10) primary key,
TenKhachHang nvarchar(300),
DienThoai varchar(20),
Email varchar(100),
MaSoThue varchar(20),
DiaChi nvarchar(200),
LoaiKH int
);


-- Tạo bảng Vụ việc 

Create table VuViec(
MaVuViec varchar (10) primary key,
TenVuViec nvarchar (200), 
LoaiViecId int,
MoTa nvarchar(max)
);


-- Tạo bảng Khách Hàng_VuViec

Create table KhachHang_VuViec(
KhachHangId varchar(10),
VuViecId varchar(10),
ThoiGianBatDau date,
ThoiGianKetThuc date,
constraint PK_KhachHangId_VuViecId primary key (KhachHangId, VuViecId)
);

-- Tạo bảng PhanLoaivuviec

Create table PhanLoaiVuViec(
MaPhanLoai int identity (1,1) primary key,
TenLoaiViec nvarchar (100)
);

-- tạo bảng phân loại khách hàng

Create table PhanLoaiKhachHang(
MaPhanLoai int identity (1,1) primary key,
LoaiKhachHang nvarchar (100)
);

-- Tạo bảng NhanVien_VuViec

Create table NhanVien_VuViec (
NhanVienId int,
VuViecId varchar (10),
ThoiDiemNhanViec date,
Deadline date,
constraint PK_NhanVien_VuViec primary key (NhanVienId, VuViecId)
);



-- Thiết lập mối quan hệ trong bảng phòng Ban

Alter table PhongBan
add constraint FK_PhongBan_NhanVien foreign key (MaTruongPhong)
references NhanVien(MaNV);

-- Thiết lập mối quan hệ trong bảng nhân viên

Alter table NhanVien
add constraint FK_NhanVien_PhongBan foreign key (MaPhong)
references PhongBan(MaPhong);

Alter table NhanVien
add constraint FK_NhanVien_ChucVu foreign key (MaChucVu)
references ChucVu(MaCV);

Alter table NhanVien
add constraint FK_NhanVien_GiayToCaNhan foreign key (LoaiGTCN)
references GiayToCaNhan(LoaiGT);



-- Thiết lập mối quan hệ trong bảng NhanViec_VuViec


Alter table NhanVien_VuViec
add constraint FK_NhanVien_VuViec_NhanVien foreign key (NhanVienId)
references NhanVien (MaNV);

Alter table NhanVien_VuViec
add constraint FK_NhanVien_VuViec_VuViec foreign key (VuViecId)
references VuViec (MaVuViec);


-- thiết lập mối quan hệ trong bảng vụ việc

Alter table VuViec
add constraint FK_VuViec_PhanLoaiVuViec foreign key (LoaiViecId)
references PhanLoaiVuviec(MaPhanLoai);

-- Thiết lập mối quan hệ trong bảng khách hàng Vu việc

Alter table KhachHang_VuViec
add constraint FK_KhachHang_VuViec_KhachHang foreign key (KhachHangId)
references KhachHang(MaKH);


Alter table KhachHang_VuViec
add constraint FK_KhachHang_VuViec_VuViec foreign key (VuViecId)
references VuViec(MaVuViec);


-- Thiết lập mối quan hệ trong bảng Khach Hang

Alter table KhachHang
add constraint FK_KhachHang_PhanLoaiKhachHang foreign key (LoaiKh)
references PhanLoaiKhachHang (MaPhanLoai);

-- Update dữ liệu 
-- Thêm dữ liệu bảng GiayToCaNhan
Insert into GiayToCaNhan (TenGT)
values ('Chứng minh nhân dân');

Insert into GiayToCaNhan (TenGT)
values ('Căn cước công dân');

Insert into GiayToCaNhan (TenGT)
values ('Hộ Chiếu');






