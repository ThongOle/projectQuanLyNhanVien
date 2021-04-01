Create procedure SP_DanhSachNhanVien
as
Select * from NhanVien;


exec SP_DanhSachNhanVien;

Create procedure SP_ChiTietNhanVien
(
@ma int
)
as
Begin 
Select * from NhanVien where MaNV = @ma;
End;

Create procedure SP_ThemMoiNhanVien
(
@ht nvarchar(100),
@dt varchar(20),
@email varchar(100),
@nvcty date,
@mk varchar(32),
@gt tinyint,
@ngcGTCN date,
@ncGTCN nvarchar(100),
@dc nvarchar(200),
@dob date,
@trinhdo nvarchar(100)
)
as
Begin 
Insert into NhanVien(HoTen, DienThoai, Email, NgayVaoCongTy, MatKhau, GioiTinh, NgayCapGTCN, NoiCapGTCN, DiaChi, NgaySinh, TrinhDo) values (@ht, @dt, @email, @nvcty, @mk, @gt, @ngcGTCN, @ncGTCN, @dc, @dob, @trinhdo);
End;




Create procedure SP_CapNhatNhanVien(
@ht nvarchar(100),
@dt varchar(20),
@email varchar(100),
@nvcty date,
@mk varchar(32),
@gt tinyint,
@ngcGTCN date,
@ncGTCN nvarchar(100),
@dc nvarchar(200),
@dob date,
@trinhdo nvarchar(100),
@ma int
)
as
Begin
Update NhanVien set HoTen = @ht, DienThoai = @dt, Email = @email, NgayVaoCongTy = @nvcty, MatKhau = @mk, GioiTinh = @gt, NgayCapGTCN = @ncGTCN, NoiCapGTCN = @ncGTCN, DiaChi = @dc, NgaySinh = @dob, TrinhDo = @trinhdo where MaNV = @ma;
End;

Alter procedure SP_ThemMoiNhanVien(
@ht nvarchar(100),
@dt varchar(20),
@email varchar(100),
@nvcty date,
@mk varchar(32),
@gt tinyint,
@ngcGTCN date,
@ncGTCN nvarchar(100),
@dc nvarchar(200),
@dob date,
@trinhdo nvarchar(100),
@mq varchar(10),
@mp varchar(10),
@mcv int,
@GTCN int, 
@ma int
)
with encryption 
as
Update NhanVien set HoTen = @ht, DienThoai = @dt, Email = @email, NgayVaoCongTy = @nvcty, MatKhau = @mk, GioiTinh = @gt, NgayCapGTCN = @ncGTCN, NoiCapGTCN = @ncGTCN, DiaChi = @dc, NgaySinh = @dob, TrinhDo = @trinhdo, MaQuyen = @mq , MaPhong = @mp, MaChucVu = @mcv, LoaiGTCN = @GTCN where MaNV = @ma;

Create procedure SP_DeleteEmployee(
@ma int
)
as 
Begin
Delete from NhanVien where MaNV = @ma;
End;



Create procedure SP_ThongTinDangNhap(
@email varchar(50)
)
as
Begin
Select MaNV from NhanVien where Email = @email;
End;

Alter procedure SP_ThongTinDangNhap(
@email varchar(50)
)
as
Select MaNV, MatKhau, HoTen, MaQuyen from NhanVien where Email = @email;

exec SP_ThongTinDangNhap 'Dinvk@tasco.com.vn';

Select MaNV, MatKhau from NhanVien where Email = 'DinVK@tasco.com.vn';

202CB962AC59075B964B07152D234B70

202cb962ac59075b964b07152d234b70

Update NhanVien set MatKhau = '202cb962ac59075b964b07152d234b70';
Select REPLACE ('202CB962AC59075B964B07152D234B70', '202CB962AC59075B964B07152D234B70', '202cb962ac59075b964b07152d234b70');


Create procedure SP_PhanTrang(@soBanGhi int, @soTrang int)
as
Begin 
Declare @dau int , @cuoi int;
set @cuoi = @soTrang*@soBanGhi;
set @dau = @cuoi - @soBanGhi+1;
Select * from (
Select ROW_NUMBER() over (order by MaNV) as STT, MaNV, HoTen, Email, DienThoai, DiaChi, NgaySinh, TrinhDo, GioiTinh, NgayVaoCongTy, MaPhong, MaChucVu, MaQuyen, MatKhau, LoaiGTCN, NoiCapGTCN, NgayCapGTCN from NhanVien) NV where STT between @dau and @cuoi;
end;

Create procedure SP_PhanTrang(@soBanGhi int, @soTrang int, @tuKhoa String nvarchar(100), @maPhong varchar(10))
as
Begin 
Declare @dau int , @cuoi int;
set @cuoi = @soTrang*@soBanGhi;
set @dau = @cuoi - @soBanGhi+1;
Select * from (Select ROW_NUMBER() over (order by MaNV) as STT, MaNV, HoTen, Email, DienThoai, DiaChi, NgaySinh, TrinhDo, GioiTinh, NgayVaoCongTy, MaPhong, MaChucVu, MaQuyen, MatKhau, LoaiGTCN, NoiCapGTCN, NgayCapGTCN from NhanVien) NV where STT between @soBanGhi*(@soTrang-1)+1 and @soTrang*@soBanGhi and ;
end;
go




Select max(MaVuViec) from VuViec;
Select max(MaNV) from NhanVien; 
Select MaNV from NhanVien;
Select MaNV from NhanVien where max(maNV);
exec SP_PhanTrang 15,1

Select * from NhanVien;
Select * from (Select ROW_NUMBER() over (order by MaNV) as STT, MaNV, HoTen, Email, DienThoai, DiaChi, NgaySinh, TrinhDo, GioiTinh, NgayVaoCongTy, MaPhong, MaChucVu, MaQuyen, MatKhau, LoaiGTCN, NoiCapGTCN, NgayCapGTCN from NhanVien) NV where STT between 01 and 15 and MaPhong ='MRK'


 Select * from (Select ROW_NUMBER() over (order by MaNV) as STT, MaNV, HoTen, Email, DienThoai, DiaChi, NgaySinh, TrinhDo, GioiTinh, NgayVaoCongTy, MaPhong, MaChucVu, MaQuyen, MatKhau, LoaiGTCN, NoiCapGTCN, NgayCapGTCN from NhanVien where MaPhong = 'CNTT') NV  where STT between 01 and 15

 Select count (*) from NhanVien where 1=1  and MaPhong = 'CNTT';

 SELECT count(cat_id), main_cat_name, cat_url FROM mf_main GROUP BY main_cat_name, cat_url ORDER BY main_cat_name

 SELECT x.countt, main_cat_name, cat_url FROM mf_main, (select count(*) as countt FROM mf_main) as x ORDER BY main_cat_name

 Select * from NhanVien;

 Select * from VuViec;

 Select VuViecId, NhanvienId, TenVuViec, MoTa, TinhTrang, NguoiGiao, NgayBatDau, Deadline, MucDoId from NhanVien_VuViec, VuViec where VuViecId = MaVuViec and NhanVienId = 103 and TinhTrang = 1 order by Deadline;