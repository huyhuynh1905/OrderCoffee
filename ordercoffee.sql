-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 19, 2019 lúc 05:49 PM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ordercoffee`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `maBan` varchar(4) NOT NULL,
  `tenBan` varchar(10) DEFAULT NULL,
  `moTa` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`maBan`, `tenBan`, `moTa`) VALUES
('MB01', NULL, 'Góc 9h'),
('MB02', NULL, 'Góc 1h'),
('MB03', NULL, 'Góc 2h'),
('MB04', NULL, 'Góc 6h'),
('MB05', NULL, 'Góc 8h'),
('MB06', NULL, 'Góc 7h'),
('MB07', NULL, 'Góc 11h'),
('MB08', NULL, 'Góc 4h'),
('MB09', NULL, 'Góc 3h'),
('MB10', NULL, 'Góc 5h');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoanthanh`
--

CREATE TABLE `hoanthanh` (
  `maDaOrder` varchar(50) NOT NULL,
  `tongGia` double NOT NULL,
  `tinhTrang` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu`
--

CREATE TABLE `menu` (
  `maThucUong` varchar(5) NOT NULL,
  `tenThucUong` varchar(25) NOT NULL,
  `donGia` double NOT NULL,
  `hinhAnh` varchar(500) DEFAULT NULL,
  `ghiChu` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `menu`
--

INSERT INTO `menu` (`maThucUong`, `tenThucUong`, `donGia`, `hinhAnh`, `ghiChu`) VALUES
('COF01', 'Cafe Nóng', 18000, 'http://192.168.1.102:86/ordercoffee/image/coffee-cup.png', NULL),
('COF02', 'Cafe Đá', 20000, 'http://192.168.1.102:86/ordercoffee/image/iced-coffee.png', NULL),
('NEP01', 'Nước Ép Cam', 21000, 'http://192.168.1.102:86/ordercoffee/image/orange.png', NULL),
('NEP02', 'Nước Ép Dâu', 25000, 'http://192.168.1.102:86/ordercoffee/image/strawberry-juice.png', NULL),
('NEP03', 'Nước Nho Ép', 23000, 'http://192.168.1.102:86/ordercoffee/image/grape-juice.png', NULL),
('NEP04', 'Sinh Tố Mãn Cầu', 25000, 'http://192.168.1.102:86/ordercoffee/image/sinhtomancau.png', NULL),
('NGO01', 'CocaCola', 20000, 'http://192.168.1.102:86/ordercoffee/image/beverage.png', NULL),
('NGO02', 'Sting Dâu', 20000, 'http://192.168.1.102:86/ordercoffee/image/sting.png', NULL),
('NGO03', '7 Up', 20000, 'http://192.168.1.102:86/ordercoffee/image/7up.png', NULL),
('NLO01', 'Nước Lọc', 8000, 'http://192.168.1.102:86/ordercoffee/image/water.png', NULL),
('NLO02', 'Trà Đào', 24000, 'http://192.168.1.102:86/ordercoffee/image/tradao.png', NULL),
('NLO03', 'Trà Chanh', 22000, 'http://192.168.1.102:86/ordercoffee/image/tealipton.png', NULL),
('NLO04', 'Nước Chanh Leo', 19000, 'http://192.168.1.102:86/ordercoffee/image/nuocchanh.png', NULL),
('NLO05', 'Sữa Tươi', 18000, 'http://192.168.1.102:86/ordercoffee/image/milk.png', NULL),
('NLO06', 'Nước Dừa', 18000, 'http://192.168.1.102:86/ordercoffee/image/coconut.png', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `username` varchar(48) NOT NULL,
  `password` varchar(48) NOT NULL,
  `hoTen` varchar(50) NOT NULL,
  `namSinh` int(11) NOT NULL,
  `soDienThoai` varchar(10) NOT NULL,
  `diaChi` varchar(60) NOT NULL,
  `chucVu` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`username`, `password`, `hoTen`, `namSinh`, `soDienThoai`, `diaChi`, `chucVu`) VALUES
('huyhuynh', '123456789', 'Huỳnh Huy', 1998, '0966327151', 'Huế', b'1'),
('user1', '123456789', 'Nhân Viên A', 1999, '0932165488', 'SG', b'0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taborder`
--

CREATE TABLE `taborder` (
  `maOrder` varchar(50) NOT NULL,
  `maBan` varchar(4) NOT NULL,
  `maThucUong` varchar(5) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGiaOrder` double NOT NULL,
  `ghiChu` varchar(50) DEFAULT NULL,
  `nguoiOrder` varchar(48) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `taborder`
--

INSERT INTO `taborder` (`maOrder`, `maBan`, `maThucUong`, `soLuong`, `donGiaOrder`, `ghiChu`, `nguoiOrder`) VALUES
('11111111', 'MB01', 'COF01', 2, 36000, NULL, NULL),
('11111111', 'MB01', 'NLO01', 1, 8000, NULL, NULL),
('22222222', 'MB02', 'NGO02', 1, 20000, NULL, NULL),
('22222222', 'MB02', 'NLO06', 2, 36000, NULL, NULL),
('33333333', 'MB05', 'NLO04', 3, 57000, NULL, NULL),
('33333333', 'MB05', 'NLO03', 1, 22000, NULL, NULL),
('44444444', 'MB07', 'NEP04', 1, 25000, NULL, NULL),
('44444444', 'MB07', 'NLO02', 2, 4800, NULL, NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`maBan`);

--
-- Chỉ mục cho bảng `hoanthanh`
--
ALTER TABLE `hoanthanh`
  ADD PRIMARY KEY (`maDaOrder`);

--
-- Chỉ mục cho bảng `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`maThucUong`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
