-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 04, 2019 lúc 04:28 PM
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
('MB01', 'Bàn 1', 'Góc 9h30'),
('MB02', 'Bàn 2', 'Góc 1h'),
('MB03', 'Bàn 3', 'Góc 2h'),
('MB04', 'Bàn 4', 'Góc 6h'),
('MB05', 'Bàn 5', 'Góc 8h'),
('MB06', 'Bàn 6', 'Góc 7h'),
('MB07', 'Bàn 7', 'Góc 11h'),
('MB08', 'Bàn 8', 'Góc 4h'),
('MB09', 'Bàn 9', 'Góc 3h'),
('MB10', 'Bàn 10', 'Góc 5h');

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
('NLO06', 'Nước Dừa', 18000, 'http://192.168.1.102:86/ordercoffee/image/coconut.png', 'tess');

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
-- Cấu trúc bảng cho bảng `ordertab`
--

CREATE TABLE `ordertab` (
  `maOrder` varchar(50) NOT NULL,
  `maBan` varchar(4) NOT NULL,
  `maThucUong` varchar(5) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGiaOrder` double NOT NULL,
  `ghiChu` varchar(50) DEFAULT NULL,
  `nguoiOrder` varchar(48) DEFAULT NULL,
  `tinhTrang` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ordertab`
--

INSERT INTO `ordertab` (`maOrder`, `maBan`, `maThucUong`, `soLuong`, `donGiaOrder`, `ghiChu`, `nguoiOrder`, `tinhTrang`) VALUES
('-2053638985', 'MB02', 'NEP01', 2, 42000, '', 'user1', 0),
('-2053638985', 'MB02', 'NEP02', 2, 50000, '', 'user1', 0),
('-2053638985', 'MB02', 'NLO04', 1, 19000, '', 'user1', 0),
('-2053638985', 'MB02', 'NLO06', 1, 18000, '', 'user1', 0),
('-2053771255', 'MB02', 'NLO04', 1, 19000, '', 'huyhuynh19', 1),
('-2053771255', 'MB02', 'NLO06', 1, 18000, '', 'huyhuynh19', 1),
('-2137966662', 'MB03', 'COF02', 2, 40000, '', 'huyhuynh', 0),
('-2137966662', 'MB03', 'NEP03', 1, 23000, '', 'huyhuynh', 0),
('-2138252421', 'MB03', 'NLO06', 2, 36000, '', 'huyhuynh19', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`maBan`);

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

--
-- Chỉ mục cho bảng `ordertab`
--
ALTER TABLE `ordertab`
  ADD PRIMARY KEY (`maOrder`,`maBan`,`maThucUong`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
