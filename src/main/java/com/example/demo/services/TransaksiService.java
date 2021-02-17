package com.example.demo.services;

import java.util.*;

import com.example.demo.model.Transaksi;

public interface TransaksiService {
	List<Transaksi> listTransaksi();
	
	Transaksi saveOrUpdate(Transaksi transaksi);

    Transaksi getIdTransaksi(Integer id);

    void hapusIdTransaksi(Integer id);
}
