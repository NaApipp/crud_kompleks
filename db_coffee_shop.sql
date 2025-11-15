-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Nov 2025 pada 02.01
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_coffee_shop`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `kode` int(11) NOT NULL,
  `nama_produk` varchar(599) NOT NULL,
  `harga_produk` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`kode`, `nama_produk`, `harga_produk`) VALUES
(1, 'Pisang Goreng', '2000'),
(2, 'Nasi Goreng', '20000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_checkout`
--

CREATE TABLE `transaksi_checkout` (
  `id` int(11) NOT NULL,
  `meja` varchar(20) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `tanggal_pembelian` varchar(599) NOT NULL,
  `kode_produk` varchar(20) DEFAULT NULL,
  `nama_produk` varchar(100) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi_checkout`
--

INSERT INTO `transaksi_checkout` (`id`, `meja`, `nama`, `tanggal_pembelian`, `kode_produk`, `nama_produk`, `harga`, `qty`) VALUES
(1, '12', 'dfsdfsd', '0', '123', 'Kopi Hitam', 200000, 1),
(2, '12', 'dfsdfsd', '0', '123', 'Kopi Hitam', 200000, 1),
(3, '12', 'Apip', '0', '122', 'Kopi Arabica', 25000, 1),
(4, '12', 'Apip', '0', '2', 'Mendoan', 2000, 1),
(5, '12', 'Apip', '0', '3', 'Nasi Goreng', 20000, 1),
(6, '12', 'Apip', '0', '2', 'Nasi Goreng', 20000, 1),
(7, '12', 'Apip', '0', '1', 'Pisang Goreng', 2000, 1),
(8, '5', 'King', '0', '2', 'Nasi Goreng', 20000, 1),
(9, '5', 'King', '0', '2', 'Nasi Goreng', 20000, 1),
(10, '5', 'King', '0', '2', 'Nasi Goreng', 20000, 1),
(11, '122', 'Awww', 'Selasa 23 Oktober', '2', 'Nasi Goreng', 20000, 1),
(12, '122', 'Awww', 'Selasa 23 Oktober', '2', 'Nasi Goreng', 20000, 1),
(13, '122', 'Awww', 'Selasa 23 Oktober', '1', 'Pisang Goreng', 2000, 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `transaksi_checkout`
--
ALTER TABLE `transaksi_checkout`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `produk`
--
ALTER TABLE `produk`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `transaksi_checkout`
--
ALTER TABLE `transaksi_checkout`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
